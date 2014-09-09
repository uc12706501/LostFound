<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<head>
<title>首页</title>
</head>

<body>

	<!--搜索框-->
	<div class="row">
		<div class="well well-index" style="background:none;box-shadow:none;">
			<form class="form-inline">
				<div class="form-group" style="width:auto;">
					<select class="form-control">
						<option>搜索失物</option>
						<option>搜索招领</option>
					</select>
				</div>
				<div class="form-group multi-search">
					<div class="input-group">
						<input class="form-control" type="text"> <span
							class="input-group-btn">
							<button class="btn btn-header" type="button">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!--切换标签-->
	<div class="row">
		<div class="col-sm-12">
			<ul class="nav nav-tabs" role="tablist">
				<li class="active" role="tab"><a data-toggle="tab" href="#row1"><b>失物信息</b></a></li>
				<li role="tab"><a data-toggle="tab" href="#row2"><b>招领信息</b></a>
				</li>
			</ul>
		</div>
	</div>

	<!-- 物品列表 -->
	<div class="tab-content">
		<!--第一个标签-->
		<div class="tab-pane active" id="row1">

			<s:component template="displayitems.jsp">
				<s:param name="items" value="%{lostItems}"></s:param>
				<s:param name="clazz" value="%{'lostItem'}"></s:param>
			</s:component>

			<!--更多按钮-->
			<div class="row">
				<div class="col-sm-12 ">
					<div align="center">
						<div class="pagination">
							<a class="btn btn-header btn-warning" href="#"><b>更多失物信息</b></a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--第二个标签-->
		<div class=" tab-pane" id="row2">
			<div class="tab-content">
				<div class="tab-pane active" id="row1">
					<s:component template="displayitems.jsp">
						<s:param name="items" value="pickedItems"></s:param>
						<s:param name="clazz" value="'pickedItem'"></s:param>
					</s:component>
				</div>

				<!--更多按钮-->
				<div class="row">
					<div class="col-sm-12 ">
						<div align="center">
							<div class="pagination">
								<a class="btn btn-header btn-warning" href="#"><b>更多招领信息</b></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
