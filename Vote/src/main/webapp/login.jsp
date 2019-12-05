<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script></head>
<body>
	<div id="header" class="wrap">
		<img src="images/logo.gif" />
	</div>
	<div id="login" class="wrap">
		<div class="main">
			<div class="corner"></div>
			<div class="introduce">
				<h2>北大青鸟</h2>
				<p>网上调查系统...</p>
			</div>
			<div class="login">
				<h2>用户登录</h2>
					<dl id="loginBox">
						<dt>用户名：</dt>
						<dd>
							<input type="text" class="input-text" name="id" />
						</dd>
						<dt>密 码：</dt>
						<dd>
							<input type="password" class="input-text" name="pwd" />
						</dd>
						<dt></dt>
						<dd>
							<input type="button" onclick="Login()"  class="input-button" name="submit"
								value="登录" /> <a href="register.jsp">新用户注册</a>
						</dd>
					</dl>
				<div class="error">
				</div>
			</div>
		</div>
	</div>
	<div class="wrap"></div>
	<div id="footer" class="wrap">北大青鸟 &copy; 版权所有</div>
	<script type="text/javascript">
		function Login(){
			if($("[name=id]").val().trim().length==0){
				alert("请输入账户");
			}else if($("[name=pwd]").val().trim().length==0){
				alert("请输入密码");
			}else{
				var json = {};
				json["uname"] = $("[name=id]").val();
				json["upwd"] = $("[name=pwd]").val();
				var jsonUser = JSON.stringify(json);
				$.post("/Vote/c/Action",{m:"Login","user":jsonUser},function(json){
					if(json.code=="500"){
						alert(json.meg);
					}else if(json.code=="200"){
						window.sessionStorage.setItem("uid",json.uid);
						window.sessionStorage.setItem("uname",json.uname);
						window.location = "index.jsp";
					}
				},"json")
			}
		}
	</script>
</body>

</html>
