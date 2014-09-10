<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title><decorator:title></decorator:title></title>
<meta content="width=device-width,initial-scale=1.0" name="viewport">
<link href='<s:url value="/styles/css/bootstrap.min-front.css"></s:url>'
	rel="stylesheet">
<link href='<s:url value="/styles/css/lighter.css"></s:url>'
	rel="stylesheet">
<link
	href='<s:url value='/styles/font-awesome-4.1.0/css/font-awesome.min.css'></s:url>'
	rel="stylesheet" type="text/css">
<script src='<s:url value="/js/jquery.js"/>'></script>
<script src='<s:url value="/js/bootstrap.min.js"/>'></script>
<decorator:head></decorator:head>

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<img class="img-logo" src='<s:url value="/img/logo1.png"/>'>
			</div>

			<!-- /.navbar-header -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a class="nav-link" href="#features">网站首页</a></li>
					<li><a class="nav-link" href="#tour-head">寻物启事</a></li>
					<li><a class="nav-link" href="#faqs">招领中心</a></li>
					<li><a class="nav-link" href="#about">关于我们</a></li>
					<li>
						<button class="btn btn-warning btn-header" type="button">登陆</button>
					</li>
					<li>
						<button class="btn btn-warning btn-header" type="button">注册</button>
					</li>
				</ul>
			</div>

			<!-- /.navbar-collapse -->
		</div>

		<!-- /.container -->
	</nav>
	<decorator:body></decorator:body>

	<!-- /.container-alternate -->

	<div class="container-about">
		<div class="container">
			<div class="row about">
				<div class="col-md-6 6text-center">
					<div class="row">
						<div class="col-sm-6">
							教务处<br> 后勤管理处<br> 计算机科学与技术学院<br> 校党委学生处
						</div>
						<div class="col-sm-6">
							财务处<br> 学工处
						</div>
					</div>
				</div>
				<div class="col-md-6 6text-center">
					<b>友情链接</b><br> <a href="#">中国矿业大学</a><br> <a href="#">计算机科学与技术学院</a><br>
					<a href="#">研究生院</a><br> <a href="#">后勤饮食服务中心</a>
				</div>

				<!-- /.col-md-10 -->
			</div>

			<!-- /.row -->
		</div>

		<!-- /.container -->
	</div>

	<footer>
		<div class="container clearfix">
			<p class="text-center">Copyright © Acme Corp 2013</p>
		</div>
	</footer>
</body>
</html>
