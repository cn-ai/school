<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理页面</title>
<link href="../css/head.css" rel="stylesheet" />
<link href="../css/goods.css" rel="stylesheet" />
<link href="../css/first.css" rel="stylesheet" />
 <!-- Sweet Alert -->
    <link href="../css/sweetalert.css" rel="stylesheet">
<style type="text/css">
.items a{
    margin-right: 20px;
    background: #e9f3d2;
    color: #58ac05;
}
.items a{
     font-size: 16px; 
     display: inline-block; 
     width: 132px; 
    line-height: 36px;
    text-align: center;
}
.status{
width:132px;
height:36px;
margin-left:20px;
color: #555;
}
</style>
</head>
<body>
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
<select class="status">
<option value="-1">全部</option>
<option value="0">未出租</option>
<option value="1">已出租</option>
</select>
			<p class="item pub f-fl"><a onclick="fabuInfo()">免费发布信息</a><a class="out">退出</a></p>				
	</div>
	<div class="cn_div">
		
	</div>
	<div class="fy" style="width:1100px ;height:40px;text-align: center;">
	<ul class="fls">
			<li id="cpage">
					<span>共<em style="color:red">${page.totalSize}</em>个商品&nbsp;&nbsp;<em>${page.currentPage}</em>/${page.totalPage}</span>
					<a href="javascript:void(0)" onclick="page('${page.prevPage}')" class="btn_fix first" title="已经是首页">上一页</a>
					<a href="javascript:void(0)" onclick="page('${page.nextPage}')" class="btn_fix" title="下一页">下一页</a>
				</li>
	</ul>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
   <!-- Sweet alert -->
    <script src="../js/sweetalert.min.js"></script>
<script type="text/javascript">
$(function(){
	page(1,"",-1);
})
$(document).on("click",".out",function(){
		$.post("../c/user",{"method":"outSession"},function(txt){
			if(txt=="yes"){
				location.href="../c/user?method=querydistrict";
			}
		})
	})
//模糊查询
$("[name=button]").click(function(){
	var name=$("[name=name]").val();
	page(1,name);
})
//改变事件
$(".status").change(function(){
	var status=$(".status").val();
	page(1,"",status);
})
	//查询房屋信息	
	function page(currentPage,name,status){
		var type=$("#type").text();//地区
		var brand=$("#brand").text();//房型
		var place=$("#region").text();//面积
		var search="time";//排序
		var begin=$("#lowprice").val();//最小价格
		var end=$("#upprice").val()//最大价格
		var jsonstr={};
		jsonstr["uid"]=${user.uid};
		jsonstr["title"]=name;
		jsonstr["did"]=type;
		jsonstr["typeid"]=brand;
		jsonstr["areaid"]=place;
		jsonstr["status"]=status;	
		var jsonObj=JSON.stringify(jsonstr);//序列化
	
		$.ajaxSettings.async=false;
		$.post("../c/user",{"method":"queryHouseVo","pageNum":currentPage,"jsonObj":jsonObj,"search":search,"priceBegin":begin,"priceEnd":end},function(res){		

			$(".cn_div").empty();
			$("#cpage").empty();
			
			if(res.total!=0){
				var list=res.list;
				$("#snacklist").html("");
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
						var temp="";
							if(obj.status==0){
								temp="未出租";
							}else if(obj.status==1){
								temp="已出租";
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
				"<div class='fabu'>"+
				"<p class='items pub f-fl' style='margin-left:-300px;'><a onclick='xg(\""+obj.hid+"\")'>修改</a><a onclick='wcz(\""+obj.hid+"\","+obj.status+")'>"+temp+"</a><a class='' onclick='sc(\""+obj.hid+"\","+obj.status+")'>删除</a></p>"+
				"<div>"+
	             "</dd>"+
				"</div>"+
			"</dl>"+
		"</div>";
		$(".cn_div").append(div);
					}	
				})
			})
			
			var page="<span>共<em>"+res.total+"</em>个商品&nbsp;&nbsp;<em>"+res.pageNum+"</em>/"+res.pages+"</span>"
			+"&nbsp;<a href='javascript:void(0)' onclick='page("+res.prePage+")' class='btn_fix first' title='已经是首页'>上一页</a>"	
			+"&nbsp;<a href='javascript:void(0)' onclick='page(1)' class='btn_fix first' title='1' style='width:70px;height:50px;background:#e9f3d2;color:#58ac05'>1</a>"	
			+"&nbsp;<a href='javascript:void(0)' onclick='page(2)' class='btn_fix first' title='2' style='width:70px;height:50px;background:#e9f3d2;color:#58ac05'>2</a>"
			+"&nbsp;<a href='javascript:void(0)' onclick='page(3)' class='btn_fix first' title='3' style='width:70px;height:50px;background:#e9f3d2;color:#58ac05'>3</a>"
			+"&nbsp;<a href='javascript:void(0)' onclick='page("+res.nextPage+")' class='btn_fix' title='下一页'>下一页</a>";
			document.getElementById("cpage").innerHTML=page;
			
			}else if(res.total==0){
			$("#snacklist").html("<p style='text-align:center;'><img src='../img/not_find_note.png'><br>很抱歉，没有找到相符的房源</p>");
		}
			if (res.pageNum>1) {
						$("#cpage").find("a:first").removeClass("first");
						$("#cpage").find("a:first").get(0).setAttribute("title","上一页");
						$("#cpage").find("a:last").get(0).setAttribute("title","下一页");
						if (res.pageNum==res.pages) {	
							$("#cpage").find("a:last").addClass("first");
							$("#cpage").find("a:last").get(0).setAttribute("title","已经是末页");
						}
					}
			if (res.pageNum==res.pages) {	
				$("#cpage").find("a:last").addClass("first");
				$("#cpage").find("a:last").get(0).setAttribute("title","已经是末页");
			}
			
		},"json");
		$.ajaxSettings.async=true;
	}
	
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
//改变出租状态
function wcz(id,status){
	if(status==0){
		jsonstr={};
		jsonstr["hid"]=id;
		jsonstr["status"]=1;
		jsonobj=JSON.stringify(jsonstr);
		$.post("../c/user",{"method":"updateInfo","jsonobj":jsonobj},function(txt){
			if(txt>0){
				alert("你已成功出租一套房屋");
				page(1);
			}
		});
	}else if(status==1){
		jsonstr={};
		jsonstr["hid"]=id;
		jsonstr["status"]=0;
		jsonobj=JSON.stringify(jsonstr);

		$.post("../c/user",{"method":"updateInfo","jsonobj":jsonobj},function(txt){
			if(txt>0){
				alert("你已成功收回一套房屋");
				page(1);
			}
		});
	}
}
function xg(id){
	window.sessionStorage.setItem("hid",id);
	location.href="../jsp/update.jsp";
}





function sc(id,status){
	if(status==1){
		alert("此房源暂时不能删除");
		return;
	}else{
	 swal({
	        title: "您确定要删除这条信息吗",
	        text: "删除后将无法恢复，请谨慎操作！",
	        type: "warning",
	        showCancelButton: true,
	        confirmButtonColor: "#DD6B55",
	        confirmButtonText: "删除",
	        closeOnConfirm: false
	    }, function () {
	    	$.post("../c/user",{"method":"delInfo","hid":id},function(txt){
	    		if(txt>0){
	    		 swal("删除成功！", "您已经永久删除了这条信息。", "success");
	    		 page(1);
	    		}
	    	})
	    });
	}
}

</script>
</html>