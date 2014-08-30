<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set var="title" value="%{getText('admin.anno.index.title')}"></s:set>

<table class="table table-striped">
	<tr>
		<th><s:text name="admin.anno.tablehead.id"></s:text></th>
		<th><s:text name="admin.anno.tablehead.display"></s:text></th>
		<th><s:text name="admin.anno.tablehead.picUrl"></s:text></th>
		<th><s:text name="admin.anno.tablehead.operate"></s:text></th>
	</tr>
	<tbody>
		<s:iterator value="announcements" var="anno">
			<tr>
				<td><s:property value="id"></s:property></td>
				<td><input type="checkbox" disabled="disabled"
					<s:if test="%{#anno.display==true}">checked</s:if>></input></td>
				<td><s:property value="imageUrl"></s:property></td>
				<td><s:url action="create" namespace="/admin/announcement"
						var="link">
						<s:param name="announcementId" value="%{#anno.id}" />
					</s:url> <a href='<s:property value="link"></s:property>'><s:text
							name="admin.anno.link.edit"></s:text></a></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
