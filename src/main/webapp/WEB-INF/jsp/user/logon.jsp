<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<title>登录</title>

<body>
	<div class="container-maincontent">
		<div class="container container-logon">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">请登录</h3>
						</div>
						<div class="panel-body">
							<s:form role="form" action="confirm" namespace="/user"
								theme="simple">
								<fieldset>
									<s:if test="actionErrors!=null">
										<div class="has-error">
											<ul>
												<s:iterator value="actionErrors">
													<label class="control-label"><li><s:property /></li></label>
												</s:iterator>
											</ul>
										</div>
									</s:if>
									<div
										class="form-group  <s:if test="fieldErrors.account!=null">has-error</s:if>">
										<s:textfield cssClass="form-control" name="account"
											placeholder="用户名"></s:textfield>
									</div>
									<div
										class="form-group <s:if test="fieldErrors.password!=null">has-error</s:if>">
										<s:password cssClass="form-control" name="password"
											cssErrorClass="has-error" placeholder="密码"></s:password>
									</div>
									<button class="btn btn-lg btn-success btn-block" type="submit">登陆</button>
								</fieldset>
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<s:debug></s:debug>
</body>