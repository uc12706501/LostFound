<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container-maincontent">
	<div class="container">

		<s:component template="displayitems.jsp">
			<s:param name="items" value="items.items"></s:param>
			<s:param name="clazz" value="clazz"></s:param>
		</s:component>

		<div class="row">
			<div class="col-sm-12 ">
				<div align="center">
					<s:component template="pagination.jsp">
						<s:param name="pagedList" value="items"></s:param>
						<s:param name="action"
							value="clazz.equals('lostItem')?'lostItems':'pickedItems'"></s:param>
					</s:component>
				</div>
			</div>
		</div>

		<!--这里填充内容-->
	</div>

	<!-- /.container -->
</div>
