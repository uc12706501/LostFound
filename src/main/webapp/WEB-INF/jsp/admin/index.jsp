<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<title>欢迎您</title>
<s:url action="index" namespace="/" var="indexUrl" />
<a class="btn btn-info" href='<s:property value="indexUrl"/>'>返回首页</a>