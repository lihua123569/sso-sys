package com.sso.sys.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.kisso.SSOConfig;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.SSOToken;
import com.baomidou.kisso.common.encrypt.SaltEncoder;
import com.baomidou.kisso.common.util.RandomUtil;
import com.baomidou.kisso.web.waf.request.WafRequestWrapper;
import com.sso.sys.common.enums.UserType;
import com.sso.sys.common.plugs.vcode.captcha.MyCaptcha;
import com.sso.sys.common.plugs.vcode.generator.Generator;
import com.sso.sys.common.plugs.vcode.generator.PngVCGenerator;
import com.sso.sys.entity.User;
import com.sso.sys.request.UserReq;
import com.sso.sys.service.IUserService;

@Controller
@RequestMapping(value="/account")
public class AccountController extends BaseController{

	@Autowired
	IUserService userService;
	
	/**
	 * 
	 * @param userReq
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doRegist",method=RequestMethod.POST,produces="text/html;charset=UTF-8")  
	public String doRegist(UserReq userReq,HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) throws Exception{
		if (isPost()) {
			User user = new User();
			user.setName(userReq.getName());
			User existUser = userService.selectOne(user);
			if (existUser == null) {
				/* 演示不验证表单，用户名作为密码盐值 */
				user.setPassword(SaltEncoder.md5SaltEncode(userReq.getName(), userReq.getPassword()));				
				user.setType(UserType.MEMBER.key());
				user.setCrTime(new Date());
				user.setLastTime(userReq.getCrTime());
				boolean rlt = userService.insertSelective(user);
				if (rlt) {
					/*
					 * 注册成功，自动登录进入后台
					 */
					SSOToken st = new SSOToken(request);
					st.setId(user.getId());
					st.setData(user.getName());
					SSOHelper.setSSOCookie(request, response, st, true);
					return "/index";//注册完成后直接登录
				}
			} else {
				map.put("errorMsg", "注册用户名【" + user.getName() + "】已存在！");
			}
		}else{
			map.put("errorMsg", "用户或密码错误！");
		}
		return "/app/regist";
	}
	
	@RequestMapping(value="/doLogin",method=RequestMethod.POST,produces="text/html;charset=UTF-8")  
	public String doLogin(UserReq userReq,HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) throws Exception{
		if (isPost()) {
			String errorMsg = "用户名或密码错误";
			/**
			 * 过滤 XSS SQL 注入
			 */
			WafRequestWrapper wr = new WafRequestWrapper(request);
			String ctoken = wr.getParameter("ctoken");
			String captcha = wr.getParameter("captcha");
			User user2 = new User();
			user2.setName(userReq.getName());
			MyCaptcha myCaptcha = new MyCaptcha();
			if (StringUtils.isNotBlank(ctoken) 
					&& StringUtils.isNotBlank(captcha)
					&& myCaptcha.verification(ctoken, captcha)
					) {
				String loginName = wr.getParameter("name"); 
				String password = wr.getParameter("password");
				/**
				 * <p>
				 * 用户存在，签名合法，登录成功
				 * <br>
				 * 进入后台
				 * </p>
				 */
				User user = userService.selectOne(user2);
				if (user != null && SaltEncoder.md5SaltValid(loginName, user.getPassword(), password)) {
					SSOToken st = new SSOToken(request);
					st.setId(user.getId());
					st.setData(loginName);
					
					// 记住密码，设置 cookie 时长 1 周 = 604800 秒
					String rememberMe = wr.getParameter("rememberMe");
					if ("on".equals(rememberMe)) {
						request.setAttribute(SSOConfig.SSO_COOKIE_MAXAGE, 604800);
					}
					
					SSOHelper.setSSOCookie(request, response, st, true);
					return "/index";
				}
			}else if(StringUtils.isBlank(ctoken)&& StringUtils.isBlank(captcha)){

				String loginName = wr.getParameter("name"); 
				String password = wr.getParameter("password");
				/**
				 * <p>
				 * 用户存在，签名合法，登录成功
				 * <br>
				 * 进入后台
				 * </p>
				 */
				User user = userService.selectOne(user2);
				if (user != null && SaltEncoder.md5SaltValid(loginName, user.getPassword(), password)) {
					SSOToken st = new SSOToken(request);
					st.setId(user.getId());
					st.setData(loginName);
					
					// 记住密码，设置 cookie 时长 1 周 = 604800 秒
					String rememberMe = wr.getParameter("rememberMe");
					if ("on".equals(rememberMe)) {
						request.setAttribute(SSOConfig.SSO_COOKIE_MAXAGE, 604800);
					}
					
					SSOHelper.setSSOCookie(request, response, st, true);
					return "/index";
				}
			
			}
			else {
				errorMsg = "验证码错误";
			}
			map.put("errorMsg", errorMsg);
		}
		map.put("ctoken", RandomUtil.get32UUID());
		return "/app/login";
	} 
	
	
	@RequestMapping(value="/ajax/getValideCode",method=RequestMethod.POST,produces="text/plain;charset=UTF-8")  
	@ResponseBody
	public void getValideCode(UserReq userReq,String ctoken,HttpServletRequest request,HttpServletResponse response) throws Exception{
	        Integer height = 40;//image 高度。  image height. count as pixel
	        Integer width = 200;//image 宽度。 image width. count as pixel
	        Integer count = 5;  // validation code length.
	        Generator generator  = new PngVCGenerator(width, height, count);//   gif
	        MyCaptcha myCaptcha = new MyCaptcha();
	        if(StringUtils.isNotBlank(ctoken)){//第一次无验证码登录，第二次以上登录有验证码登录，验证码放缓存里，时间为1分钟
	        	myCaptcha.generate( generator.text(), ctoken);//保存验证码:key
	        }
			response.setContentType("image/jpg"); //设置返回的文件类型 
			ServletOutputStream out = response.getOutputStream();
			generator.write2out(out);
			out.flush();
			out.close();
	} 
	
}
