<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="500">
		<thead>
			<tr><th colspan="5" rowspan="1">回复信息列表</th></tr>
		</thead>
		<thead>
			<tr>
				<th colspan="5" rowspan="1"><a href="../add.jsp">添加回复</a> <a href="../query.jsp">返回帖子列表</a></th>
			</tr>
		</thead>
		<thead>
			<tr>
				<th>回复内容</th>
				<th>回复昵称</th>
				<th>发布时间</th>
			</tr>
		</thead>
		<tbody id="personList">
		<c:forEach items="${list }" var="l">
			<tr>
				<td>${l.content }</td>
				<td>${l.author }</td>
				<td>${l.createdatel }</td>
			</tr>
		</c:forEach>
		</tbody>	
	</table>
</body>
</html>