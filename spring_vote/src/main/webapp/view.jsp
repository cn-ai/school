<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setContentType("text/html;charset=UTF-8");
%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看投票</title>
<script type="text/javascript">
	function init(){
		var spans = document.getElementById("view").getElementsByTagName("span");
		for(var i = 0;i<spans.length;i++){
			var t = spans[i].innerHTML;
			t = t.substring(1, t.length);
			t = t.substring(0, t.length-2);
			if(t != "NaN"){
				t = t.substring(0, t.indexOf(".", 0)+3);
				if(t.substring(t.length-1, t.length)>=5){
					t = t * 1 + 0.01;
				}
			}else{
				t=0;
			}
			
			spans[i].innerHTML = "(" + t + "%)";
		}
	}
</script>
<link rel="stylesheet" href="css/style.css" type="text/css"></link>
</head>
<body onload="init()">
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
		<h2>查看投票</h2>
		<ul class="list">
			<li>
			<c:forEach items="${list}" var="item">
				<h4><s:property value="vs.vsTitle"/>${item.stitle}</h4>
				<p class="info">共有 ${item.options.size()} 个选项，已有 ${item.records.size()} 个网友参与了投票。</p>
					<ol id="view">
					<c:forEach items="${item.options}" var="li">
					  <s:iterator value="vs.voteOptions" status="status"> 
						<li>
							<s:property value="voOption"/>${li.oname}
							<div class="rate">
								<div class="ratebg"><div class="percent" style="width:${li.records.size()*1.0/item.records.size()*100}%"></div></div>
								<p><s:property value="voteItems.size"/>${li.records.size()}票
								<span>${li.records.size()*11.0/item.records.size()*100}%</span></p>
							</div>
						</li>
					  </s:iterator>
					  </c:forEach>
					</ol>
					<div class="goback"><a href="index.jsp">返回投票列表</a></div>
				</c:forEach>
			</li>
		</ul>
	</div>
	<div id="footer" class="wrap">
		北大青鸟 &copy; 版权所有
	</div>
</body>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	
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
		});
	</script>
</html>
