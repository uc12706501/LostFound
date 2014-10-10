<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<page:applyDecorator name="main-base">
	<head>
<decorator:head></decorator:head>
<title><decorator:title></decorator:title></title>
	</head>
	<body>
		<s:action name="getIndexAnnos" namespace="/anno" executeResult="true"></s:action>

		<!-- 介绍栏 -->
		<div class="container-top">
			<div class="container">
				<h3>失物招领网</h3>
				<p>失物招领网是一个专业的词汇学习网站。 失物招领网核心教学理念：
					温故即知新。简单地说，就是将用户需要学习的新词和曾经学过的单词关联起来，变着各种花样重复，同时在学习新知的过程中复习旧识。</p>
			</div>
		</div>

		<!-- 中间的三个大图标 -->
		<div class="container-intro">
			<div class="container">
				<div class="row">

					<!--大图标-->
					<div class="col-md-4">
						<div align="center">
							<s:url action="addLostItem" namespace="/item" var="lostUrl"></s:url>
							<button class="btn btn-default btn-huge" type="button"
								onclick="location.href='<s:property value="lostUrl"/>'">
								<i class="fa fa-search icon-huge"></i>
							</button>
							<div style="height:40px;">
								<p class="icon-p">
									<b>寻找失物</b>
								</p>
							</div>
						</div>
					</div>

					<!--大图标-->
					<div class="col-md-4">
						<div align="center">
							<s:url action="addPickedItem" namespace="/item" var="pickedUrl">
							</s:url>
							<button class="btn btn-default btn-huge"
								onclick="location.href='<s:property value="pickedUrl"/>'"
								type="button">
								<i class="fa fa-eye icon-huge"></i>
							</button>
							<div style="height:40px;">
								<p class="icon-p">
									<b>寻找失主</b>
								</p>
							</div>
						</div>
					</div>

					<!--大图标-->
					<div class="col-md-4">
						<div align="center">
							<s:url action="index" namespace="/" var="indexUrl"></s:url>
							<button class="btn btn-default btn-huge" type="button"
								onClick="location.href='<s:property value="indexUrl"/>'">
								<i class="fa fa-cube icon-huge"></i>
							</button>
							<div class="icon-p">
								<p style="color:#555555;">
									<b>物品集中营</b>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--正文-->
		<div class="container-maincontent">
			<div class="container">
				<decorator:body></decorator:body>
			</div>
		</div>
	</body>
</page:applyDecorator>