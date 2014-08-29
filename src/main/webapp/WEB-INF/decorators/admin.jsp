<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><s:text name="admin.title"></s:text></title>
<!-- Bootstrap Core CSS -->
<link href='<s:url value='/styles/css/bootstrap.min.css'></s:url>'
	rel="stylesheet">
<!-- MetisMenu CSS -->
<link
	href="<s:url value='/styles/css/plugins/metisMenu/metisMenu.min.css'/>"
	rel="stylesheet">
<!-- Custom CSS -->
<link href='<s:url value='/styles/css/sb-admin-2.css'></s:url>'
	rel="stylesheet">
<!-- Custom Fonts -->
<link
	href='<s:url value='/styles/font-awesome-4.1.0/css/font-awesome.min.css'></s:url>'
	rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div id="wrapper">
		<!-- 顶部导航条 -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"><s:text
						name="admin.title"></s:text></a>
			</div>
			<!-- /.navbar-header -->
			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> <s:text
									name="admin.headnav.profile"></s:text></a></li>
						<li class="divider"></li>
						<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
								<s:text name="admin.headnav.logout"></s:text></a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control"
									placeholder="<s:text name='admin.text.search'/>"> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="index.html"><i class="fa fa-dashboard fa-fw"></i>
								<s:text name="admin.sidebar.dashboard"></s:text></a></li>
						<li><a href="#"><i class="fa fa-plus fa-fw"></i> <s:text
									name="admin.nav.Announcement"></s:text><span class="fa arrow"></span>
						</a>
							<ul class="nav nav-second-level">
								<li><a
									href='<s:url action="create" namespace="/admin/announcement"></s:url>'><s:text
											name="admin.nav.addAnno"></s:text></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-briefcase fa-fw"></i> <s:text
									name="admin.nav.LostItemManage" /><span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="flot.html"><s:text
											name="admin.nav.LostItemFound"></s:text></a></li>
								<li><a href="morris.html"><s:text
											name="admin.nav.LostItemNotFound"></s:text></a></li>
							</ul> <!-- /.nav-second-level --></li>
						<li><a href="#"><i class="fa fa-group fa-fw"></i> <s:text
									name="admin.nav.PickedItemManage"></s:text><span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="#"><s:text name="admin.nav.OwnerNotFound"></s:text></a></li>
								<li><a href="#"><s:text name="admin.nav.OwnerFound"></s:text></a></li>
							</ul></li>
						<li><a href="#"><i class="fa fa-sitemap fa-fw"></i>
								Multi-Level Dropdown<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="#">Second Level Item</a></li>
								<li><a href="#">Second Level Item</a></li>
								<li><a href="#">Third Level <span class="fa arrow"></span></a>
									<ul class="nav nav-third-level">
										<li><a href="#">Third Level Item</a></li>
										<li><a href="#">Third Level Item</a></li>
										<li><a href="#">Third Level Item</a></li>
										<li><a href="#">Third Level Item</a></li>
									</ul> <!-- /.nav-third-level --></li>
							</ul> <!-- /.nav-second-level --></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						<s:property value="#title" default="Blank Title"></s:property>
					</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<decorator:body />
				</div>
			</div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- jQuery Version 1.11.0 -->
	<script src="<s:url value='/js/jquery-1.11.0.js'></s:url>"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="<s:url value='/js/bootstrap.min.js'></s:url>"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<s:url value='/js/plugins/metisMenu/metisMenu.min.js'></s:url>"></script>
	<!-- Custom Theme JavaScript -->
	<script src="<s:url value='/js/sb-admin-2.js'></s:url>"></script>
</body>
</html>
