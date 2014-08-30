<%@ taglib uri="/struts-tags" prefix="s"%>
<
<s:head />

<s:set var="title" value="%{getText('admin.anno.index.title')}" />

<s:form cssClass="form-horizontal" role="form" action="confirmCreate"
	theme="simple">
	<div class="form-group">
		<label class="col-sm-2 control-label"><s:text
				name="admin.anno.picUrl"></s:text></label>
		<div class="col-sm-6">
			<s:textfield name="imageUrl" cssClass="form-control" />
		</div>
		<div class="col-sm-4">
			<label style="padding-top: 7px;"> <s:fielderror
					fieldName="imageUrl"></s:fielderror></label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label"><s:text
				name="admin.anno.dispaly"></s:text></label>
		<div class="col-sm-6">
			<div class="checkbox">
				<label> <s:checkbox name="display" cssStyle="position:relative;"></s:checkbox></label>
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
