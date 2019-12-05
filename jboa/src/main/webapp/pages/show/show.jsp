<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>首页</title>
		<!-- plugins:css -->
		<link rel="stylesheet" href="../../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
		<link rel="stylesheet" href="../../vendors/css/vendor.bundle.base.css">
		<!-- endinject -->
		<!-- inject:css -->
		<link rel="stylesheet" href="../../css/style.css">
		<!-- endinject -->
		<link rel="shortcut icon" href="../../../../images/favicon.png" />
	</head>

	<body style="padding: 10px;width: 1000px;" onload="showDT()">

		<div class="page-header  border-bottom" style="padding-bottom: 5px;">
			<h3 class="page-title">
              <span class="page-title-icon bg-gradient-primary text-white mr-2">
                <i class="mdi mdi-home"></i>                 
              </span>
              	首页
            </h3>
            <blockquote class="blockquote float-right rard" style="width: 290px;padding: 5px;margin-right: 20px;">
				<h4 id="theClock" class="mb-0 ml-1 text-danger" style="text-align: center;">
	            </h4>
			</blockquote>
		</div>
		<img  src="../../images/timg (2).jpg" width="99%" height="260" style="margin-bottom: 5px;"/>
		<blockquote class="blockquote blockquote-primary" style="margin: auto;width: 568px;">
			<h3 class="mb-0 ml-1 text-info" style="text-align: center;">
                        <i class="mdi mdi-compass icon-md text-success"></i>
                        	我的办公
            </h3>
			<button type="button" class="btn btn-outline-danger btn-icon-text" style="margin-right: 18px;width: 160px;margin-top: 10px;" onclick="Switch('one')">
                <i class="mdi mdi-run btn-icon-prepend"></i>                                                    
              	请假
            </button>
			<button type="button" class="btn btn-outline-warning btn-icon-text" style="margin-right: 18px;width: 160px;margin-top: 10px;" onclick="Switch('two')">
                <i class="mdi mdi-food btn-icon-prepend"></i>                                                    
                                申请报销
            </button>
			<button type="button" class="btn btn-outline-info btn-icon-text" style="width: 160px;margin-top: 10px;" onclick="Switch('three')">
                <i class="mdi mdi-send btn-icon-prepend"></i>                                                    
               	发送信件
           </button>
           <footer class="blockquote-footer" style="margin-top: 15px;">简单整理 不一样的你从<cite title="Source Title" class="font-weight-bold">工作开始</cite></footer>
		</blockquote>

	</body>
	<script src="/jboa/js/jquery-1.12.4.js"></script>
	<script>
		var days=new  Array ("日", "一", "二", "三", "四", "五", "六");  
		function showDT() {  
		  var currentDT = new Date();  
		  var y,m,date,day,hs,ms,ss,theDateStr;  
		  y = currentDT.getFullYear(); //四位整数表示的年份  
		  m = currentDT.getMonth()+1; //月  
		  date = currentDT.getDate(); //日  
		  day = currentDT.getDay(); //星期  
		  hs = currentDT.getHours(); //时  
		  ms = currentDT.getMinutes(); //分  
		  ss = currentDT.getSeconds(); //秒  
		  theDateStr = y+"年"+  m +"月"+date+"日  星期"+days[day]+"  "+hs+":"+ms+":"+ss;  
		  document.getElementById("theClock"). innerHTML =theDateStr;  
		  // setTimeout 在执行时,是在载入后延迟指定时间后,去执行一次表达式,仅执行一次  
		  window.setTimeout( showDT, 1000);  
		}  
		function Switch(text){
			switch(text){
				case 'one':
					window.location="";
				break;
				case 'two':
					window.location="";
				break;
				case 'three':
					window.location="";
				break;
			}
		}
	</script>
</html>