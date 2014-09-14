<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container-maincontent">
	<div class="container container-logon">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="alert alert-danger">
					<p class="text-center">对不起，需要登录之后才能执行该操作！</p>
				</div>

				<s:url action="index" namespace="/" var="indexUrl"></s:url>
				<a class="btn btn-info" style="float: left;"
					href="<s:property value="indexUrl"/>"><<返回首页</a>
				<s:url action="logon" namespace="/user" var="logonUrl"></s:url>
				<a class="btn btn-info" style="float: right;"
					href="<s:property value="logonUrl"/>">前往登录>></a>
			</div>
		</div>
	</div>
</div>