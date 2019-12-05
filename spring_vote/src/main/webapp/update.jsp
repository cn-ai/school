<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布新投票</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript">
	var isIE = !!document.all;
	function AddOption()
	{
		var voteoptions = document.getElementById("voteoptions");
		var _p = document.createElement("p");
		var _input = document.createElement("input");
		_input.type = "text";
		_input.className = "input-text";
		_input.setAttribute("name", "oname1");
		_p.appendChild(_input);
		var _a = document.createElement("a");
		_a.className = "del";
		_a.setAttribute("href", "javascript:;");
		if(isIE) {
			_a.attachEvent("onclick", DelOption);
		} else {
			_a.addEventListener("click", DelOption, false);
		}
		_a.appendChild(document.createTextNode("删除"));
		_p.appendChild(_a);
		voteoptions.appendChild(_p);
	}
	function DelOption(e)
	{
		if(!e) e = window.event;
		var a = e.srcElement || e.target;
		var obj = a.parentNode;
		obj.parentNode.removeChild(obj);
	}
	function update(val){
		if(val.length>0){
			if(confirm("如果内容更新了，之前的投票将清0，您确定更新吗？")){
				return true;
			}
			return false;
		}else{
			return true;
		}
	}
</script>
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script></head>
<body>
<div id="header" class="wrap">
	<img src="../images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="profile">
		<span id="user1" style="display: none"><a href="login.jsp">登录</a>&nbsp;&nbsp;<a href="register.jsp">注册</a></span>	
		<span id="user2" style="display: none"></span>	
		<span class="return"><a href="javascript:void(0)" name="fh">返回列表</a></span>
		<span class="addnew"><a href="javascript:void(0)" name = "add">添加新投票</a></span>
		<span class="modify"><a href="javascript:void(0)" name="wh">维护</a></span>
		
	</div>
	<div class="search">
		<form method="post" action="javascript:clike();">
			<input type="text" name="keywords" class="input-text" /><input type="button" name="submit" class="input-button" value="" />
		</form>
	</div>
</div>
	<div id="voteManage" class="box">
		<h2>修改投票信息</h2>
		<div class="content">
		<form action="javascript:void(0)" id="form" >
				<dl>
					<dt>投票内容：</dt>
					<dd>
					   <input type="hidden" name="vs.vsId"  />
					   <input type="text" value="${sub.title}" class="input-text" name="title" />
					    <input type="hidden" value="${sub.id}" name="ss" />
					</dd>
					<dt>投票类型：</dt>
					<c:if test="${sub.type==0}">
					<dd> 
			  		   <input type="radio" value="1" name="type"  checked="checked"/>单选
					   <input type="radio" value="2" name="type"  />多选
					</dd>
					</c:if>
					<c:if test="${sub.type==1}">
					<dd> 
			  		   <input type="radio" value="1" name="type"  />单选
					   <input type="radio" value="2" name="type"  checked="checked"/>多选
					</dd>
					</c:if>
					<dt>投票选项：</dt>
					<c:forEach items="${sub.option}" var="li">
					<dd id="voteoptions">
							<p>
								<input type="text" value="${li.option}" class="input-text" name="oname" />
								
							</p>
					</dd></c:forEach>
					<dt></dt>
					<dd class="button">
						<input type="image" name="buttom" src="../images/button_submit.gif" />
						<a href="javascript:;" onclick="AddOption()">增加选项</a>
						<a href="javascript:history.go(0)">取消操作</a>
					</dd>
				</dl>
			</form>
		</div>
	</div>
	<div id="footer" class="wrap">
		北大青鸟 &copy; 版权所有
	</div>
	<script>
	
	
		$(function(){			
			if(!${empty user}){ 
				$("#user2").show().text(${user.uname}+"，欢迎您!");
				$("#user2").append("<a href=\"javascript:out()\">退出</a>");
			}else{
				$("#user1").show();
			}	
			$("[name=fh]").click(function(){
				window.location = "../index.jsp";
			});
			$("[name=add]").click(function(){
				window.location = "../add.jsp";
			});
			$("[name=wh]").click(function(){
				window.location = "../index2.jsp";
			});
			$("[name=buttom]").click(function(){
		
			var name="";
			/* for ( var i = 0; i < $("[name='oname1']").length; i++) {
				a=$("[name='oname1']:eq('"+i+"')").val()+",";
			
			} */
			for ( var i = 0; i < $("[name='oname']").length; i++) {
					name+=$("[name=oname]:eq('"+i+"')").val()+",";					
			}
			
			name= name.substring(0,name.lastIndexOf(','));
			var obj ={};
			obj["type"] = $("[name=type]").val();
			obj["title"]=$("[name=title]").val();
			obj["id"] = $("[name=ss]").val();	
			var strobj=JSON.stringify(obj);
			
			$.post("/spring_vote/c/vote",{"method":"updateSub","obj":strobj,"name":name},function(date){	
				alert(date);
					alert("操作成功");
					window.location.href="../index2.jsp";
				
			},"json");
			
			});
			
			$("[name=del]").click(function(){
			
				$.post("<%=path%>/delect!delect","",function(){
					
				});
			});
		});
	</script>
</body>

</html>

