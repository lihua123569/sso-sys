package com.sso.sys.request;

import java.util.List;
import java.util.Map;

public class PageReq {

	private Integer draw;
	private Integer start;
	private Integer length;
	private List<Map<String,Object>> sort;
	private String searchPhrase;
	private String id;
	private String total;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Map<String,Object>> getSort() {
		return sort;
	}
	public void setSort(List<Map<String,Object>> sort) {
		this.sort = sort;
	}
	public String getSearchPhrase() {
		return searchPhrase;
	}
	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	 
	  
	
}
