<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>

<s:head />

<title><s:text name="admin.anno.create.title"></s:text></title>

<body>
	<s:form cssClass="form-horizontal" role="form" action="confirmCreate"
		method="post" enctype="multipart/form-data" theme="simple">
		<s:hidden name="id" value="%{id}"></s:hidden>
		<div class="form-group">
			<label class="col-sm-2 control-label"><s:text
					name="admin.anno.picUrl"></s:text></label>
			<div class="col-sm-6">
				<s:file name="upload" cssStyle="position:relative;"></s:file>
			</div>
			<div class="col-sm-4">
				<label style="padding-top: 7px;"> <s:fielderror
						fieldName="upload"></s:fielderror></label>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">当前图片</label>
			<div class="col-sm-6">
				<s:url action="getImage" namespace="/admin/announcement"
					var="imageLink">
					<s:param name="id" value="%{id}" />
				</s:url>
				<img alt="anno pic" src='<s:property value="imageLink"/>'
					style="max-width: 100%;width: auto;">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label"><s:text
					name="admin.anno.dispaly"></s:text></label>
			<div class="col-sm-6">
				<div class="checkbox">
					<label> <s:checkbox name="display"
							cssStyle="position:relative;"></s:checkbox></label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-info">
					<s:text name="admin.anno.btn.submit"></s:text>
				</button>
			</div>
		</div>
	</s:form>
</body>
