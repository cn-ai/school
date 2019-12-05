<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setContentType("text/html;charset=UTF-8");
%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>退出</title>
	</head>
	<body>
			<h1 style="text-align: center;">已退出</h1>
	</body>
	<script src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	$(function(){
		if(${empty user}){
			alert("请先登录!");
			window.location = "login.jsp";
		}else{
			$.post("/spring_vote/c/vote",{"method":"outSession"},function(txt){				
				if(txt=="yes"){
					alert("欢迎下次使用");
					location.href="login.jsp";
				}else{
					alert("退出异常");
				}
				
			});
		}
		
	})
		
	</script>
</html>
