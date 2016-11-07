package com.sso.sys.controller;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baomidou.kisso.common.util.RandomUtil;
import com.sso.sys.common.plugs.vcode.generator.Generator;
import com.sso.sys.common.plugs.vcode.generator.GifVCGenerator;
import com.sso.sys.common.plugs.vcode.generator.PngVCGenerator;
import com.sso.sys.common.utils.ResultHandle;
import com.sso.sys.entity.User;
import com.sso.sys.request.PageReq;
import com.sso.sys.request.UserReq;
import com.sso.sys.service.IUserService;

@Controller
@RequestMapping(value="/view")
public class ViewController {
	
	@Autowired
	IUserService userService;
	
	/**
	 * 用户列表界面
	 * @param request
	 * @param m
	 * @return
	 * 伪静态
	 */
	@RequestMapping(value="/user/{k}-{p}",produces="text/html;charset=UTF-8")  
	public String user( @PathVariable("k") String userid,@PathVariable("p") String p,HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<User> userList = userService.selectList(null);
		System.out.println("userid======"+userid);
		Map<String,Object> resMap = ResultHandle.success();
		resMap.put("userList", userList);
		return "/user/userManager";
	}
	
	/**
	 * 用户列表界面 restful
	 * @param request
	 * @param m
	 * @return
	 */ 
	@RequestMapping(value="/user/{userid}",method=RequestMethod.GET,produces="text/html;charset=UTF-8")  
	public String userRest(@PathVariable("userid") String uid,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("userid ---:"+uid);
		List<User> userList = userService.selectList(null);
		Map<String,Object> resMap = ResultHandle.success();
		resMap.put("userList", userList);
		return "/user/userManagerRest";
	} 
	/**
	 * data-grid restful
	 * @param request
	 * @param m
	 * @return
	 */ 
	@RequestMapping(value="/dataGrid/{current}/{rowCount}",method=RequestMethod.GET,produces="text/html;charset=UTF-8")  
	public String dataGrid(@PathVariable("current") String current,@PathVariable("rowCount") String rowCount,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("current ---:"+current);
		System.out.println("rowCount ---:"+rowCount);
		List<User> userList = userService.selectList(null);
		Map<String,Object> resMap = ResultHandle.success();
		resMap.put("userList", userList);
		return "/user/dataGrid";
	} 
	
	/**
	 * datatable restful
	 * @param request
	 * @param m
	 * @return
	 */ 
	@RequestMapping(value="/dataTable",method=RequestMethod.GET,produces="text/html;charset=UTF-8")  
	public String dataGrid(PageReq pageReq,HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) throws Exception{
		return "/dataTable/dataTable";
	} 
	
	/**
	 * datatable restful
	 * @param request
	 * @param m
	 * @return
	 */ 
	@RequestMapping(value="/regist",method=RequestMethod.GET,produces="text/html;charset=UTF-8")  
	public String regist(PageReq pageReq,HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) throws Exception{
		return "/app/regist";
	} 
	 
	/**
	 * 
	 * @param pageReq
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET,produces="text/html;charset=UTF-8")  
	public String login(PageReq pageReq,HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) throws Exception{
		return "/app/login";
	} 
	@RequestMapping(value="/upload",method=RequestMethod.GET,produces="text/html;charset=UTF-8")  
	public String upload(PageReq pageReq,HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) throws Exception{
		return "/upload/upload";
	} 
	@RequestMapping(value="/uploadDemo",method=RequestMethod.GET,produces="text/html;charset=UTF-8")  
	public String uploadDemo(PageReq pageReq,HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) throws Exception{
		return "/upload/uploadDemo";
	} 
}


