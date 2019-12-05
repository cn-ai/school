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
		
		</form>
		</li>
	</ul>
</div>
<div id="footer" class="wrap">
	北大青鸟 &copy; 版权所有
</div>
<script>
	var way ; 
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
		viewLoad();
	});
	function viewLoad(){
		var json = {};
		json["id"] = window.sessionStorage.getItem("sid");
		var jsonUser = JSON.stringify(json);
		$.post("/Vote/c/Action",{m:"queryOptions","user":jsonUser},function(json){

			 $.each(json,function(i,obj){
                 var $li=$("<li></li>");
                 $li.append("<h4>"+obj.title+"</h4>");
                 $li.append("<p class=\"info\">共有"+obj.option.length+"个选项，已有"+obj.join+"个网友参与了投票。</p>");
                 var $ol=$("<ol></ol>");
                 $.each(obj.option,function(i,data){
                	 if(obj.type==0){
                    	 $ol.append(" <li><input type=\"radio\" name=\"oid\" value="+data.id+" />"+data.option+"</li>");
                     }else{
                    	 $ol.append(" <li><input type=\"checkbox\" name=\"oid\" value="+data.id+" />"+data.option+"</li>");
                     }	 
                 });
                 way = obj.way;
                 $li.append($ol);
                 
                 $li.append("<p class=\"voteView\"><input type=\"image\" onclick='Add()' name=\"bu\" src=\"images/button_vote.gif\" /><a href='view.jsp' ><img src=\"images/button_view.gif\"/></a></p>");
                 $("#form").append($li);
          	});
		},"json")
	}
	function Add(){
		if($("[name=oid]:checked").length>0){
			var json = {};
			json["sid"] = window.sessionStorage.getItem("sid");
			var items = "";
			for (var i = 0; i < $("[name=oid]:checked").length; i++) {
				items += $("[name=oid]:checked:eq("+i+")").val()+",";
			}
			items = items.substring(0,items.lastIndexOf(','));
			json["uid"] = window.sessionStorage.getItem("uid");
			var pojo = JSON.stringify(json);
			$.post("/Vote/c/Action",{m:"addItem","item":pojo,"items":items,"way":way},function(date){
				 if (date.code=="200") {
					window.location = "vote_success.jsp";
				}else if(date.code="500"){
					alert(date.meg);
				}
			},"json");
		}else{
			alert("请进行选择");
		}
	}
</script>
</body>
</html>
