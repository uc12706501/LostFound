package com.lkk.lostfound.action;

import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;
import com.opensymphony.xwork2.ActionSupport;

public class AdminIndexAction extends ActionSupport {
	@Override
	@RequiresAuthentication(UserRole.Admin)
	public String execute() throws Exception {
		return SUCCESS;
	}
}
