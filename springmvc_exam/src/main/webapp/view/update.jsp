<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>空气质量信息维护</h3>
	<form action="/spring_exam/air/update">
		<input type="hidden" value="${air.id }" name="id">
		<p >监测区域:
			<select name="district_id">
					<option value="-1">不限</option>
					<c:forEach items="${list }" var="list">		
						<option value="${list.id }" ${air.district_id==list.id?"selected":"" }>${list.name }</option>
					</c:forEach>	
					</select>
		</p>
		<p>
			检测日期
				<input type="text" name="monitor_time" value="${air.monitor_time }">
		</p>
		<p>
			PM10值
				<input type="text" name="pm10" value="${air.pm10 }">
		</p>
		<p>
			PM2值
				<input type="text" name="pm2" value="${air.pm2 }">
		</p>
		<p>
			检测站
				<input type="text" name="monitoring_station" value="${air.monitoring_station }">
		</p>
		<c:if test="${air.last_modify_time!=null }">
			<p>
			最后修改时间
				<input type="text" name="last_modify_time" value="${air.last_modify_time }">
			</p>
		</c:if>
		<p>
		<input type="submit" value="修改">
		<button><a href="/spring_exam/air/del?id=${air.id }">删除</a></button>
		<input type="button" value="返回">
		</p>
	</form>
</body>
</html>