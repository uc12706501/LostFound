package com.lkk.lostfound.action.user;

import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;

@SuppressWarnings("serial")
@RequiresAuthentication(value = { UserRole.Admin, UserRole.User })
public class ChangePasswordAction extends UserActionBase {
	@Override
	public String execute() throws Exception {
		return INPUT;
	}
}
