<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<title>招领详情</title>
<s:head />

<body>

	<div class="container-maincontent">
		<div class="container">
			<div class="well">
				<div class="row">
					<div class="col-md-8">
						<s:url action="getImage" namespace="/item" var="picUrl">
							<s:param name="id" value="%{pickedItem.id}"></s:param>
						</s:url>
						<img alt="" class="img-responsive"
							src='<s:property value="%{#picUrl}"></s:property>'>
					</div>
					<div class="col-md-4">
						<h3>招领物品</h3>

						<p>
							<s:property value="pickedItem.name" />
						</p>
						<h3>物品详情</h3>
						<ul>
							<li>拾获地点：<s:property value="pickedItem.location" /></li>
							<li>拾获时间：<s:property value="pickedItem.time" /></li>
							<li>招领信息来源：<s:property value="pickedItem.infoSource" /></li>
							<li>联系地址：<s:property value="pickedItem.address" /></li>
							<li>联系电话：<s:property value="pickedItem.telphone" /></li>
							<li>备注：<s:property value="pickedItem.remark" /></li>
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
				<s:iterator value="pickedItem.messages" var="msg">
					<s:component template="showmsg.jsp">
						<s:param name="msg" value="%{#msg}"></s:param>
					</s:component>
				</s:iterator>
			</div>
		</div>

		<!--提取为一个用户组件-->
		<div class="container" id="leavemsg">
			<div class="well">
				<s:component template="addmsg.jsp">
					<s:param name="itemId" value="pickedItem.id"></s:param>
					<s:param name="clazz" value="'pickedItem'"></s:param>
				</s:component>
			</div>
		</div>

	</div>
</body>