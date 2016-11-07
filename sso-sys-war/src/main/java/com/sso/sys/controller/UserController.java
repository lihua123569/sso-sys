package com.sso.sys.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sso.sys.common.utils.ResultHandle;
import com.sso.sys.entity.User;
import com.sso.sys.request.UserReq;
import com.sso.sys.service.IUserService;


@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController{

	@Autowired
	IUserService userService;
	
	/**
	 * 用户信息
	 * @param request
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/ajax/getUser",produces="text/html;charset=UTF-8")  
	@ResponseBody
	public String getUser(Long userid,HttpServletRequest request,HttpServletResponse response) throws Exception{
		LOGGER.info("取用户信息");
		UserReq userReq = new UserReq();
		userReq.setId(userid);
		List<User> userList = userService.selectList(null);
		Map<String,Object> resMap = ResultHandle.success();
		resMap.put("userList", userList);
		return JSON.toJSONString(resMap);
	}
	
}
