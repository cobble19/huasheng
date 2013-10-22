package com.cobble.huasheng.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware, SessionAware, ServletResponseAware{
	public HttpServletRequest request;
	public HttpServletResponse response;
	public Map session;
	// for extjs
	private Long _dc;
	private Integer page;
	private Integer start;
	private Integer limit;
	private Boolean success = true;
	

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Long get_dc() {
		return _dc;
	}

	public void set_dc(Long _dc) {
		this._dc = _dc;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}


}
