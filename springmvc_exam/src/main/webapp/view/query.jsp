<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询空气质量</title>
</head>
<body>
		<div>
			<h3>空气质量检测信息库</h3>
			<form action="/spring_exam/air/queryAll">
				<p>
					按区域查询
					<select name="districtid">
					<option value="-1">不限</option>
					<c:forEach items="${list }" var="list">		
						<option value="${list.id }">${list.name }</option>
					</c:forEach>	
					</select>
					<input value="查询" type="submit">
					
				</p>
				
			</form>
			<a href="/spring_exam/air/toadd">添加空气质量信息</a>
			<table border="1" width="650px">
				<thead style="background: #00B5F1;">
					<th>序号</th>
					<th>区域</th>
					<th>检测时间</th>
					<th>PM10数据</th>
					<th>PM2.5数据</th>
					<th>监测站</th>
				</thead>
				<tbody>
				<tr>
				<c:if test="${info.total==0 }">
					<td rowspan="1" colspan="6"><h5 style="text-align: center;">暂时没有数据</h5></td>
				</c:if>
				</tr>
				<c:forEach items="${info.list }" var="info">
					<tr>
						<td>${info.id }</td>
						<td><a href="/spring_exam/air/toupdate?id=${info.id }">${info.dis.name }</a></td>
						<td>${info.monitor_time }</td>
						<td>${info.pm10 }</td>
						<td>${info.pm2 }</td>
						<td>${info.monitoring_station }</td>
					</tr>		
				</c:forEach>
				
				
				</tbody>
				
			</table>
				<div>
						<a href="/spring_exam/air/queryAll?num=1">首页</a>
						<c:if test="${info.isHasPreviousPage()}">
						<a href="/spring_exam/air/queryAll?num=${info.prePage }">上一页</a>
						</c:if>
						<c:if test="${info.isHasNextPage()}">
						<a href="/spring_exam/air/queryAll?num=${info.nextPage }">下一页</a>
						</c:if>
						<a href="/spring_exam/air/queryAll?num=${info.lastPage }">尾页</a>
						<span>第${info.pageNum }/${info.pages }页（${info.total }条）</span>
					</div>
		</div>	
</body>
</html>