package com.lkk.lostfound.action.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.lkk.lostfound.dao.UserDao;
import com.lkk.lostfound.model.User;
import com.lkk.lostfound.security.SecurityInterceptor;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

@SuppressWarnings("serial")
public class LogonAction extends UserActionBase implements ServletRequestAware {

	HttpServletRequest request;
	private String account;
	private String password;

	@Override
	@SkipValidation
	public String execute() {
		return INPUT;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(message = "请输入用户名", fieldName = "account"),
			@RequiredStringValidator(message = "请输入密码", fieldName = "password") })
	public String confirm() {
		User user = userDao.findByName(account);
		if (user != null && user.getPassword() == password) {
			request.getSession(true).setAttribute(
					SecurityInterceptor.USER_OBJECT, user);
			return SUCCESS;
		}
		addActionError("用户名和密码不匹配");
		return INPUT;
	}

	// getter and setter

	public String getAccount() {
		return account;
	}

	public void setAccount(String name) {
		this.account = name;
	};

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}
}
