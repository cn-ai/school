<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>${msg }</h1>
	<form action="/springMVC_01/show1" method="post">
		<p>昵称：<input type="text" name="uname"></p>
		<p>所在城市:<input type="text" name="city"></p>
		<p>你所使用的开发语言：
			<input type="checkbox" name="language" value="java">java
			<input type="checkbox" name="language" value="c">c
			<input type="checkbox" name="language" value="c++">c++
			<input type="checkbox" name="language" value="php">php
			<input type="checkbox" name="language" value="ASP">asp
		</p>
		<p><input type="submit" value="提交"></p>
	</form>
</body>
</html>