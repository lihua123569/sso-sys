package com.sso.sys.response;

import java.util.List;
import java.util.Map;

import com.sso.sys.entity.User;

public class PageRes {

	private Integer draw;
	private String recordsTotal;
	private String recordsFiltered;
	private List<User> data;
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public String getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(String recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public String getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(String recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<User> getData() {
		return data;
	}
	public void setData(List<User> data) {
		this.data = data;
	}
	
	 
	
}
