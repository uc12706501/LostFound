<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:head />
<title>编辑招领信息</title>


<div class="container-maincontent">
	<div class="container">
		<div class="well">
			<s:form theme="simple" action="save" namespace="/item" method="post"
				cssClass="form-horizontal" enctype="multipart/form-data">
				<s:hidden name="clazz" value="%{clazz}"></s:hidden>
				<fieldset>
					<legend class="text-center header">招领详情</legend>
					<s:actionmessage />

					<div class="form-group">
						<label class="col-md-2 control-label">招领物品名称</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="pickedItem.name"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="pickedItem.name"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">拾获地点</label>

						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="pickedItem.location"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="pickedItem.location"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<!-- TODO 修复同时显示转换错误和输入校验的错误 -->
						<label class="col-md-2 control-label">拾获时间</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="pickedItem.time"
								placeholder="日期格式为 2014/8/1"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="pickedItem.time"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">物品特点</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="pickedItem.character"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="pickedItem.character"></s:fielderror>
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
						<label class="col-md-2 control-label">信息来源</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="pickedItem.infoSource"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="pickedItem.infoSource"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">认领地址</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="pickedItem.address"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="pickedItem.address"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">联系电话</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="pickedItem.telphone"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="pickedItem.telphone"></s:fielderror>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">备注</label>
						<div class="col-md-8">
							<s:textarea cssClass="form-control" rows="5"
								name="pickedItem.remark"></s:textarea>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="pickedItem.remark"></s:fielderror>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-8 col-md-offset-2">
							<input class="btn btn-success" type="submit" value="提交" />
						</div>
					</div>
				</fieldset>
			</s:form>
		</div>

		<!--这里填充内容-->
	</div>

	<!-- /.container -->
</div>
