<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<s:iterator value="parameters.items" status="st">
		<s:url action="getImage" namespace="/item" var="imgUrl">
			<s:param name="id" value="%{id}"></s:param>
		</s:url>
		<s:url action="details" namespace="/item" var="detailsUrl"
			escapeAmp="false">
			<s:param name="clazz" value="parameters.clazz"></s:param>
			<s:param name="id" value="%{id}"></s:param>
		</s:url>
		<div class="col-md-4 portfolio-item">
			<a href='<s:property value="detailsUrl"/>'> <img alt=""
				class="img-responsive" src='<s:property value="imgUrl"/>'>
			</a>
			<h3>
				<a href='<s:property value="detailsUrl"/>'><s:property
						value="name" /> </a>
			</h3>
			<p>
				<s:property value="remark" />
			</p>
		</div>
		<s:if test="(#st.index)%3==2">
</div>
<div class="row">
	</s:if>
	</s:iterator>
</div>