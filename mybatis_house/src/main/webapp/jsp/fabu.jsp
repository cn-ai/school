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
				<DD class=past>填写房屋信息</DD>
			
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
									<TD class=field>户 型：</TD>
									<TD><SELECT class=text name=type_id>
											<c:forEach items="${tlist }" var="t">
												<OPTION selected value=${t.tid }>${t.tname }</OPTION>
											</c:forEach>
									</SELECT> </TD>
								</TR>
								
								<TR>
									<TD class=field>面 积：</TD>
									<TD><INPUT id=add_action_floorage class=text type=text
										name=floorage onblur="yz3();" placeholder="请正确填写你的面积，只能为数字哦"></TD>
								</TR>
								<tr style="line-height: 20px;color:red"><td></td><td class="content2"></td></tr>
								<TR>
									<TD class=field>价 格：</TD>
									<TD><INPUT id=add_action_price class=text type=text
										name=price onblur="yz2();"  placeholder="请正确填写你的出售价格，只能为数字哦"></TD>
								</TR>
								<tr style="line-height: 20px;color:red"><td></td><td class="content3"></td></tr>
								<TR>
									<TD class=field>房产证日期：</TD>
									<TD><INPUT class=text type="date" name=houseDate onblur="yz4();">(yyyy-MM-dd)</TD>
								</TR>
								<tr style="line-height: 20px;color:red"><td></td><td class="content4"></td></tr>
								<TR>
									<TD class=field>位 置：</TD>
									<TD>区：<SELECT class=text name=district_id>
									<c:forEach items="${list }" var="l">
											<OPTION	selected value=${l.id }>${l.name }</OPTION>
									</c:forEach>
											</SELECT>
									</TD>
								</TR>
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
							<INPUT onclick="fh();" value="返回房屋列表"
								type=button>
						</DIV>
					</DIV>
				</FORM>
			</DIV>
		</DIV>	</DIV>

	
	
<!-- 点击新增图片 -->
 <div id="addImg" style="display:none;">
	
 	<div class="wrapper wrapper-content animated fadeIn">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>图片上传</h5>                     
                    </div>
                    <div class="ibox-content">
                        <form id="my-awesome-dropzone" class="dropzone dz-clickable f1" action="../c/user?method=addImg" >
                            <div class="dropzone-previews"></div>
                          <button type="submit" class="btn btn-primary pull-right imgbtn" style="display: none"></button>             
                       	<button class="btn btn-primary " type="button" style="margin-left:1100px;" onclick="fh();"> <span class="bold">上传</span>  </button>
                       		<button class="btn btn-warning " type="button" style="margin-left:1100px;" onclick="fh();"> <span class="bold">返回</span> </button>
                        <div class="dz-default dz-message"><span></span>
                        </div>
                       
                        </form>
                        <div>
                            <div class="m">*可上传多张图片或不上传</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
 
 </div>
	
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
	$(".f1").sumbit();
}
//导航的改变
$(".clearfix dd").click(function(){
	$(this).css({"background":"#09c","color":"#fff"});
	$(this).siblings().css({"background":"#fff","color":"black"});
})
//图片的隐藏
 $(".past").click(function(){
	$(".box").css("display","block");
	$("#addImg").css("display","none");
}) 


/* 上传图片 */
   $(document).ready(function () {

            Dropzone.options.myAwesomeDropzone = {

                autoProcessQueue: false,
                uploadMultiple: true,
                parallelUploads: 100,
                maxFiles: 100,

                // Dropzone settings
                init: function () {
                    var myDropzone = this;

                    this.element.querySelector("button[type=submit]").addEventListener("click", function (e) {
                        e.preventDefault();
                        e.stopPropagation();
                        myDropzone.processQueue();
                    });
                    this.on("sendingmultiple", function () {});
                    this.on("successmultiple", function (files, response) {
                    	alert("上传成功");
                    	
                    });
                    this.on("errormultiple", function (files, response) {
                    	alert("上传失败");
                    });
                }

            }

        });



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
	if($("[name=price]").val()<0){
		$(".content3").text("价格不能小于0");
		pd= false;
	}
	else if(isNaN($("[name=price]").val())==true){
		$(".content3").text("价格填写错误,不能含有中文和非法字符");
		pd= false;
	}else{
		$(".content3").text("");
	}
}
function yz3(){
	if($("[name=floorage]").val()==""){
		$(".content2").text("面积不能为空");
		pd= false;
	}
	//判断是否是数字
	else if(isNaN($("[name=floorage]").val())==true){
		$(".content2").text("面积填写错误,不能含有中文和非法字符");
		pd= false;
	}else{	
		$(".content2").text("");
	}
}
function yz4(){

	if($("[name=houseDate]").val()==""){
		$(".content4").text("房产证日期不能为空");
		pd= false; 
	}else{
		$(".content4").text("");
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
var hid = "";
//发布
	function fabu(){
	pd=true;
	yztitle();yz2();yz3();yz4();yz5();yz6();yz7();
	if(pd){
		var num="";		
		var today=new Date();
		var y=today.getFullYear();//年
		var m=today.getMonth()+1;//月
		if(m<10){
			m="0"+m;
		}
		var d=today.getDate();//日
		if(d<10){
			d="0"+d;
		}
		for(var i=1;i<=3;i++){
			num+=Math.floor(Math.random()*9);//获取三位随机数
		}  
		hid =y+m+d+num;
		
		var title=$("[name=title]").val();
		var typeid=$("[ name=type_id]").val();//
		var area=$("[name=floorage]").val();
		 var price=$("[name=price]").val();
		var houseDate=$("[name=houseDate]").val();
		var did=$("[name=district_id]").val();//
		var daddress=$("[name=detailAddress]").val();
		var phone=$("[name=contact]").val();
		var detail= $("[name=description]").val();
		var stid=1;
		var uid=${user.uid};
		var fabutime=y+"-"+m+"-"+d;
	
		var jsonstr={};
		jsonstr["hid"]=hid;
		jsonstr["title"]=title;
		jsonstr["typeid"]=typeid
		jsonstr["areaid"]=area;
		jsonstr["price"]=price;	
		jsonstr["propertyDate"]=houseDate;
		jsonstr["phone"]=phone;
		jsonstr["detail"]=detail;
		jsonstr["did"]=did;
		jsonstr["stid"]=stid;
		jsonstr["uid"]=uid;
		jsonstr["fabutime"]=fabutime;
		jsonstr["addressdetail"]=daddress;
		jsonstr["status"]=0;
		var jsonObj=JSON.stringify(jsonstr);
	
		$.post("../c/user",{"method":"addInfo","jsonobj":jsonObj},function(txt){
			if(txt=="yes"){
				alert("发布成功");
				$("#regLogin").css("display","none");
				$("#addImg").css("display","block");
			}else{
				alert("发布失败");
			}
		})
	}
	
	
	}
</script>
</html>