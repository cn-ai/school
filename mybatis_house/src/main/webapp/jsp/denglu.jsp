<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
 <link rel="stylesheet" href="../css/style2.css" type="text/css"></link>
</head>
<body>
<div class="sLoginBox">
	<div class="sWrap clearfix">
		<div class="imgBox1"></div>
		<div class="sLoginConBox">
			<div class="sLoginConBoxIn">
				<div class="sLoginCon">
					<ul class="loginTab clearfix">
					<li id="restartlogin" class="cur"><a href="javascript:;" data-target="phoneLogin">短信快捷登录</a></li>
						<li class="numLogin"><a href="javascript:;" data-target="accoutLogin">账号登录</a></li>
					</ul>
					<div class="Loginlist zhdl_login phoneLogin">					
						<p class="tip1">验证即登录，未注册将自动创建乐居通行证帐号</p>
					</div>
					<div class="Loginlist dxkj_login accoutLogin dxkj_login none">
						<form action="//my.leju.com/web/sso/ssoLogin" method="POST" autocomplete="off" name="accountForm">
							<ul class="inputList">
								<li>
									<div class="inputBox">
										<i class="i04"></i>
										<input class="mailText placeholder" type="text" placeholder="请输入邮箱或手机号码" data-rule="isDm,dmError" name="uname">
										<i class="error" style="display:none" value=""></i>
									</div>
									<em class="dmError"></em>
								</li>
								<li>
									<div class="inputBox">
										<i class="i02"></i>
										<input class="loginText passText" type="password" placeholder="请输入登录密码" data-rule="passNotnull,passwordError" name="upwd">
										<i class="error" style="display:none;"></i>
									</div>
									<em class="passwordError"></em>
								</li>
								<li class="imgCheck accountImg" style="display:none;">
									<div class="clearfix">
										<div class="inputBox short">
											<i class="i02"></i>
											<input class="loginText ayzText placeholder"type="text" placeholder="验证码" data-rule="yzNotnull,ayzError">
											<i class="right" style="display:none;"></i>
										</div>
										<!-- <a href="javascript:;"><img id="checkAyz" onclick="changing(this);" class="yz_num" src="//my.leju.com/Settings/Findpwd/chengCode"></a> -->
									</div>
									<em class="ayzError"></em>
								</li>
							</ul>
							<div class="tip2">
								<span class="autoLogin"><input type="checkbox" checked>下次自动登录</span>
								<span class="forget"><a href="//my.leju.com/Settings/findPwd/index">忘记密码？</a></span>
							</div>
							<div class="sBtnBox3">
								<a class="sBtn03" href="javascript:void(0);" data-fn="accountBtn" id="cn_dl">登 录</a>
								<input type="hidden" name="key" value="YjA2Yzk0MDhiWGt1YkdWcWRTNWpiMjA9YjA0YQ==" class="setKey" />
								<input type="hidden" name="mobile" value="" class="setMail" />
								<input type="hidden" name="password" value="" class="setWord" />
								<input type="hidden" name="imageCode" value="" class="accountYzm" disabled="disabled" />
								<input type="hidden" name="originUrl" class="setUrl"  value="//my.leju.com/web/center/index" />
							</div>
						</form>
					</div>
					<div class="otherLogin">
						你也可以用以下方式登录：
						<a href="https://open.weixin.qq.com/connect/qrconnect?appid=wx5ddf9de8a90a40b9&redirect_uri=http%3A%2F%2Fmy.leju.com%2FWeb%2FCallback%2FcallbackAdd%3Fkey%3DYjA2Yzk0MDhiWGt1YkdWcWRTNWpiMjA9YjA0YQ%3D%3D%26originUrl%3D%252F%252Fmy.leju.com%252Fsettings%252Fbindmobile%252FthirdBindView&response_type=code&scope=snsapi_login&state=ZmZlYjc0NTRNem94TlRRd09UazNNamt6ZmIxZQ==#wechat_redirect" class="wx"><span>微信登录</span></a>
						<a href="https://api.weibo.com/oauth2/authorize?response_type=code&client_id=1682292631&redirect_uri=http%3A%2F%2Fmy.leju.com%2FWeb%2FCallback%2FcallbackAdd%3Fkey%3DYjA2Yzk0MDhiWGt1YkdWcWRTNWpiMjA9YjA0YQ%3D%3D%26originUrl%3D%252F%252Fmy.leju.com%252Fsettings%252Fbindmobile%252FthirdBindView&state=YmU1Mjc2YjJNam94TlRRd09UazNNamt6NDUwYQ==&scope=all" class="wb"><span>微博登录</span></a>
						<a href="https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101268452&redirect_uri=http%3A%2F%2Fmy.leju.com%2FWeb%2FCallback%2FcallbackAdd%3Fkey%3DYjA2Yzk0MDhiWGt1YkdWcWRTNWpiMjA9YjA0YQ%3D%3D%26originUrl%3D%252F%252Fmy.leju.com%252Fsettings%252Fbindmobile%252FthirdBindView&state=MGE4YjM4OGVNVG94TlRRd09UazNNamt6NzYyZg==" class="qq"><span>QQ登录</span></a>
					</div>
					<div class="notice">
						<i></i>公告：原新浪通行证登录用户请使用新浪微博方式登录
					</div>
				</div>
				<a class="registerBtn" href="../jsp/Login.jsp"><span>注册</span></a>
			</div>
		</div>
	</div>
</div>
</body>

 <script type="text/javascript" src="../js/md5.js"></script>
<script  type="text/javascript" src="../js/pcLogin.js"></script>

<script>

	function changing(event){
		event.src="//my.leju.com/Settings/Findpwd/chengCode?"+Math.random();
    }
    </script> 

<script type="text/javascript">
    var city = 'zz'; //city_en（无则传quanguo）
    var level1_page = 'pcenter';
    var level2_page = 'login';
    var level3_page = '';
    var custom_id = '';
    var news_source='';
</script>
<script type="text/javascript" src="../js/gather.pc.soure.js"></script>
  <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	var a ;
	$(function(){
		(function($){
			$.getUrlParam=function(name){
				var reg=new RegExp("(^|&)"+name+"=([^&]*)(&|$)");
				var r=window.location.search.substr(1).match(reg);
				if(r!=null) return unescape(r[2]);
				return null;
			}
		})(jQuery);
		a = $.getUrlParam("a");
	})
	$("#cn_dl").click(function(){		
	var name=$("[name=uname]").val();
	var upwd=$("[name=upwd]").val();
	if(name==""){
		$(".dmError").text("手机号码或邮箱输入有误，请重新输入！");
		return;
	}
	if(upwd==""){
	$(".passwordError").text("登录密码不能为空！");
		return;
	}
	$.ajax({
		url:"../c/user?method=dl",
		data:{"uname":name,"upwd":upwd},
		type:"post",
		success:function(res){
			if(res=="yes"){
				alert("登录成功");
				
				if(a=="1"){
					location.href="../c/user?method=queryAdd";
				}else if(a=="2"){
					location.href="../c/user?method=querydistrict";
				}	
			}else{
				alert("登录失败");
			}
		}
	})
	})

	

</script>
</html>