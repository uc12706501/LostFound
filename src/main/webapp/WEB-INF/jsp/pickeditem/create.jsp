<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:head />
<title>编辑招领信息</title>


<div class="container-maincontent">
	<div class="container">
		<div class="well">
			<s:form class="form-horizontal" theme="simple" action="save" method="post"
				namespace="/pickeditem" cssClass="form-horizontal"
				enctype="multipart/form-data">
				<fieldset>
					<legend class="text-center header">招领详情</legend>
					<s:hidden name="id"></s:hidden>
					<s:actionmessage />

					<div class="form-group">
						<label class="col-md-2 control-label">招领物品名称</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="name"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="name"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">拾获地点</label>

						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="location"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="location"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<!-- TODO 修复同时显示转换错误和输入校验的错误 -->
						<label class="col-md-2 control-label">拾获时间</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="time"
								placeholder="日期格式为 2014/8/1"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="time"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">物品特点</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="character"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="character"></s:fielderror>
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
							<s:textfield cssClass="form-control" name="infoSource"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="ownnerName"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">认领地址</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="address"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="address"></s:fielderror>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">联系电话</label>
						<div class="col-md-8">
							<s:textfield cssClass="form-control" name="telphone"></s:textfield>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="telphone"></s:fielderror>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">备注</label>
						<div class="col-md-8">
							<s:textarea cssClass="form-control" rows="5" name="remark"></s:textarea>
						</div>
						<div class="col-md-2">
							<s:fielderror fieldName="remark"></s:fielderror>
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
<s:debug />