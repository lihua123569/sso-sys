package com.sso.sys.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.baomidou.kisso.common.encrypt.SaltEncoder;
import com.sso.sys.common.enums.UserType;
import com.sso.sys.entity.User;
import com.sso.sys.service.IUserService;

@Controller
@RequestMapping(value = "/upload")
public class UploadController extends BaseController {
	@Autowired
	IUserService userService;
	
	@RequestMapping(value = "/uploadFile", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			Map<String, Object> resMap) throws IOException {

		System.out.println("开始");
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		User user = new User();
		user.setId(28903L);
		user.setName("ddddddd");
		user.setPassword(SaltEncoder.md5SaltEncode("ddddddd", "ddddddd"));				
		user.setType(UserType.MEMBER.key());
		user.setCrTime(new Date());
		user.setLastTime(new Date());
		userService.insertSelective(user);
		
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
	/*	List list = null;
		list.add("d");*/
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("success", 0);
		}
		resMap.put("success", 1);
		List list = null;
		list.add("d");
		
		return JSON.toJSONString(resMap);
	}
	@RequestMapping(value = "/uploadDemo", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String uploadDemo(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			Map<String, Object> resMap) throws IOException {
		
		System.out.println("开始");
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		Long long1 = 11111111111111L;
		List list = null;
		list.add("d");
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resMap.put("fileUrl", request.getContextPath() + "/upload/" + fileName);
		
		return JSON.toJSONString(resMap);
	}

	@RequestMapping(value = "/uploadImg")
	@ResponseBody
	public Object uploadApk(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (file != null) {
			// 获取保存的路径，
			String realPath = request.getSession().getServletContext().getRealPath("/upload");
			if (file.isEmpty()) {
				// 未选择文件
				resMap.put("status", "StatusConstants.STATUS_PARM_IS_EMPTY");
			} else {
				// 文件原名称
				String originFileName = file.getOriginalFilename();
				try {
					// 这里使用Apache的FileUtils方法来进行保存
					FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, originFileName));
					resMap.put("status", "StatusConstants.STATUS_OK");
				} catch (IOException e) {
					System.out.println("文件上传失败");
					resMap.put("status", "StatusConstants.STATUS_EXECPTION");
					e.printStackTrace();
				}
			}

		}
		return resMap;
	}

}
