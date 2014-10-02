<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<s:iterator value="parameters.items" status="st">
		<s:url action="getImage" namespace="/item" var="imgUrl"
			escapeAmp="false">
			<s:param name="id" value="%{id}"></s:param>
			<s:param name="maxHeight" value="400"></s:param>
		</s:url>
		<s:url action="details" namespace="/item" var="detailsUrl"
			escapeAmp="false">
			<s:param name="clazz" value="parameters.clazz"></s:param>
			<s:param name="id" value="%{id}"></s:param>
		</s:url>
		<div class="col-md-4 portfolio-item">
			<div class="index-div-responsive">
				<a href='<s:property value="detailsUrl"/>'> <img
					class="index-image-responsive" alt=""
					src='<s:property value="imgUrl"/>'>
				</a>
			</div>
			<h3>
				<a href='<s:property value="detailsUrl"/>'><s:property
						value="name" /> </a>
			</h3>
			<p>
				<s:date name="time" format="yyyy-MM-dd hh:mm" />
				<s:property value="location" />
			</p>
		</div>
		<s:if test="(#st.index)%3==2">
</div>
<div class="row">
	</s:if>
	</s:iterator>
</div>