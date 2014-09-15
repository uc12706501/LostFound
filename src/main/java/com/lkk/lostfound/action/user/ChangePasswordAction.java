package com.lkk.lostfound.action.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.lkk.lostfound.model.User;
import com.lkk.lostfound.model.UserRole;
import com.lkk.lostfound.security.RequiresAuthentication;
import com.lkk.lostfound.security.SecurityInterceptor;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

@SuppressWarnings("serial")
@RequiresAuthentication(value = { UserRole.Admin, UserRole.User })
public class ChangePasswordAction extends UserActionBase implements
		ServletRequestAware {

	private String oldPwd;
	private String newPwd;
	private String confirmPwd;
	private HttpServletRequest request;

	@Override
	@SkipValidation
	public String execute() throws Exception {
		return INPUT;
	}

	public String confirmChange() {
		User user = (User) request.getSession(false).getAttribute(
				SecurityInterceptor.USER_OBJECT);
		if (!user.getPassword().equals(oldPwd)) {
			addActionError("旧密码错误，请重新输入");
			return INPUT;
		}
		userDao.changePasswored(user, newPwd);
		return SUCCESS;
	}

	// getter and setter

	public String getOldPwd() {
		return oldPwd;
	}

	@RequiredStringValidator(message = "请输入旧密码", shortCircuit = true)
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	@RequiredStringValidator(message = "请输入新密码", shortCircuit = true)
	@StringLengthFieldValidator(message = "新密码长度就为6-200字符", minLength = "6", maxLength = "200", shortCircuit = true)
	@FieldExpressionValidator(message = "新密码和旧密码不能相同", expression = "oldPwd!=newPwd", shortCircuit = true)
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	@RequiredStringValidator(fieldName = "confirmPwd", message = "请确认新密码", shortCircuit = true)
	@FieldExpressionValidator(message = "两次输入密码不一致", expression = "confirmPwd==newPwd", fieldName = "confirmPwd", shortCircuit = true)
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}
