<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Đăng nhập</title>
</head>

<body>
	<div id="login">
		<div class="container">
			<div id="login-row" class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form action='<c:url value = "/dang-nhap" />' id="formSubmit" method="post">
							<c:if test="${not empty message}">
								<div class="alert alert-${alert}">
							    	<strong>${message}</strong>
								</div>
							</c:if>
							<div class="form-group">
								<label for="username" class="text-info">Tài khoản:</label><br>
								<input type="text" name="userName" id="username" class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Mật khẩu:</label><br>
								<input type="password" name="password" id="password" class="form-control">
							</div>
							<input type="hidden" value="login" id="action" name="action"/>
							<button type="submit" class="btn btn-info btn-md">Đăng Nhập</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>