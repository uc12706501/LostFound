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
		<td>操作</td>
	</thead>
	<tbody>
		<s:iterator value="items" var="item">
			<tr>
				<td><s:url action="details" namespace="/item" var="detailsUrl" escapeAmp="false">
						<s:param name="clazz" value="clazz"></s:param>
						<s:param name="id" value="id"></s:param>
					</s:url> <a href='<s:property value="detailsUrl"/>'><s:property
							value="name" /></a></td>
				<td><s:property value="location" /></td>
				<td><s:date name="time" /></td>
				<td><s:if test="status.toString()=='HAS_FOUND'">
						<i class="fa fa-check"></i>已找到
					</s:if> <s:else>
						<i class="fa fa-times"></i>未找到
					</s:else></td>
				<td><s:url action="switchStatus" namespace="/item"
						var="switchUrl" escapeAmp="false">
						<s:param name="clazz" value="clazz"></s:param>
						<s:param name="id" value="id"></s:param>
					</s:url> <a class="btn btn-info" href="<s:property value="switchUrl"/>">切换状态</a></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
