<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 传入一个PagedList，用来渲染一个分页组件 -->
<ul class="pagination">
	<li><a href="#">«</a></li>
	<li><a href="#">1</a></li>
	<li><a href="#">2</a></li>
	<li><a href="#">3</a></li>
	<li><a href="#">4</a></li>
	<li><a href="#">5</a></li>
	<li><a href="#">»</a></li>
</ul>
<ul class="pagination">
	<!-- 首页按钮 -->
	<s:url action="" var="first">
		<s:param name="pageIndex" value="1"></s:param>
	</s:url>
	<li
		class='<s:if test="parameters.pagedList.pageIndex==1">disabled</s:if>'><a
		href='<s:property value="pageIndex"/>'>«</a></li>

	<!-- 中间的页码 -->
	<s:iterator begin="parameters.pagedList.firstPage"
		end="parameters.pagedList.lastPage">
		<s:url>
			<s:param name="pageIndex" value="%{top}" var="link"></s:param>
		</s:url>
		<li><a href='<s:property value="link"/>'><s:property
					value="%{top}" /></a></li>
	</s:iterator>

	<!-- 尾页按钮 -->
	<s:url action="" var="last">
		<s:param name="pageIndex" value="parameters.pagedList.pageCount"></s:param>
	</s:url>
	<li
		class='<s:if test="paramters.pagedList.pageIndex==parameters.pagedList.pageCount">disabled</s:if>'><a
		href="#">»</a></li>
</ul>

