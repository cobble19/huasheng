<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Login jsp">
<meta name="author" content="gebangyao@aliyun.com">
<link rel="shortcut icon" href="<%=request.getContextPath() %>/images/favicon.png">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/justified-nav.css">


<title>Login</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/login.css">
</head>
<body>
	<div class="login_container">
		<%-- <form action="<%=request.getContextPath() %>/login!execute" id="loginForm" method="post"> --%>
		<form action="<%=request.getContextPath() %>/j_spring_security_check" id="loginForm" method="post">
			<table>
				<tbody>
					<tr>
						<td class="login_label">用户名:</td>
						<td>
							<input class="login_input" id="name" name="j_username" type="text" placeholder="登陆账号"/>
						</td>
					</tr>
					<tr>
						<td class="login_label">密码:</td>
						<td>
							<input class="login_input" id="password" name="j_password" type="password" placeholder="密码"/>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<input class="login_btn" id="loginBtn" title="登陆" value="登陆" type="submit"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>