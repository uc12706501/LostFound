<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container-maincontent">
	<div class="container container-logon">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="alert alert-danger">
					<p class="text-center">
						<b>对不起，您没有该操作的权限，请返回！</b>
					</p>
				</div>

				<s:url action="index" namespace="/" var="indexUrl"></s:url>
				<a class="btn btn-info" style="float: left;"
					href="<s:property value="indexUrl"/>"><<返回首页</a>
			</div>
		</div>
	</div>
</div>