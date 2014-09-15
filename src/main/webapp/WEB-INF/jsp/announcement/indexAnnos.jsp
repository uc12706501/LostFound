<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>


<div class="container-alternate" id="top"
	style="background:#EF9C21;padding-top:4.5em">
	<div class="container">
		<div class="carousel slide" data-ride="carousel" id="myCarousel">

			<!-- Carousel indicators -->
			<ol class="carousel-indicators">
				<s:iterator value="ids" status="st">
					<li class='<s:if test="#st.index==0">active</s:if>'
						data-slide-to='<s:property value="%{#st.index}"/>'
						data-target="#myCarousel"></li>
				</s:iterator>
				<s:if test="ids.size==0">
					<li class="active" data-slide-to="1" data-target="#myCarousel"></li>
				</s:if>
			</ol>

			<!-- Carousel items -->
			<div class="carousel-inner">
				<s:iterator value="ids" status="st">
					<div class="item <s:if test="#st.index==0">active</s:if>">
						<s:url action="getImage" var="imgUrl"
							namespace="/admin/announcement">
							<s:param name="id" value="%{top}"></s:param>
						</s:url>
						<img src='<s:property value="imgUrl"/>' class="full" />
					</div>
				</s:iterator>
				<s:if test="ids.size==0">
					<div class="item active">
						<s:url action="getImage" var="emptyimgUrl"
							namespace="/admin/announcement">
						</s:url>
						<img src='<s:property value="emptyimgUrl"/>' class="full" />
					</div>
				</s:if>
			</div>

			<!-- Carousel nav -->
			<a class="carousel-control left" data-slide="prev" href="#myCarousel"><span
				class="glyphicon glyphicon-chevron-left"></span></a> <a
				class="carousel-control right" data-slide="next" href="#myCarousel"><span
				class="glyphicon glyphicon-chevron-right"></span></a>
		</div>
	</div>
</div>