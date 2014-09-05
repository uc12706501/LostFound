<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form cssClass="form-horizontal" method="post" action="save"
	namespace="/message" theme="simple">
	<s:hidden name="itemId" value="%{parameters.itemId}"></s:hidden>
	<s:hidden name="clazz" value="%{parameters.clazz}"></s:hidden>
	<div class="form-group">
		<label class="col-md-2 control-label">姓名(可选)</label>
		<div class="col-md-10">
			<s:textfield cssClass="form-control" name="editorName"></s:textfield>
		</div>
	</div>

	<div class="form-group">
		<label class="col-md-2 control-label">留言内容</label>
		<div class="col-md-10">
			<s:textarea cssClass="form-control" rows="5" name="content"></s:textarea>
			<s:fielderror fieldName="content"></s:fielderror>
		</div>
	</div>

	<div class="form-group">
		<div class="col-md-10 col-md-offset-2">
			<input class="btn btn-success" type="submit" value="提交"></input>
		</div>
	</div>
</s:form>
