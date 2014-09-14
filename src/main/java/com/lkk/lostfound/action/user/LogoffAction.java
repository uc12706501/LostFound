package com.lkk.lostfound.action.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;
import com.lkk.lostfound.security.SecurityInterceptor;
import com.opensymphony.xwork2.ActionSupport;

@RequiresAuthentication(value = { UserRole.Admin, UserRole.User })
public class LogoffAction extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		request.getSession(true).setAttribute(SecurityInterceptor.USER_OBJECT,
				null);
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
}
