<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<ul class="pagination">
	<!-- 首页按钮 -->
	<s:url action="%{parameters.action}" namespace="/item" var="first">
		<s:param name="pageIndex" value="1"></s:param>
	</s:url>
	<li
		class='<s:if test="parameters.pagedList.pageIndex==1">disabled</s:if>'><a
		href='<s:property value="first"/>'>«</a></li>

	<!-- 中间的页码 -->
	<s:iterator begin="parameters.pagedList.firstPage"
		end="parameters.pagedList.lastPage" var="index">
		<s:url action="%{parameters.action}" namespace="/item" var="link">
			<s:param name="pageIndex" value="%{top}"></s:param>
		</s:url>
		<li
			class='<s:if test="parameters.pagedList.pageIndex==#index">active</s:if>'><a
			href='<s:property value="link"/>'><s:property value="%{top}" /></a></li>
	</s:iterator>

	<!-- 尾页按钮 -->
	<s:url action="%{parameters.action}" namespace="/item" var="last">
		<s:param name="pageIndex" value="parameters.pagedList.pageCount"></s:param>
	</s:url>
	<li
		class='<s:if test="parameters.pagedList.pageIndex==parameters.pagedList.pageCount">disabled</s:if>'><a
		href='<s:property value="last"/>'>»</a></li>
</ul>

