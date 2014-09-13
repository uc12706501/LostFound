package com.lkk.lostfound.action.user;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.dao.DataIntegrityViolationException;

import com.lkk.lostfound.model.User;
import com.lkk.lostfound.model.UserRole;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

@SuppressWarnings("serial")
public class RegisterAction extends UserActionBase {

	private String account;
	private String password;
	private String confirmPassword;
	private String dispalyName;

	@Override
	@SkipValidation
	public String execute() throws Exception {
		return INPUT;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "account", message = "用户名不可为空", shortCircuit = true),
			@RequiredStringValidator(fieldName = "password", message = "密码不可为空", shortCircuit = true),
			@RequiredStringValidator(fieldName = "confirmPassword", message = "密码不可为空", shortCircuit = true) }, stringLengthFields = {
			@StringLengthFieldValidator(fieldName = "account", minLength = "6", maxLength = "200", message = "账户长度为6-200字符", shortCircuit = true),
			@StringLengthFieldValidator(fieldName = "password", minLength = "6", maxLength = "200", message = "密码长度为6-200字符", shortCircuit = true),
			@StringLengthFieldValidator(fieldName = "dispalyName", minLength = "6", maxLength = "200", message = "昵称长度为6-200字符", shortCircuit = true), })
	public String confirm() {
		if (!password.equals(confirmPassword)) {
			addFieldError("confirmPassword", "两次输入密码不一致");
			return INPUT;
		}

		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setDispalyName(dispalyName);
		user.setRole(UserRole.User);

		try {
			userDao.save(user);
			return SUCCESS;
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			addActionError("该用户名已被注册！");
			return INPUT;
		}
	}

	// getter and setter

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getDispalyName() {
		return dispalyName;
	}

	public void setDispalyName(String dispalyName) {
		this.dispalyName = dispalyName;
	}

}
