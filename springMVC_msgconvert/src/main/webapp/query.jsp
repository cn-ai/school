<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
			table tr td{
				
				text-align: center;
				height: 30px;
			}
			table tbody tr:nth-child(even){
				background: greenyellow;
			}
		</style>
</head>
<body>
<form action="" id="myform">
		<table border="1" width="600" style="margin: auto;">
			<thead>
				<tr ><td colspan="5"><h2>订单列表</h2></td></tr>
				<tr style="background: lightseagreen;">
					<td>单号</td>
					<td>单据日期</td>
					<td>供应商</td>
					<td>供应商地址</td>
					<td><input type="checkbox" id="DelAll" onchange="Check()"></td>
				</tr>
			</thead>
			<tbody id="content">
				
				
			</tbody>
		</table>
		<div style="margin-top: 10px;">
			<div style="display: inline; margin-left: 470px;">
			
		</div>
		<div style="display: inline; margin-left: 70px;">
				<a href="javascipt:void(0)" onclick="sy()">首页</a>
				<a href="javascipt:void(0)" onclick="t()">上一页</a>
				
				<a href="javascipt:void(0)" onclick="n()">下一页</a>
				<a href="javascipt:void(0)" onclick="Bot()">末页</a>
			</div>
			<div style="display: inline;margin-left: 130px;"><a href="#" class="delAll">删除</a></div>
		</div>
	</form>
		
</body>
<script type="text/javascript" src="/springMVC_msgconvert/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function(){
	show(1,2);
})

//显示
var pageInfo;
	function show(num,size){
		$.getJSON("/springMVC_msgconvert/bill/querylist",{"num":num,"size":size},function(res){
			$("#content").empty();
			pageInfo=res;	
			$.each(res.list,function(i,obj){	
				var tr="<tr>"+
						"<td>"+obj.billno+"</td>"+
						"<td>"+obj.billdate+"</td>"+
						"<td>"+obj.suppliername+"</td>"+
						"<td>"+obj.supplieraddress+"</td>"+
						"<td><input type='checkbox' class='Del' name='billno' value="+obj.billno+"></td>"+
						"</tr>";	
				$("#content").append(tr);
			})
			
		});
	}
	//首页
	 function sy(){
		if(pageInfo.firstPage==1){
			alert("已经是首页了");
		}
		show(1,2);
	}
	//上一页
	function t(){
		if(pageInfo.hasPreviousPage){
			show(pageInfo.prePage,pageInfo.pageSize);
		}else{
			alert("没有上一页了");
		}
	}
	//下一页
	function n(){
		if(pageInfo.hasNextPage){
			show(pageInfo.nextPage, pageInfo.pageSize);
		} else {
			alert("没有下一页");
		}
	}
	//尾页
	function Bot(){
		if(pageInfo.pageNum=o=pageInfo.lastPage){
			alert("已经是尾页了");
		}else{
		show(pageInfo.lastPage,pageInfo.pageSize);
		}
	}
//动态绑定
	$(document).on("click",".delAll",function(){
		if($("[name=billno]:checked").length==0){
			alert("请选择");
			return;
		}
		if(confirm("确定移出吗?")){
		var billno=$("[name=billno]:checked").serialize();
		$.get("/springMVC_msgconvert/bill/delbill",billno,function(map){			
			if(map.code=="200"){
				alert(map.msg);
				show(1,2);
			}
		});
		}
	})
//全选与反选	
	function Check(){
		if($("#DelAll").prop("checked")){
			for(var i=0;i<$("[name=billno]").length;i++){
				alert(i);
				$("[name=billno]:eq("+i+")").prop("checked",true);
			}
		}else{
			for(var i=0;i<$("[name=billno]").length;i++){
				$("[name=billno]:eq("+i+")").prop("checked",false);
			}
		}
	} 
</script>
</html>