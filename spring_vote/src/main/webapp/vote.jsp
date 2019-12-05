<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setContentType("text/html;charset=UTF-8");
%>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>参与投票</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
	function init(manage){
		if(manage.length>0)
			alert(manage);
	}
</script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script></head>
<body onload="init('${manage}')">
<div id="header" class="wrap">
	<img src="images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="profile">
		<span id="user1" style="display: none"><a href="login.jsp">登录</a>&nbsp;&nbsp;<a href="register.jsp">注册</a></span>	
		<span id="user2" style="display: none"></span>	
		<span class="return"><a href="javascript:void(0)" name="fh">返回列表</a></span>
		<span class="addnew"><a href="javascript:void(0)" name = "add">添加新投票</a></span>
		<span class="modify"><a href="javascript:void(0)" name="wh">维护</a></span>
		
	</div>
</div>
<div id="vote" class="wrap">
	<h2>参与投票</h2>
	<ul class="list">
		<li>
		<form action="javascript:void(0)" id="form">
			<h4>${ops.stitle}</h4>
			<p class="info">共有${ops.options.size()}个选项，已有${ops.records.size()}个网友参与了投票。</p>
			
			    <input type="hidden" name="sid" value="${ops.sid}"/> 
				<ol>
					<c:forEach items="${ops.options}" var="li">
					<c:choose>
						<c:when test="${ops.stype==1}">
							<li><input type="radio" name="op.oid" value="${li.oid}"/>${li.oname}</li>
						</c:when>
						<c:otherwise>
							<li><input type="checkbox" name="op.oid" value="${li.oid}"/>${li.oname}</li>
						</c:otherwise>
					</c:choose>
					</c:forEach>
				</ol>
				<p class="voteView"><input type="image" name="bu" src="images/button_vote.gif" /><a href="getalll!getall?sid=${ops.sid}" /><img src="images/button_view.gif" /></a></p>
			</form>
		</li>
	</ul>
</div>
<div id="footer" class="wrap">
	北大青鸟 &copy; 版权所有
</div>
<script>
	$(function(){
		if(window.sessionStorage.getItem("uid")!=null){
			$("#user2").show().text(window.sessionStorage.getItem("uname")+"，欢迎您!");
			$("#user2").append("<a href=\"javascript:out()\">退出</a>");
			
		}else{
			$("#user1").show();
		}
		$("[name=fh]").click(function(){
			window.location = "index.jsp";
		});
		$("[name=add]").click(function(){
			window.location = "add.jsp";
		});
		$("[name=wh]").click(function(){
			window.location = "index2.jsp";
		});
		$("[name=bu]").click(function(){
			var re = $("#form").serialize();
			$.post("<%=path%>/insert!insert",re,function(date){
				if (date) {
					alert("投票成功!");
					
				}else{
					alert("新增失败!");
				}				
			});
		});
	});
</script>
</body>
</html>
