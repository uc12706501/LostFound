<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<title>招领详情</title>

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
							<s:property value="name" />
						</p>
						<h3>物品详情</h3>
						<ul>
							<li>拾获地点：<s:property value="location" /></li>
							<li>拾获时间：<s:property value="time" /></li>
							<li>招领信息来源：<s:property value="infoSource" /></li>
							<li>联系地址：<s:property value="address" /></li>
							<li>联系电话：<s:property value="telphone" /></li>
							<li>备注：<s:property value="remark" /></li>
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

		<!--这里填充内容-->
		<div class="container" id="leavemsg">
			<div class="well">
				<form class="form-horizontal" method="post">
					<div class="form-group">
						<label class="col-md-2 control-label">姓名(可选)</label>
						<div class="col-md-10">
							<input class="form-control" type="text"></input>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">留言内容</label>

						<div class="col-md-10">
							<textarea class="form-control" rows="5"></textarea>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-10 col-md-offset-2">
							<input class="btn btn-success" type="submit" value="提交"></input>
						</div>
					</div>
				</form>
			</div>
		</div>

		<!-- /.container -->
	</div>


</body>