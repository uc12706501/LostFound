<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<hr>
<div class="row">
	<div class="col-md-12">
		<s:if test="parameters.msg.editorName==null">匿名用户</s:if>
		<s:else>
			<s:property value="parameters.msg.editorName"></s:property>
		</s:else>
		<span class="pull-right"><s:date name="parameters.msg.time"
				nice="true"></s:date></span>
		<p>
			<s:property value="parameters.msg.content"></s:property>
		</p>
	</div>
</div>