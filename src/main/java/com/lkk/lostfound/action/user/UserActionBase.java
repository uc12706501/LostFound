package com.lkk.lostfound.action.user;

import com.lkk.lostfound.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

public class UserActionBase extends ActionSupport {
	protected UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
