<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<title>失物详情</title>
<s:head />

<body>

	<div class="container-maincontent">
		<div class="container">
			<div class="well">
				<div class="row">
					<div class="col-md-8">
						<s:url action="getImage" namespace="/item" var="picUrl"
							escapeAmp="false">
							<s:param name="id" value="%{lostItem.id}"></s:param>
							<s:param name="maxHeight" value="550"></s:param>

						</s:url>
						<img alt="" class="img-responsive"
							src='<s:property value="%{#picUrl}"></s:property>'>
					</div>
					<div class="col-md-4">
						<h3>遗失物品</h3>

						<p>
							<s:property value="lostItem.name" />
						</p>
						<h3>失物详情</h3>
						<ul>
							<li>遗失地点：<s:property value="lostItem.location" /></li>
							<li>遗失时间：<s:property value="lostItem.time" /></li>
							<li>失主姓名：<s:property value="lostItem.ownerName" /></li>
							<li>联系地址：<s:property value="lostItem.address" /></li>
							<li>联系电话：<s:property value="lostItem.telphone" /></li>
							<li>备注：<s:property value="lostItem.remark" /></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="well">
				<div class="text-right">
					<a class="btn btn-success" href="#leavemsg">我要留言</a>
				</div>
				<s:iterator value="lostItem.messages" var="msg">
					<s:component template="showmsg.jsp">
						<s:param name="msg" value="%{msg}"></s:param>
					</s:component>
				</s:iterator>

			</div>
		</div>

		<!--提取为一个用户组件-->
		<div class="container" id="leavemsg">
			<div class="well">
				<s:component template="addmsg.jsp">
					<s:param name="itemId" value="lostItem.id"></s:param>
					<s:param name="clazz" value="'lostItem'"></s:param>
				</s:component>
			</div>
		</div>

		<!-- /.container -->
	</div>
</body>