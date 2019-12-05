<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
</head>
<body>
	<h3>添加空气质量信息</h3>
	<form action="/spring_exam/air/add" id="myform">
		<p >监测区域:
			<select name="district_id">
					<option value="-1">不限</option>
					<c:forEach items="${list }" var="list">		
						<option value="${list.id }">${list.name }</option>
					</c:forEach>	
					</select>
		</p>
		<p>
			检测日期
				<input type="text" name="monitor_time">
		</p>
		<p>
			PM10值
				<input type="text" name="pm10">
		</p>
		<p>
			PM2值
				<input type="text" name="pm2">
		</p>
		<p>
			检测站
				<input type="text" name="monitoring_station">
		</p>
		<p>
		<input type="button" value="保存" class="bc">
		<input type="button" value="返回">
		</p>
	</form>
</body>
<script type="text/javascript" src="/spring_exam/js/jquery-1.12.4.js"></script>

<script type="text/javascript" >
	$(".bc").click(function(){
		/* var time=$("[name=monitor_time]").text();
		var reg=/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
		if(reg.test(time)==false){
			alert("日期格式不正确");
			return false;
		} */
		$("#myform").submit();
	})

	
</script>
</html>