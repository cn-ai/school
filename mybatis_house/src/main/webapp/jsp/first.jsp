<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<head>
		<meta charset="UTF-8">
		<title>导航</title>
		<link href="../css/first.css" rel="stylesheet" />
	</head>
	<body>
		<div id="header">
    <div class="head f-w1190 clearfix">
        <div class="city">
            <a class="fc-city" href="http://cq.ganji.com" title="">深圳</a>
            <a href="http://www.ganji.com/index.htm">[切换城市]</a>
        </div>
                  
       <a class="column" href="../c/user?method=querydistrict" title="" target="_blank">租房首页</a>

        <div class="head-r clearfix">                 
            <div class="f-fl reg-login" data-widget="app/ms_v2/common/base_page.js#userinfoWidget">
                <span class="reg-login-btn clearfix hdh">
                    <a rel="nofollow" class="reg js-signup-btn" href="../jsp/Login.jsp" title="免费注册" target="_self">免费注册</a>
                    <a href="../jsp/denglu.jsp?a=2" rel="nofollow" class="login js-signin-btn" href="" title="登录" target="_self">登录</a>
                </span>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		if(!${empty user}){
			$(".reg").css("display","none");
			$(".login").css("display","none");
			var $a="<a rel='nofollow' class='reg js-signup-btn' href='../jsp/info.jsp' title='个人中心' target='_self'>${user.uname}</a> <a href='javascript:void(0)' rel='nofollow' class='login js-signin-btn out'  title='退出' target='_self'>退出</a>";
			$(".hdh").append($a);
		}
	})
		$(document).on("click",".out",function(){
		$.post("../c/user",{"method":"outSession"},function(txt){
			if(txt=="yes"){
				location.href="../c/user?method=querydistrict";
			}
		})
	})
</script>
</html>