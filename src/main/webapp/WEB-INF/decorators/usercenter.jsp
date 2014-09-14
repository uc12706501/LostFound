<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<page:applyDecorator name="main-base">
	<body>
		<div class="container-maincontent">
			<div class="container container-logon">
				<div class="row">
					<div class="col-sm-3 col-md-3">
						<div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapseOne"><span
											class="glyphicon glyphicon-plus"></span> 操作</a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in">
									<s:url action="myitems" namespace="/item" var="lostUrl">
										<s:param name="clazz" value="'lostItem'"></s:param>
									</s:url>
									<s:url action="myitems" namespace="/item" var="pickedUrl">
										<s:param name="clazz" value="'pickedItem'"></s:param>
									</s:url>
									<s:url action="changePwd" namespace="/user" var="changeUrl"></s:url>
									<ul class="list-group">
										<li class="list-group-item"><span
											class="glyphicon glyphicon-search text-success"></span> <a
											href="<s:property value="lostUrl"/>">我的失物 </a></li>
										<li class="list-group-item"><span
											class="glyphicon glyphicon-eye-open text-info"></span> <a
											href="<s:property value="pickedUrl"/>">我的招领</a></li>
										<li class="list-group-item"><span
											class="glyphicon glyphicon-info-sign text-success"></span> <a
											href="<s:property value="changeUrl"/>">修改密码 </a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-9 col-md-9">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<s:property value="#subTitle" />
								</h3>
							</div>
							<div class="panel-body">
								<decorator:body></decorator:body>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</page:applyDecorator>
