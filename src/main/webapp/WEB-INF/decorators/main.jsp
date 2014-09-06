<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<page:applyDecorator name="main-base">
	<head>
<decorator:head></decorator:head>
	</head>
	<body>
		<!-- 滚动图片 -->
		<div class="container-alternate" id="top"
			style="background:#EF9C21;padding-top:4.5em">
			<div class="container">
				<div class="carousel slide" data-ride="carousel" id="myCarousel">

					<!-- Carousel indicators -->
					<ol class="carousel-indicators">
						<s:iterator value="ids" status="st">
							<li class='<s:if test="#st.index==0">active</s:if>'
								data-slide-to='<s:property value="%{#st.index}"/>'
								data-target="#myCarousel"></li>
						</s:iterator>
					</ol>

					<!-- Carousel items -->
					<div class="carousel-inner">
						<s:iterator value="ids" status="st">
							<div class="item <s:if test="#st.index==0">active</s:if>">
								<s:url action="getImage" var="imgUrl"
									namespace="/admin/announcement">
									<s:param name="id" value="%{top}"></s:param>
								</s:url>
								<img src='<s:property value="imgUrl"/>' class="full" />
							</div>
						</s:iterator>
					</div>

					<!-- Carousel nav -->
					<a class="carousel-control left" data-slide="prev"
						href="#myCarousel"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="carousel-control right" data-slide="next"
						href="#myCarousel"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
		</div>
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
							<button class="btn btn-default btn-huge" type="button">
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
							<button class="btn btn-default btn-huge"
								onclick="location.href='http://www.example.com'" type="button">
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
							<button class="btn btn-default btn-huge" type="button">
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