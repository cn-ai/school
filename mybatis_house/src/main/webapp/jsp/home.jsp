<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>房屋出租</title>

<link href="../css/head.css" rel="stylesheet" />
<link href="../css/goods.css" rel="stylesheet" />
<link href="../css/first.css" rel="stylesheet" />
<style type="text/css">
.cn_detail {
	margin-left: 135px;
}

.left {
	width: 260px;
	height: auto;
	border: 1px solid #ccc;
	float: left;
	margin: 5px;
}

.img li {
	list-style-type: none;
	margin-bottom: 10px;
}

.m_prod_info {
	margin-top: 0px;
	bottom: 0;
	left: 0;
	width: 260px;
	height: 65px;
	color: #fff;
	background-color: red;
}

.m_prod_name {
	margin-top: 0px;
}

</style>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
</head>

<body>
	<div>
		<div id="forbid"></div>

		<%@include file="first.jsp"%>
<!--
	作者：offline
	时间：2018-10-31
	描述：logo
-->
<div class="search">
	<div id="logo"><img src="../img/logo.gif"></div>
	<div class="ss">
	<input type="text" placeholder="请输入搜索关键字" name="name">
		<input type="button" name="button">		
	</div>
</div>
	<div class="fabu">
			<p class="item pub f-fl"><a onclick="fabuInfo()">免费发布信息</a><a>修改/删除</a></p>	
			
	</div>

		<div class="bg fixed">
			<div class="screen" id="screen_1" style="float: left;">
				<div class="crumbs">
					当前位置：<span><a title="房屋出租" href="">深圳市</a></span> <span
						class="partition">&gt;</span> <span>深圳租房</span>
				</div>
				<div id="close_div" class="sort fixed mt10">
					<a href="" class="re_filter">重置筛选条件</a>
					<div class="nonce">
						<b style="color: #444;">您筛选条件是：</b> <span id="delete_nonce"
							class="condition"><em>不限</em></span>
					</div>
					<!-- 位置-->
					<dl style="border: none;" class="fixed">
						<dt>
							<span>位置：</span> <a id="type_show" onclick="showType(1)"
								title="更多" class="more" href="javascript:void(0)"></a> <a
								style="display: none" id="type_hidden" title="更多" class="hidden"
								href="javascript:void(0)" onclick="showType(0)"></a>
						</dt>
						<dd id="type_dd" style="overflow: hidden; height: 24px;">
							<span id="type" style="display: none;"></span> <a class="on"
								onclick="getToPageType('brand','null','null');">区</a>
							<c:forEach items="${list }" var="d">
								<a onclick="getToPageType('type', '${d.id}','${d.name }');"
									title="${d.name }">${d.name }</a>
							</c:forEach>
						</dd>
					</dl>

					<!-- 房型-->
					<dl style="border: none;" class="fixed">
						<dt>
							<span>房型：</span> <a onclick="showBrand(1)" id="brand_show"
								title="更多" class="more" href="javascript:void(0)"></a> <a
								onclick="showBrand(0)" style="display: none" id="brand_hidden"
								title="更多" class="hidden" href="javascript:void(0)"></a>
						</dt>
						<dd id="brand_dd" style="overflow: hidden; height: 24px;">
							<span id="brand" style="display: none;"></span> <a class="on"
								onclick="getToPageType('brand','null','null');">不限</a>
							<c:forEach items="${tlist }" var="t">
								<a onclick="getToPageType('brand', '${t.tid}','${t.tname}');"
									title="${t.tname}">${t.tname}</a>
							</c:forEach>
						</dd>
					</dl>
					<!-- 面积-->
					<dl class="fixed">
						<dt>
							<span>面积：</span> <a onclick="showRegion(1)" id="region_show"
								title="更多" class="more" href="javascript:void(0)"></a> <a
								onclick="showRegion(0)" style="display: none" id="region_hidden"
								title="更多" class="hidden" href="javascript:void(0)"></a>
						</dt>
						<dd id="region_dd" style="overflow: hidden; height: 24px;">
							<span id="region" style="display: none;"></span> <a
								onclick="getToPageType('region','null');" class="on">不限</a>						
								<a onclick="getToPageType('region','300','300');"
									title="300">300m²</a>
								<a onclick="getToPageType('region','400','400');"
									title="400">400m²</a>
									<a onclick="getToPageType('region','500','500');"
									title="500">500m²</a>
									<a onclick="getToPageType('region','600','600');"
									title="600">600m²</a>
									<a onclick="getToPageType('region','700','700');"
									title="700">700m²</a>						
						</dd>
					</dl>
					<!-- 价格 -->
					<dl class="fixed">
						<dt>
							<span>价格：</span>
						</dt>
						<dd>
							<span id="price" style="display: none;">null</span> <a class="on"
								onclick="getToPageType('price','null','null');">不限</a> <a
								onclick="getToPageType('price', '0','800');">800元以下</a> <a
								onclick="getToPageType('price', '800','1500');">800元-1500元</a> <a
								onclick="getToPageType('price', '1500','2000');">1500元-2000元</a>
							<a onclick="getToPageType('price', '2000','3000');">2000元-3000元</a>
							<a onclick="getToPageType('price', '3000','4000');">3000元-4000元</a>
							<a onclick="getToPageType('price', '4000','100000');">4000元以上</a>
						</dd>
					</dl>
				</div>
			<script type="text/javascript">
			//切换参数
				function getToPageType(arg1,arg2,arg3){
				$("#"+arg1+"").text(""+arg2+"");	
				if (arg1=="price"&&$("#price").text()!="null") {
					$("#lowprice").val(arg2);
					$("#upprice").val(arg3);
				} 			
				var st=$("#"+arg1+"").parent().prev().find("span").text();
				if ($("#"+arg1+"").text()!="null") {
				$("#delete_nonce").css("display","none");
					$("#"+arg1+"").parent().parent().css("display","none");
					var txt=$("<span id='delete_"+arg1+"' class='condition'><em>"+st+arg3+"</em><a title='关闭' onclick='condition_close(this,\""+arg1+"\")'>X</a></span>");
					if (arg1=="price") {
						txt=$("<span id='delete_"+arg1+"' class='condition'><em>"+st+arg2+"-"+arg3+"</em><a title='关闭' onclick='condition_close(this,\""+arg1+"\")'>X</a></span>");
					}
					$(".nonce").append(txt);
				}
				page(1);
			}
			//删除筛选条件
			function condition_close(obj,arg){			
				$("#"+arg+"").text("null");		
				$(obj).parent().remove();
				$("#"+arg+"").parent().parent().css("display","block");
				if (arg=="price") {
					$("#lowprice").val("");
					$("#upprice").val("");
				}
				
				if (($("#type").text()=="null" || $("#type").text()=="") &&($("#brand").text()=="null"|| $("#brand").text()=="")&&($("#taste").text()=="null"|| $("#taste").text()=="")&&($("#region").text()=="null"|| $("#region").text()=="")&&($("#price").text()=="null")||$("#price").text()=="") {
					$("#delete_nonce").css("display","inline");
				}
				
				page(1);
				
			}
			//①展开收起
			function showType(num){
			
				if (num==1) {
					$("#type_show").css("display","none");
					$("#type_hidden").css("display","block");
					$("#type_dd").css("height","auto");
				} else {
					$("#type_show").css("display","block");
					$("#type_hidden").css("display","none");
					$("#type_dd").css("height","24px");
				}
			}
			//②展开收起
			function showBrand(num){
				if (num==1) {
					$("#brand_show").css("display","none");
					$("#brand_hidden").css("display","block");
					$("#brand_dd").css("height","auto");
				} else {
					$("#brand_show").css("display","block");
					$("#brand_hidden").css("display","none");
					$("#brand_dd").css("height","24px");
				}
			}	
			//③展开收起
			function showRegion(num){
				if (num==1) {
					$("#region_show").css("display","none");
					$("#region_hidden").css("display","block");
					region_dd.style.overflow = "visible";
					region_dd.style.height="auto";
				} else {
					$("#region_show").css("display","block");
					$("#region_hidden").css("display","none");
					region_dd.style.overflow = "hidden";
					region_dd.style.height="24px";
				}
			}
			</script>
				<!-- 导航完 -->
				<!-- 筛选条件结束  -->
				<div class="rank" id="floatrank">
					<ul class="fl">
						<li><b><a>排序：</a></b></li>

						<li><a onclick="fl('newon')" title="点击之后按面积从大到小排列"
							rel="nofollow">面积 <i class="ico1"></i>
						</a></li>
						<li><a onclick="fl('time')" title="点击之后按时间从高到低排列"
							rel="nofollow">时间 <i class="ico1"></i>
						</a></li>
						<li><a title="点击之后按价格从高到低排列" rel="nofollow">价格 <i
								class="ico3"></i>
						</a></li>
						<li id="fl" style="display: none;"></li>
						<li>价格区间: <input type="text" name="lowprice" id="lowprice"
							class="input" value=""> - <input type="text"
							name="upprice" id="upprice" class="input" value=""> <a
							href="javascript:void(0)" class="btn_fix" id="pricebtn">确定</a>
						</li>
						<li id="page" class="page">
					<span>共<em>${page.totalSize}</em>个商品&nbsp;&nbsp;<em>${page.currentPage}</em>/${page.totalPage}</span>
					<a href="javascript:void(0)" onclick="page('${page.prevPage}')" class="btn_fix first" title="已经是首页">上一页</a>
					<a href="javascript:void(0)" onclick="page('${page.nextPage}')" class="btn_fix" title="下一页">下一页</a>
				</li>
					</ul>
				</div>

				<script type="text/javascript">
			$(function (){
				page(1);
			})
				function fl(arg){
				$("#fl").text(arg);
				page(1);
			}
			
			$("#pricebtn").click(function(){
				var low=$("#lowprice").val();
				var upp=$("#upprice").val();
				if (parseFloat(low)>parseFloat(upp)) {
					$("#lowprice").val(upp);
					$("#upprice").val(low);
				}
				page(1);
			});
			
			var bol = false;
			//面积
			$(".rank li:eq(1)").click(function(){
				$(this).find("i").addClass("ico2");
				$(this).siblings().find("i").removeClass("ico2");
				$(".rank li:eq(3)").find("i").removeClass("ico4 ico5");	
				bol = false;	
			});
			//时间
			$(".rank li:eq(2)").click(function(){
				$(this).find("i").addClass("ico2");
				$(this).siblings().find("i").removeClass("ico2");
				$(".rank li:eq(3)").find("i").removeClass("ico4 ico5");	
				bol = false;	
			});
			//价格
			$(".rank li:eq(3)").click(function(){				
				$(this).siblings().find("i").removeClass("ico2");
			//第一次点击为false
				if(!bol){				
					$(this).find("i").removeClass("ico5");
					$(this).find("i").addClass("ico4");
					$(this).find( "a").get(0).setAttribute("title","点击之后按价格从低到高排列");
					fl("desc");					
				}else{
					$(this).find("i").removeClass("ico4");
					$(this).find("i").addClass("ico5");
					$(this).find("a").get(0).setAttribute("title","点击之后按价格从高到低排列");
					fl("asc");
				}		
				bol = !bol;//点击完为反的
				
			});
//模糊查询
	$("[name=button]").click(function(){
		var name=$("[name=name]").val();
		page(1,name);
	})
		//查询房屋信息	
		function page(currentPage,name){
			var type=$("#type").text();//地区
			var brand=$("#brand").text();//房型
			var place=$("#region").text();//面积
			var search=$("#fl").text();//排序
			var begin=$("#lowprice").val();//最小价格
			var end=$("#upprice").val()//最大价格
			var jsonstr={};
			jsonstr["title"]=name;
			jsonstr["did"]=type;
			jsonstr["typeid"]=brand;
			jsonstr["areaid"]=place;
			jsonstr["status"]=0;
			var jsonObj=JSON.stringify(jsonstr);//序列化
			$.ajaxSettings.async=false;
			$.post("../c/user",{"method":"queryHouseVo","pageNum":currentPage,"jsonObj":jsonObj,"search":search,"priceBegin":begin,"priceEnd":end},function(res){		
				$(".cn_xdiv").empty();
				$("#page").empty();
				
				if(res.total!=0){
					var list=res.list;
					$("#snacklist").html("");
				var page="<span>共<em>"+res.total+"</em>个商品&nbsp;&nbsp;<em>"+res.pageNum+"</em>/"+res.pages+"</span>"
				+"&nbsp;<a href='javascript:void(0)' onclick='page("+res.prePage+")' class='btn_fix first' title='已经是首页'>上一页</a>"	
				+"&nbsp;<a href='javascript:void(0)' onclick='page("+res.nextPage+")' class='btn_fix' title='下一页'>下一页</a>";
				document.getElementById("page").innerHTML=page;
				$.each(list,function(i,obj){
				var img="";
					$.ajax({
						async:true,
						url:'../c/user',
						data:{"method":"loadImg","hid":obj.hid},
						dataType:'json',
						type:'post',
						success:function(res){
							if(res==null){
								img+="<img src='../img/1.jpg' width='180px' height='130'>";
							}else{
								img+="<img src='../img/"+res.address+"' width='180px' height='130'>";
							}
												
					var div="<div class='bottom_div'>"+
							"<dl class='cn_dl1' onmouseover='m_over(this)' onmouseout='m_out(this)'>"+
					"<dt > "+img+"</dt>"+
					"<div class='big'>"+
					"<dd class='cn_right'>"+
					"<a href='javaScript:void(0)' onclick='detail(\""+obj.hid+"\")' onmouseover='m_over1(this)' onmouseout='m_out1(this)'>"+obj.title+"</a>"+
					"</dd>"+
					"<dd class='dd_item'>"+
						"<span>户型:"+obj.tname+"|</span>"+
						"<span>面积："+obj.areaid+"m²</span>"+
					"</dd>"+
					"<dd class='dd_item2'>"+
						"<span>详细地址:"+obj.name+"&nbsp;&nbsp;"  +obj.addressDetail+"</span>"+
					"</dd>"+
					"<dd class='info'>"+
		               "<div class='price'><span class='num'>"+obj.price+"</span><span class='yue'>元/月</span></div>"+
		            	"<div class='time'>发布时间:"+obj.fabutime+"</div>"+
		             "</dd>"+
					"</div>"+
				"</dl>"+
			"</div>";
			$(".cn_xdiv").append(div);
						}	
					})
				})
				}else if(res.total==0){
				$("#snacklist").html("<p style='text-align:center;'><img src='../img/not_find_note.png'><br>很抱歉，没有找到相符的房源</p>");
			}
				if (res.pageNum>1) {
							$("#page").find("a:first").removeClass("first");
							$("#page").find("a:first").get(0).setAttribute("title","上一页");
							$("#page").find("a:last").get(0).setAttribute("title","下一页");
							if (res.pageNum==res.pages) {									
								$("#page").find("a:last").addClass("first");
								$("#page").find("a:last").get(0).setAttribute("title","已经是末页");
							}
						}
				if (res.pageNum==res.pages) {	
					$("#page").find("a:last").addClass("first");
					$("#page").find("a:last").get(0).setAttribute("title","已经是末页");
				}
				
			},"json");
			$.ajaxSettings.async=true;
		}
	//修改分页	
	function detail(id){	
		location.href="../c/user?method=loadInfo&hid="+id;
	}	
	function m_over(t){
		$(t).css("background","#eee");
	}
	function m_out(t){
		$(t).css("background","#fff");
	}
	function m_over1(t){
		$(t).css({"color":"red","text-decoration":"underline"});
	}
	function m_out1(t){
		$(t).css({"color":"black","text-decoration":"none"});
	}
/* 发布房源 */	
	function fabuInfo(){
		if(!${empty user}){
			location.href="../c/user?method=queryAdd";
		}else{			
			location.href="../jsp/denglu.jsp?a=1";
		}
			
	}
			</script>
				<div class="snack_wrap fixed">
					<ul id="snacklist">

					</ul>
				</div>

			</div>
		</div>
	</div>
	<div class="cn_xdiv"></div>
</body>


</html>