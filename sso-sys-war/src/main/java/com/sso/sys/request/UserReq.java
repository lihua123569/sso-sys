package com.sso.sys.request;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 系统用户表
 *
 */
public class UserReq implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 用户ID */
	private Long id;

	/** 用户名 */
	private String name;

	/** 用户年龄 */
	private Integer age;
	/** 邮箱 */
	private String email;

	/** 0、普通用户 1、管理员 */
	private Integer type;

	/** 0、禁用 1、正常 */
	private Integer status;

	/** 创建时间 */
	private Date crTime;

	/** 最后登录时间 */
	private Date lastTime;
	private String password;
	
	private String repassword;


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCrTime() {
		return crTime;
	}

	public void setCrTime(Date crTime) {
		this.crTime = crTime;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

}
