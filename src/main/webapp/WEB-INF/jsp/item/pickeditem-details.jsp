<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<title>招领详情</title>
<s:head />

<body>

	<div class="container-maincontent">
		<div class="container">
			<div class="well">
				<div class="row">
					<div class="col-md-8">
						<img alt="" class="img-responsive"
							src="http://placehold.it/750x500">
					</div>
					<div class="col-md-4">
						<h3>招领物品</h3>

						<p>
							<s:property value="pickedItem.name" />
						</p>
						<h3>物品详情</h3>
						<ul>
							<li>拾获地点：<s:property value="pickedItem.location" /></li>
							<li>拾获时间：<s:property value="pickedItem.time" /></li>
							<li>招领信息来源：<s:property value="pickedItem.infoSource" /></li>
							<li>联系地址：<s:property value="pickedItem.address" /></li>
							<li>联系电话：<s:property value="pickedItem.telphone" /></li>
							<li>备注：<s:property value="pickedItem.remark" /></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="well">
				<div class="text-right">
					<a class="btn btn-success" href="#leavemsg">我要留言</a>

				</div>
				<hr>
				<div class="row">
					<div class="col-md-12">
						匿名用户 <span class="pull-right">10天前</span>

						<p>楼主的失物找到没</p>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-12">
						匿名用户 <span class="pull-right">12天前</span>

						<p>我今天在公教见到一个，不知道是不是楼主的，请联系我。</p>

					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-md-12">
						张三 <span class="pull-right">15天前</span>

						<p>谢谢大家，东西已经找到了</p>
					</div>
				</div>
			</div>
		</div>

		<!--提取为一个用户组件-->
		<div class="container" id="leavemsg">
			<div class="well">
				<s:form cssClass="form-horizontal" method="post" action="save"
					namespace="/message" theme="simple">
					<s:hidden name="itemId" value="%{pickedItem.id}"></s:hidden>
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
			</div>
		</div>

		<!-- /.container -->
	</div>
</body>