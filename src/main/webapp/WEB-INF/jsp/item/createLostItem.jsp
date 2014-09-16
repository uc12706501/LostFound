<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:head />
<title>编辑失物信息</title>

<div class="container-maincontent">
	<div class="container">
		<div class="well">
			<s:form theme="simple" action="saveLostItem" namespace="/item"
				method="post" cssClass="form-horizontal"
				enctype="multipart/form-data">
				<fieldset>
					<legend class="text-center header">失物详情</legend>
					<div class="form-group">
						<label class="col-md-2 control-label">失物名称</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="item.name"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="item.name"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">遗失地点</label>

						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="item.location"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="item.location"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<!-- TODO 修复同时显示转换错误和输入校验的错误 -->
						<label class="col-md-2 control-label">遗失时间</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="item.time"
								placeholder="日期格式为 2014/8/1"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="item.time"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">失物特点</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="item.character"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="item.character"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">失物图片</label>
						<div class="col-md-8">
							<s:file id="exampleInputFile" name="upload"></s:file>
							<p class="help-block">请选择 .jpg .png格式的图片，大小不超过2M</p>
							<div class="col-md-2">
								<s:fielderror fieldName="upload"></s:fielderror>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">失主姓名</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="item.ownerName"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="item.ownerName"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">失主联系地址</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="item.address"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="item.address"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">失主联系电话</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="item.telphone"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="item.telphone"></s:fielderror>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">备注</label>
						<div class="col-md-8">
							<s:textarea cssClass="form-control" rows="5" name="item.remark"></s:textarea>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="item.remark"></s:fielderror>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-8 col-md-offset-2">
							<input class="btn btn-success" type="submit" value="提交" />
						</div>
					</div>
				</fieldset>
			</s:form>
			<s:debug />
		</div>

		<!--这里填充内容-->
	</div>

	<!-- /.container -->
</div>
