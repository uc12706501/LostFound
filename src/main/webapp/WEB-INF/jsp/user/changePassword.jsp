<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set name="subTitle">修改密码</s:set>

<s:form cssClass="form-horizontal" theme="simple">
	<div class="form-group">
		<label class="col-md-2 control-label">旧密码</label>
		<div class="col-md-6">
			<s:password cssClass="form-control" name="oldPwd"></s:password>
		</div>
		<div class="col-md-4"></div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">新密码</label>
		<div class="col-md-6">
			<s:password cssClass="form-control" name="oldPwd"></s:password>
		</div>
		<div class="col-md-4"></div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">确认密码</label>
		<div class="col-md-6">
			<s:password cssClass="form-control" name="oldPwd"></s:password>
		</div>
		<div class="col-md-4"></div>
	</div>
	<div class="form-group">
		<div class="col-md-6 col-md-offset-2">
			<input type="submit" value="提交" class="btn btn-success" />
		</div>
	</div>
</s:form>
