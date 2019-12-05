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
<p>昵称：${user.uname }</p>
<p>所在城市:${user.city }</p>
		<p>你所使用的开发语言：
		<c:forEach items="${user.language }" var="l">
			<span>${l }</span>
		</c:forEach>
		</p>
		<p><input type="submit" value="提交"></p>
	
</body>
</html>