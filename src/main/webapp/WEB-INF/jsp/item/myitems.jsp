<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:if test="clazz=='lostItem'">
	<s:set name="subTitle" value="'我的失物信息'"></s:set>
</s:if>
<s:elseif test="clazz=='pickedItem'">
	<s:set name="subTitle" value="'我的招领信息'"></s:set>
</s:elseif>
<table class="table">
	<thead>
		<td>物品名称</td>
		<td>地点</td>
		<td>发布时间</td>
		<td>当前状态</td>
	</thead>
	<tbody>
		<s:iterator value="items" var="item">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="location" /></td>
				<td><s:date name="time" /></td>
				<td></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
