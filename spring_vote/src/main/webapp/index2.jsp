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
<title>投票列表</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
</script>
<style>
	.prompt{display: none;border: 1px solid #98B2CE; width: 400px;height: 200px;z-index: 2; position: absolute;background-color: #C9E3FA;top:200px;left: 300px; }
	.prompt a{font-size: 25px;}
	.prompt span{font-size: 25px;}
	.prompt h1{background-color: #3F93C1; text-align: left;height: 80px;}
</style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script></head>
<body>
<div class="prompt" id="prompt">
	<center>
		<h1><br/>信息提示</h1>
		<span>操作前请先<b>登录</b>或者<b>注册</b>！</span><br/><br/>
		<a href="login.jsp">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="register.jsp">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:hidde();">返回</a>
	</center>
</div>
<div id="header" class="wrap">
	<img src="images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="profile">
		<span id="user1" style="display: none"><a href="login.jsp">登录</a>&nbsp;&nbsp;<a href="register.jsp">注册</a></span>	
		<span id="user2" style="display: none"></span>	
		<span class="return"><a href="javascript:void(0)" name="fh">返回列表</a></span>
		<span class="addnew"><a href="javascript:void(0)" name="add">添加新投票</a></span>
		<span class="modify"><a href="javascript:void(0);" name="wh">维护</a></span>
		
	</div>
	<div class="search">
		<form method="post" action="javascript:clike();">
			<input type="text" name="keywords" class="input-text" /><input type="button" name="submit" class="input-button" value="" />
		</form>
	</div>
</div>
<div id="vote" class="wrap">
	<h2>维护列表</h2>
	<ul class="list" id="tbo">
	
	</ul>
		<a id="a" href="javascript:void(0)" onclick="show()">首页</a>
        <a id="b" href="javascript:void(0)" onclick="show()">上一页</a>
        <a id="c" href="javascript:void(0)" onclick="show()">下一页</a>
        <a id="d" href="javascript:void(0)" onclick="show()">尾页</a>
      
</div>
		<c:forEach items="${listVo}" var = "item">
			<input type="hidden" name="sid" value="${item.sid}"/>
		</c:forEach>
<div id="footer" class="wrap">
	北大青鸟 &copy; 版权所有
</div>
<script type="text/javascript">
function show(pageNum,sub){	
	$.post("/spring_vote/c/vote",{method:"querySub","pageNum":pageNum,"sub1":sub},function(rusult){
		 $("#tbo").html("");
		 $.each(rusult.list,function(i,obj){
                 var $li=$("<li></li>");
                 $li.append("<h4><a href='javascript:clike("+obj.id+");'>"+obj.title+"</a></h4>");
                 $li.append("<div class='join'><span class='modify'><a href='/spring_vote/c/vote?method=loadSub&sid="+obj.id+"' name='wh'>维护</a></span></div>");
                 $li.append("<p>"+obj.startDate+" 到 "+obj.overDate+"</p>");
                 $li.append("<p class='info'>共有 "+obj.option.length+" 个选项，已有 "+obj.join+" 个网友参与了投票。</p>");
                 $("#tbo").append($li);
          });
           $("#a").attr("onclick","show(1)");
         if(rusult.hasPreviousPage){
        	 $("#b").attr("onclick","show("+rusult.prePage+")");
         }else{
        	 $("#b").attr("onclick","show("+rusult.pageNum+")");
         }
         if(rusult.hasNextPage){
	  			$("#c").attr("onclick","show("+rusult.nextPage+")");
         }else{
        	$("#c").attr("onclick","show("+rusult.pageNum+")");
         }
  			
  			$("#d").attr("onclick","show("+rusult.lastPage+")");
			
	},"json");
	
}
//用户退出
function out(){
	if(confirm("确定要退出吗?")){
		window.location="out.jsp";
	}
}
	
	//页面加载时
	$(function(){
		if(!${empty user}){
			$("#user2").show().text(${user.uname}+"，欢迎您!");
			$("#user2").append("<a href=\"javascript:out()\">退出</a>");
			
		}else{
			$("#user1").show();
		}
		 show(1,"");
		$("[name=submit]").click(function(){			
			var title = $("[name=keywords]").val();		
			show(1,title);
		});
		
		$("[name=wh]").click(function(){
			if(${empty user}){
				alert("请先登录！");
			}else{
				window.location = "index2.jsp";
			}
		});
		$("[name=add]").click(function(){
			if(${empty user}){
				alert("请先登录！");
			}else{
				window.location = "add.jsp";
			}
			
		});
	});
	
	
</script>
</body>
</html>
