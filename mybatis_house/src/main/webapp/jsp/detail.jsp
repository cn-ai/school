<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>房屋详情</title>
	<link rel="stylesheet" href="../css/goods_detail.css" type="text/css"></link>
		<link rel="stylesheet" href="../css/picture.css" type="text/css"></link>
</head>
<body>

	<%@include file="first.jsp"%>
	<!--
	作者：offline
	时间：2018-10-31
	描述：logo
-->
<div class="snack_bg">
	<div class="search">
		<div id="logo">
			<img src="../img/logo.gif">
		</div>
		<div class="ss">
			<input type="text" placeholder="请输入搜索关键字" name="name"> <input
				type="button" name="button">
		</div>

<!-- 上面div -->
		<div class="wrap fixed">
			<div class="snack_info fixed">
			<!-- 左边div -->
				<div class="wrap_left">
				<!-- 显示大图 -->
					<div id="zomm">
						<div class="all">
							<div class="top-img">
							<div class="activeimg">
								<img src="../img/1.jpg">
								<img src="../img/1.jpg">
								<img src="../img/1.jpg">
								<img src="../img/1.jpg">
								
							</div>
							<div class="left"><img src="../img/left.png"> </div>
							<div class="right"><img src="../img/right.png"></div>
					</div>
				</div>
					<!-- 显示数据库图片 -->
						
							<div class="bot-img" >
								<ul class="small">
									<li class="active"><img src="../img/1.jpg"  width="90px" height="90px"> </li>
									<li><img src="../img/1.jpg" width="90px" height="90px"> </li>
									<li><img src="../img/1.jpg"  width="90px" height="90px"> </li>
									<li><img src="../img/1.jpg"  width="90px" height="90px"> </li>
									
								</ul>
							</div>
			</div>
	</div>			
				<div class="wrap_right">
					<form action="javascript:addToCart(12613)" method="post"
						name="ECS_FORMBUY" id="ECS_FORMBUY">
						<h3 class="name">${g.name}</h3>
						<div class="price">
							<ul>
								<li class="price1">${info.title }</li>
									<li class="price2" id="price2">浏览人数:<span class="number"></span> <a>发布时间:${info.fabutime }</a></li>
							</ul>
							<div class="img"></div>
						</div>
						<div class="info_wrap" style="float:left;width:340px;">
							<p class="num">
								编号： <em>${info.hid }</em>
							</p>

							<p class="jifen">
								价格：<em>${info.price }元/月</em>
							</p>
							<p class="stock">
								户型： <em>${info.tname }</em>&nbsp;&nbsp;
							</p>
							<p class="num">
								面积： <em><SPAN>${info.areaid }m<SUP>²</SUP></SPAN></em>
							</p>
							<p class="num">
								位置： <em>${info.name}——${info.addressDetail }</em>
							</p>
							<div id="detail_bd" style="height:30px;">
						<div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare">
							<span class="bds_more" style="margin-top:-5px">分享到：</span> <a class="bds_qzone"
								title="分享到QQ空间" href="javascript:void(0);"></a> <a
								class="bds_tsina" title="分享到新浪微博" href="javascript:void(0);"></a>
							<a class="bds_tqq" title="分享到腾讯微博" href="javascript:void(0);"></a>
							<a class="bds_renren" title="分享到人人网" href="javascript:void(0);"></a>
						</div>
						<span class="collect"><a href="javascript:collect()">收藏</a></span>
					</div>
						</div>
					</form>
				
					<div style="float:left;width:350px;height:auto;margin-top:20px;">
					
					<ul class="content__aside__list" style="margin:0px;padding:0px">
                 					<li>
                 					<span class="content__aside__list--icon" style="background-image: url(../img/txt.jpg);"></span>
                 					<p class="content__aside__list--title">小娜比</p>
                 					<p style="font-size:14px;">中原地产代理（深圳）有限公司 </p>
               						<div class="big_p">
               							<div class="one_tp"><span></span></div>
               							<div class="two_phone">${info.phone }</div>
               						</div>	
               	  					</li>
               		</ul>
               		</div>
				</div>
			</div>
		</div>
	</div>

<!-- 下面div -->
	<div class="wrap fixed">
			<div class="detailed fixed">
			<!-- 左边 -->
				<div id="detail_cot"  style="float:left;">
					<div id="tabCot_product" class="tab">
					<!-- 内容 -->
						<DIV class=introduction>
							<div class="cn_title" style="cursor:pointer">
								<H4 style="color:#90c31f;border-bottom:4px solid #90c31f"><SPAN><STRONG>房源详细信息</STRONG></SPAN></H4>
								<H4><SPAN><STRONG>房屋配套</STRONG></SPAN></H4>
								<H4><SPAN><STRONG>经纪人</STRONG></SPAN></H4>
							</div>
							<DIV class=content>
							<H4 style="color:#90c31f"><SPAN><STRONG>房源详细信息</STRONG></SPAN></H4>
								<P style="text-indent: 40px;">${info.detail }</P>
							</DIV>
							<DIV class="pt" style="display:none">
							<H4 style="color:#90c31f"><SPAN><STRONG>房屋配套</STRONG></SPAN></H4>
								<p style="text-indent: 40px;"><img src="../img/whpt.png"></p>
						</DIV>
						<DIV class="broker" style="display:none">
							<H4 style="color:#90c31f"><SPAN><STRONG>经纪人</STRONG></SPAN></H4>
								<ul class="content__aside__list">
                 					<li>
                 					<span class="content__aside__list--icon" style="background-image: url(../img/txt.jpg);"></span>
                 					<p class="content__aside__list--title">小娜比</p>
                 					<p style="font-size:14px;">中原地产代理（深圳）有限公司 </p>
               
               	  					</li>
               				 	</ul>	
						</DIV>
					</div>			
				</div>
				<!-- 温馨提示 -->
					<!-- <div id="right_img" style="float:left;">
						<img src="../img/wxts.png">
					</div> -->
			</div>
	</div>
</div>
</BODY>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="../js/picture.js"></script>
  <script type="text/javascript">
 $(function(){
$.post("/mybatis_house/c/user",{"method":"listImg","hid":"${info.hid}"},function(res){
	if(res!=""){
	$(".activeimg").html("");
	$(".small").html("");
	$.each(res,function(i,obj){	
		var div="<img src='../img/"+obj.address+"'>";
		$(".activeimg").append(div);
		var  small="<li><img src='../img/"+obj.address+"' width='90px' height='90px'> </li>";
		$(".small").append(small);
	})
	}
},"json");


var hid=${info.hid};
//查看
$.post("../c/user",{"method":"loadInfo2","hid":hid},function(t){	
	 $(".number").text(t.count);
	//修改
	 var jsonstr={};
	 jsonstr["count"]=t.count;
	 jsonstr["hid"]=hid;
	 var jsonObj=JSON.stringify(jsonstr);
	 $.post("../c/user",{"method":"updateInfo","jsonobj":jsonObj},function(txt){
		 $.post("../c/user",{"method":"loadInfo2","hid":hid},function(t){	
			 $(".number").text(t.count);
		 },"json");
	 });
},"json");
  })

  //搜索框跳转
	$("[name=button]").click(function(){
  		location.href="../c/user?method=querydistrict";
  	})
  	$(".cn_title h4:eq(0)").click(function(){
  		$(this).css({"color":"#90c31f","border-bottom":"4px solid #90c31f","cursor":"pointer"});
  		$(this).siblings().css({"color":"black","border-bottom":"0px solid #90c31f"});
  		$(".broker").css("display","none");
  		$(".pt").css("display","none");
  		$(".content").css("display","block");
  	})
  	$(".cn_title h4:eq(1)").click(function(){
  		$(this).css({"color":"#90c31f","border-bottom":"4px solid #90c31f","cursor":"pointer"});
  		$(this).siblings().css({"color":"black","border-bottom":"0px solid #90c31f"});
  		$(".broker").css("display","none");
  		$(".content").css("display","none");
  		$(".pt").css("display","block");
  	})
  	$(".cn_title h4:eq(2)").click(function(){
  		$(this).css({"color":"#90c31f","border-bottom":"4px solid #90c31f","cursor":"pointer"});
  		$(this).siblings().css({"color":"black","border-bottom":"0px solid #90c31f"});
  		$(".pt").css("display","none");
  		$(".content").css("display","none");
 		$(".broker").css("display","block");
  	})
  	
  </script>
  
</html>