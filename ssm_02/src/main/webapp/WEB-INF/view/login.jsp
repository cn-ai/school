<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			div{
				width: 500px;
				height: 500px;
				margin: 0 auto;
				text-align: center;
			}
			form{
				border: 1px solid cadetblue;
			}

		</style>
	</head>
	<body>
		<div>
			<h1>论文管理系统</h1>
			<form action="/ssm_02/user/login" method="post">
				<p>用户名：<input name="userName"/></p>
				<p>密 &nbsp; 码<input name="userPassword"/></p>
				<p><input type="submit" value="登陆" />&nbsp;&nbsp;
				<input type="reset" value="重置" /></p>
			</form>
			<h1 style="color:red;text-aligh:center">${msg }</h1>
		</div>
	</body>
</html>
