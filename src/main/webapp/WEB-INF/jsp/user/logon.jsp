<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<title>Logon</title>

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
							<form role="form">
								<fieldset>
									<div class="form-group">
										<input autofocus="" class="form-control" name="email"
											placeholder="用户名" type="email">
									</div>
									<div class="form-group">
										<input class="form-control" name="password" placeholder="密码"
											type="password" value="">
									</div>
									<div class="checkbox">
										<label> <input name="remember" type="checkbox"
											value="Remember Me">记住我
										</label>
									</div>

									<!-- Change this to a button or input when using this as a form -->
									<a class="btn btn-lg btn-success btn-block" href="index.html">登陆</a>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>