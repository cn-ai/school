<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>航班信息查询</h1>
<form action="/ssm_flight/flight/list" id="f1">
	<p>请输入航班号:<input type="text" name="flightid"></p>
	<p><input type="button" value="查询"></p>
</form>
</body>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$("[type=button]").click(function(){
		var name=$("[name=flightid]").val();
		if(name==""){
			alert("请输入航班号");
			return;
		}
		$("#f1").submit();
	})
</script>
</html>