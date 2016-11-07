package com.sso.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.kisso.common.util.HttpUtil;

public class BaseController {
	public Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpSession session;
	/**
	 * 是否为 post 请求
	 */
	protected boolean isPost() {
		return HttpUtil.isPost(request);
	}
}
