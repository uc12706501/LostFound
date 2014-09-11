<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container-maincontent">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<ul class="nav nav-tabs" role="tablist">
					<s:if test="clazz=='lostItem'">
						<li class="active" role="tab"><a data-toggle="tab" href="#"><b>失物信息</b></a></li>
					</s:if>
					<s:else>
						<li role="tab" class="active"><a data-toggle="tab" href="#"><b>招领信息</b></a></li>
					</s:else>
				</ul>
			</div>
		</div>

		<s:component template="displayitems.jsp">
			<s:param name="items" value="items.items"></s:param>
			<s:param name="clazz" value="clazz"></s:param>
		</s:component>

		<div class="row">
			<div class="col-sm-12 ">
				<div align="center">
					<s:component template="pagination.jsp">
						<s:param name="filter" value="filter"></s:param>
						<s:param name="pagedList" value="items"></s:param>
						<s:param name="action"
							value="clazz.equals('lostItem')?'lostItems':'pickedItems'"></s:param>
						<s:param name="params" value="#{'clazz':clazz}"></s:param>
					</s:component>
				</div>
			</div>
		</div>

		<!--这里填充内容-->
	</div>

	<!-- /.container -->
</div>
