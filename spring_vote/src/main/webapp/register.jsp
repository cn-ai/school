<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注   册</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script></head>
<body>
<div id="header" class="wrap">
	<img src="images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="search">
	<!--  
		<form method="get" action="index.html">
			<input type="text" name="keywords" class="input-text" /><input type="submit" name="submit" class="input-button" value="" />
		</form>
	-->	
	</div>
</div>
<div id="register" class="box">
	<h2>新用户注册</h2>
	<div class="content">
	   <form method="post" action="reg_success.jsp">
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" class="input-text" name="name" onblur="query()" /><span style="display:none; color:red;" id = "b">用户名不可用</span></dd>
				<dt>密码：</dt>
				<dd><input type="password" class="input-text" name="ws" /> <span style="display:none; color:red;" id = "c">用户名不可用</span></dd>
				<dt>确认密码：</dt>
				<dd><input type="password" class="input-text" name="pwd" /><span id="mm" style="display:none;color:red;">两次密码不同</span></dd>
				<dt></dt>
				<dd><input type="button" onclick="Add()" class="input-button" name="bu" value="" /></dd>
			</dl>
		</form>
		<div class="error"></div>
		<div class="error"></div>
	</div>
</div>
<div id="footer" class="wrap">
	北大青鸟 &copy; 版权所有
</div>
<script type="text/javascript">
	var pd ;
	function Add(){
		var uname=$("[name = name]").val();
		if($("[name=ws]").val().trim().length==0){
			$("#c").text("请填写密码").show();
		}else if($("[name=pwd]").val().trim().length==0){
			$("#mm").text("请填写密码").show();
		}else if($("[name=pwd]").val().trim()!=$("[name=ws]").val().trim()){
			$("#mm").text("两次密码不同").show();
		}else if(pd){
			$.post("/spring_vote/c/vote",{"method":"saveReg","uname":uname,"upwd":$("[name=ws]").val()},function(txt){
				if(txt=="yes"){
					alert("注册成功");
					location.href="login.jsp";
				}else{
					alert("注册失败");
				}
			})
		}
		
	}
	function query(){		
		if($("[name = name]").val().trim().length!=0){
			$.post("/spring_vote/c/vote",{method:"Login","uname":$("[name = name]").val()},function(json){
				if(json.code=="200"){
						$("#b").show();
						pd = false;
					}else{
						$("#b").hide();
						pd = true;
					}
				},"json")
			}else{
				alert("请填写用户名");
			}
		}
		
	
</script>
</body>

</html>
