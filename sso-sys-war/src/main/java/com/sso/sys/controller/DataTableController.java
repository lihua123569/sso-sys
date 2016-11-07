package com.sso.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sso.sys.common.utils.PageUtils;
import com.sso.sys.common.utils.ResultHandle;
import com.sso.sys.entity.User;
import com.sso.sys.request.PageReq;
import com.sso.sys.response.PageRes;
import com.sso.sys.service.IUserService;

@Controller
@RequestMapping(value="/dtable")
public class DataTableController {

	
	@Autowired
	private IUserService userService;
	
	/**
	 * {
  "draw": 1,
  "recordsTotal": 57,
  "recordsFiltered": 57,
  "data": [
    [
      "1",
      "lihua",
      "20"
    ],
    [
      "2",
      "lisa",
      "25"
    ]
  ]
}
	 * data-grid restful
	 * @param request
	 * @param m
	 * @return
	 */ 
	@RequestMapping(value="/getData", produces="text/html;charset=UTF-8")  
	@ResponseBody
	public String getDataGrid(PageReq pageReq,HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) throws Exception{
		System.out.println(pageReq.getId()+"----------"+request.getParameter("beginDate")+"-------"+request.getParameter("iDisplayStart"));
		System.out.println( "----------"+request.getParameter("search[value]"));
		PageUtils<User> page = new PageUtils<>(pageReq.getStart(),pageReq.getLength(),pageReq.getId()) ;
		Page<User> userList = userService.selectPage(page,null);
		PageRes pageRes = new PageRes();
		pageRes.setDraw(pageReq.getDraw());
		pageRes.setRecordsTotal(userList.getTotal()+"");
		pageRes.setRecordsFiltered(userList.getTotal()+"");
		pageRes.setData(userList.getRecords());
		String jsonString2 = JSON.toJSONString(pageRes);  
        System.out.println("jsonString2:" + jsonString2);
        map.put("jsonString2", jsonString2);
        Map<String,Object> resMap = ResultHandle.success();
		resMap.put("jsonString2", jsonString2);
		return jsonString2;
	} 
	
	
}
