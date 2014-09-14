<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<title>用户注册</title>

<body>
	<div class="container-maincontent">
		<div class="container container-logon">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">用户注册</h3>
						</div>
						<div class="panel-body">
							<s:form role="form" action="confirmReg" namespace="/user"
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
										<s:if test="fieldErrors.account!=null">
											<label class="control-label"><s:property
													value="fieldErrors.account" /></label>
										</s:if>
										<s:textfield cssClass="form-control" name="account"
											placeholder="用户名"></s:textfield>
									</div>
									<div
										class="form-group  <s:if test="fieldErrors.dispalyName!=null">has-error</s:if>">
										<s:if test="fieldErrors.dispalyName!=null">
											<label class="control-label"><s:property
													value="fieldErrors.dispalyName" /></label>
										</s:if>
										<s:textfield cssClass="form-control" name="dispalyName"
											placeholder="昵称"></s:textfield>
									</div>
									<div
										class="form-group <s:if test="fieldErrors.password!=null">has-error</s:if>">
										<s:if test="fieldErrors.password!=null">
											<label class="control-label"><s:property
													value="fieldErrors.password" /></label>
										</s:if>
										<s:password cssClass="form-control" name="password"
											placeholder="密码"></s:password>
									</div>
									<div
										class="form-group <s:if test="fieldErrors.confirmPassword!=null">has-error</s:if>">
										<s:if test="fieldErrors.confirmPassword!=null">
											<label class="control-label"><s:property
													value="fieldErrors.confirmPassword" /></label>
										</s:if>
										<s:password cssClass="form-control" name="confirmPassword"
											placeholder="确认密码"></s:password>
									</div>
									<button class="btn btn-lg btn-success btn-block" type="submit">注册</button>
								</fieldset>
							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>