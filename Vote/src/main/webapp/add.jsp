<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setContentType("text/html;charset=UTF-8");
%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发布新投票</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
	var isIE = !!document.all;
	var sum = 1;
	function AddOption()
	{
		var voteoptions = document.getElementById("voteoptions");
		var _p = document.createElement("p");
		var _input = document.createElement("input");
		_input.type = "text";
		_input.className = "input-text";
		_input.setAttribute("name", "oname");
		_p.appendChild(_input);
		if(sum<5){
			var _a = document.createElement("a");
			_a.className = "del";
			_a.setAttribute("href", "javascript:;");
			if(isIE) {
				_a.attachEvent("onclick", DelOption);
			} else {
				_a.addEventListener("click", DelOption, false);
			}
			_a.appendChild(document.createTextNode("删除"));
			_p.appendChild(_a);
			voteoptions.appendChild(_p);
			sum++;
		}else{
				alert("最多有六个选项！");
		}
	}
	function DelOption(e)
	{
		if(sum==1){
			alert("最少有两个选项！");
		}else{
			if(!e) e = window.event;
			var a = e.srcElement || e.target;
			var obj = a.parentNode;
			obj.parentNode.removeChild(obj);
			sum--;
		}
	}
	function update(val){
		if(val.length>0){
			if(confirm("如果内容更新了，之前的投票将清0，您确定更新吗？")){
				return true;
			}
			return false;
		}else{
			return true;
		}
	}
</script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script></head>
<body>
<div id="header" class="wrap">
	<img src="images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="profile">
		<span id="user1" style="display: none"><a href="login.jsp">登录</a>&nbsp;&nbsp;<a href="register.jsp">注册</a></span>	
		<span id="user2" style="display: none"></span>	
		<span class="return"><a href="javascript:void(0)" name="fh">返回列表</a></span>
		<span class="addnew"><a href="javascript:void(0)" name = "add">添加新投票</a></span>
		<span class="modify"><a href="javascript:void(0)" name="wh">维护</a></span>
		
	</div>
	<div class="search">
		<form method="post" action="javascript:clike();">
			<input type="text" name="keywords" class="input-text" /><input type="button" name="submit" class="input-button" value="" />
		</form>
	</div>
</div>
	<div id="voteManage" class="box">
		<h2>添加新投票</h2>
		<div class="content">
		<form action="javascript:void(0)" id="form" >
				<dl>
					<dt>投票内容：</dt>
					<dd>
					   <input type="hidden" name="vs.vsId"  />
					   <input type="text" class="input-text" name="title" onblur="pd1()" />
					   <span id="pd1" style="font-size: 12px;color:red"></span>
					</dd>
					<dt>投票模式：</dt>
					<dd> 
						<select id="way" style="height: 35px">
							<option value="1">一天一次</option>
							<option value="0">只能一次</option>
						</select>
					</dd>
					<dt>投票类型：</dt>
					<dd> 
			  		   <input type="radio" value="0" name="type"  checked="checked"/>单选
					   <input type="radio" value="1" name="type"  />多选
					</dd>
					<dt>投票时间：</dt>
					<dd> 
			  		   <input type="date" name="start" /> 至 <input type="date" name="over" onblur="pd2()"  />
			  		    <span id="pd2" style="font-size: 12px;color:red"></span>
					</dd>
					<dt>投票选项：</dt>
					<dd id="voteoptions">
							<p>
								<input type="text" class="input-text" name="oname" />
								<a class="del" href="javascript:;" onclick="DelOption()">删除</a>
							</p>
							<p>
								<input type="text" class="input-text" name="oname"/>
								<a class="del" href="javascript:;" onclick="DelOption()">删除</a>
							</p>
					</dd>
					<dt></dt>
					<dd class="button">
						<input type="image" onclick="Add()" name="buttom" src="images/button_submit.gif" />
						<a href="javascript:;" onclick="AddOption()">增加选项</a>
						<a href="javascript:history.go(0)">取消操作</a>
					</dd>
				</dl>
			</form>
		</div>
	</div>
	<div id="footer" class="wrap">
		北大青鸟 &copy; 版权所有
	</div>
	<script>
		$(function(){
			if(window.sessionStorage.getItem("uid")!=null){
				$("#user2").show().text(window.sessionStorage.getItem("uname")+"，欢迎您!");
				$("#user2").append("<a href=\"javascript:out()\">退出</a>");
				
			}else{
				$("#user1").show();
			}
			$("[name=fh]").click(function(){
				window.location = "index.jsp";
			});
			$("[name=add]").click(function(){
				window.location = "add.jsp";
			});
			$("[name=wh]").click(function(){
				window.location = "index2.jsp";
			});
		});
		var pd = true;
		function pd1(){
			if($("[name=title]").val().trim().length==0){
				$("#pd1").text("请输入字符串");
				pd=false;
			}else{
				$("#pd1").text("");
			}
		}
		function pd2(){
			if($("[name=start]").val()==null&&$("[name=over]").val()==null){
				$("#pd2").text("请选择开始与结束的日期");
				pd=false;
			}else if($("[name=start]").val().length==0){
				$("#pd2").text("请选择开始日期");
				pd=false;
			}else if($("[name=over]").val().length==0){
				$("#pd2").text("请选择结束日期");
				pd=false;
			}else if($("[name=start]").val()>$("[name=over]").val()){
				$("#pd2").text("结束不能大于开始日期");
				pd=false;
			}else{
				$("#pd2").text("");
			}
			
		}
		function pd3(){
			for (var i = 0; i < $("[name=oname]").length; i++) {
				if($("[name=oname]:eq("+i+")").val().trim().length==0){
					alert("有选项未填写，如不需要可以自行删除。");
					pd=false;
					return;
				}
			}
		}
		function Add(){
			pd=true;
			pd1();pd2();pd3();
			if(pd){
				var json = {};
				json["title"] = $("[name=title]").val();
				json["type"] = $("[name=type]:checked").val();
				json["startdate"] = $("[name=start]").val();
				json["overdate"] = $("[name=over]").val();
				json["way"] = $("#way").val();
				json["uid"] = window.sessionStorage.getItem("uid");
				var jsonVote =  JSON.stringify(json);
				var Options ="";
				for (var i = 0; i < $("[name=oname]").length; i++) {
					Options += $("[name=oname]:eq("+i+")").val()+",";
				}
				Options = Options.substring(0,Options.lastIndexOf(','));
				$.post("/Vote/c/Action",{m:"addSubject","sub":jsonVote,"option":Options},function(date){
					 if (date.code=="200") {
						alert("新增成功");
						window.location = "index2.jsp";
					}else if(data.code="500"){
						alert("新增失败");
					}
				},"json");
			}
		};			
	</script>
</body>
</html>

