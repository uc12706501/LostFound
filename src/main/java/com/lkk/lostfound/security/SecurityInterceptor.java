package com.lkk.lostfound.security;

import java.util.Arrays;
import java.lang.reflect.*;
import com.lkk.lostfound.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class SecurityInterceptor extends AbstractInterceptor {

	public static final String USER_OBJECT = "user";
	public static final String NO_LOGON_RESULT = "notLogon";
	public static final String NO_PERMISSION_RESULT = "noPermission";

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user = (User) invocation.getInvocationContext().getSession()
				.get(USER_OBJECT);
		Object action = invocation.getAction();
		ActionProxy proxy = invocation.getProxy();
		Method method = action.getClass().getMethod(proxy.getMethod());
		RequiresAuthentication methodAnnotation = method
				.getAnnotation(RequiresAuthentication.class);

		if (methodAnnotation != null && user == null)
			return NO_LOGON_RESULT;
		if (methodAnnotation != null && user != null
				&& !validate(user, methodAnnotation))
			return NO_PERMISSION_RESULT;
		return invocation.invoke();
	}

	// 判断是否能够通过验证
	public boolean validate(User user, RequiresAuthentication method) {
		if (null != method
				&& Arrays.asList(method.value()).contains(user.getRole()))
			return true;
		return false;
	}
}
