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
<title>青鸟租房 -发布房屋信息</title>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<!-- 图片样式 -->
 <link rel="shortcut icon" href="favicon.ico">
  <link href="../static/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="../static/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="../static/css/animate.css" rel="stylesheet">
    <link href="../static/css/basic.css" rel="stylesheet">
    <link href="../static/css/dropzone.css" rel="stylesheet">
    <link href="../static/css/style.css?v=4.1.0" rel="stylesheet">

<style type="text/css">
.gohome{
display: none;
}

</style>
</head>
<BODY>
	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="../img/logo.gif">
		</DIV>
	</DIV>
	<DIV id=regLogin class=wrap>
		<DIV class=dialog>
			<DL class=clearfix>
				<DT style="display:none">新房屋信息发布</DT>
				<DD class=past>修改房屋信息</DD>
			
			</DL>
			<DIV class=box>
				<FORM id=add_action method=post name=add.action
					action=/HouseRent/page/add.action>
					<DIV class=infos>
						<TABLE class=field>
							<TBODY>
								<TR>
									<TD class=field>标 题：</TD>
									<TD><INPUT id=add_action_title class=text type=text
										name=title onblur="yztitle()" placeholder="请为房屋取个名字"></TD>
									
								</TR>
							<tr style="line-height: 20px;color:red"><td></td><td class="content" ></td></tr>
								
	
								<TR>
									<TD class=field>价 格：</TD>
									<TD><INPUT id=add_action_price class=text type=text
										name=price onblur="yz2();"  placeholder="请正确填写你的出售价格，只能为数字哦"></TD>
								</TR>
								<tr style="line-height: 20px;color:red"><td></td><td class="content3"></td></tr>
														
								<tr>
									<TD class=field>详细地址：</TD>
									<TD><INPUT id="" class=text type=text name="detailAddress" onblur="yz5();"  placeholder="请正确填写你的地址，方便别人找到">
									</TD>
								</TR>
								<tr style="line-height: 20px;color:red"><td></td><td class="content5"></td></tr>
								<TR>
									<TD class=field>联系方式：</TD>
									<TD><INPUT id=add_action_contact class=text type=text
										name=contact onblur="yz6();"  placeholder="请正确填写你的联系方式，方便联系"></TD>
								</TR>
								<tr style="line-height: 20px;color:red"><td></td><td class="content6"></td></tr>
								<TR>
									<TD class=field>详细信息：</TD>
									<TD><TEXTAREA name=description onblur="yz7();"  placeholder="请为你的房子描述一下吧"></TEXTAREA></TD>
								</TR>
								<tr style="line-height: 20px;color:red"><td></td><td class="content7"></td></tr>
							</TBODY>
						</TABLE>
						<DIV class=buttons>
							<INPUT onclick="fabu();" value=立即发布
								type=button>
							<INPUT onclick="fh();" value="返回列表"
								type=button>
						</DIV>
					</DIV>
				</FORM>
			</DIV>
		</DIV>	</DIV>

	

	<DIV id=footer class=wrap>
		<DL>
			<DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</BODY>
<!-- 图片样式 -->
 <!-- 全局js -->
    <script src="../static/js/jquery.min.js?v=2.1.4"></script>
    <script src="../static/js/bootstrap.min.js?v=3.3.6"></script>
    <!-- 自定义js -->
    <script src="../static/js/content.js?v=1.0.0"></script>
    <!-- DROPZONE -->
    <script src="../static/js/dropzone.js"></script>



<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
function fh(){
	location.href="../jsp/info.jsp";
}
var hid=window.sessionStorage.getItem("hid");
$.post("../c/user",{"method":"loadInfo2","hid":hid},function(res){
	$("[name=title]").val(res.title);
	$("[name=price]").val(res.price);
	$("[name=detailAddress]").val(res.addressDetail);
	$("[name=contact]").val(res.phone);
	$("[name=description]").val(res.detail)
},"json");
//监听器，新思路：浏览数量(已完成，思维到位，并不是监听器，而是数据库里的列表游览数+1)
	//MD5(已完成)   
//循环图片（yi完成）
//注册页面（已完成）
//自己不能租自己的（出现问题，查询方法有冲突，如果解决需要在1.创建一个方法）
	//新增房屋编号有问题（已完成）
//上传图片不能跳转
//个人中心
//修改home.jsp这个页面
//租房条件有问题(已完成)
var pd = true;
//验证
function yztitle(){
	if($("[name=title]").val()==""){
		$(".content").text("标题不能为空");
		pd= false;
	}else{	
		$(".content").text("");
	}
}
function yz2(){
	if($("[name=price]").val()==""){
		$(".content3").text("价格不能为空");
		pd= false;
	}
	else if(isNaN($("[name=price]").val())==true){
		$(".content3").text("价格填写错误,不能含有中文和非法字符");
		pd= false;
	}else{
		$(".content3").text("");
	}
}

function yz5(){

	if($("[name=detailAddress]").val()==""){
		$(".content5").text("详细地址不能为空");
		pd= false;
	}else{
		$(".content5").text("");
	}	

}
function yz6(){
	var exreg=/^1\d{10}$/;
	if($("[name=contact]").val()==""){
		$(".content6").text("联系方式不能为空");
		pd= false;
	}
	else if(exreg.test($("[name=contact]").val())==false){
		$(".content6").text("请填写正确的手机号码");
		pd= false;
	}else{
		$(".content6").text("");
	}

}
function yz7(){
	if($("[name=description]").val()==""){
		$(".content7").text("详细信息不能为空");
		pd= false;
	}else{
		$(".content7").text("");
	}
}

//修改
	function fabu(){
	
	pd=true;
	yztitle();yz2();yz5();yz6();yz7();
	if(pd){
		var title=$("[name=title]").val();
		 var price=$("[name=price]").val();
		var daddress=$("[name=detailAddress]").val();
		var phone=$("[name=contact]").val();
		var detail= $("[name=description]").val();
		var jsonstr={};
		jsonstr["title"]=title;
		jsonstr["hid"]=hid;		
		jsonstr["price"]=price;	
		jsonstr["phone"]=phone;
		jsonstr["detail"]=detail;
		jsonstr["addressdetail"]=daddress;
		var jsonObj=JSON.stringify(jsonstr);
		
		$.post("../c/user",{"method":"updateInfo","jsonobj":jsonObj},function(txt){
			if(txt>0){
				alert("修改成功");
				location.href="../jsp/info.jsp";
			}else{
				alert("修改失败");
			}
		})
	}
	
	
	}
</script>
</html>