<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Purple Admin</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="images/logo.jpg" />
  <link rel="stylesheet" href="/jboa/css/jquery.slider.css">

  <style>
	body {
		background: #1f1e1e;
		font-family: "微软雅黑";
		color: #fff;
	}
	
	button {
		display: inline-block;
		padding: 6px 12px;
		line-height: 1.4;
		text-align: center;
		border: 1px solid transparent;
		border-radius: 4px;
		color: #fff;
		background-color: #5bc0de;
		border-color: #46b8da;
		cursor: pointer;
		font-size: 15px;
	}
	
	.container {
		/*width: 1080px;
		height: 600px;
		position: absolute;
		top: 0;
		left: 0;
		right: 0;
		bottom: 0;
		margin: auto;*/
	}
	
	.demo1 {
		width: 48%;
		height: 100%;
		float: left;
		padding: 20px;
	/*	border: 1px dashed #fff;*/
		border-radius: 4px;
		box-sizing: border-box;
		position: relative;
	}
	
/*	.demo2 {
		width: 48%;
		height: 100%;
		float: right;
		padding: 20px;
		border: 1px dashed #fff;
		border-radius: 4px;
		box-sizing: border-box;
		position: relative;
	}
	*/
	.btns,
	.slider,
	.result {
		margin-bottom: 40px;
	}
	
	pre {
		font-size: 13px;
	}
</style>
  
</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-center auth">
        <div class="row w-100">
          <div class="col-lg-4 mx-auto">
            <div class="auth-form-light text-left p-5">
              <div>
                 <img class="brand-logo" src="images/bitbug_favicon.ico" alt="logo" width="48" height="48" />
				 <h2 style="display: inline;color:#198ae3">清泉办公管理系统</h2>
              </div>
            
              <form class="pt-3" action="/jboa/login/dl" method="get" id="cn_myform" >
                <div class="form-group">
                  <h5 style="color:black;">用户名:</h5>
                  <input type="email" name="employeename" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="用户名">
                </div>
                <div class="form-group">
                  <h5 style="color:black;">密码:</h5>
                  <input type="password" name="password" class="form-control form-control-lg" id="exampleInputPassword1" placeholder="密码">
                </div>
         
                <div class="container mt-3" style="height:34px;">
					
						<div id="slider1" class="slider"></div>
							<div class="result" style="margin: 0px;display: none;">验证结果：<span id="result1"></span></div>
    				
   				 </div>      
                <div class="" style="margin-top: 20px;">
                <input type="button" value="登      录" class="dl btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn"/>
                </div>
               
              </form>
            </div>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="vendors/js/vendor.bundle.base.js"></script>
  <script src="vendors/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="js/off-canvas.js"></script>
  <script src="js/misc.js"></script>
  <!-- endinject -->
</body>
<script type="text/javascript" src="/jboa/js/login/jquery.min.js"></script>
<script type="text/javascript" src="/jboa/js/login/jquery.slider.min.js"></script>
<script type="text/javascript">
	$(".dl").click(function(){
		var name=$("[name=employeename]").val();
		var pwd=$("[name=password]").val();
		var yz=$("#result1").text();
		if(name==""){
			alert("用户名不能为空");
			return false;
		}
		if(pwd=""){
			alert("密码不能为空");
			return false;
		}
		if(yz==false){
			alert("请滑动验证码！");
			return false;
		}
		$("#cn_myform").submit();
	})

	$("#slider1").slider({
		callback: function(result) {
			$("#result1").text(result);
		}
	});
	
/*
	$("#slider2").slider({
		width: 340, // width
		height: 40, // height
		sliderBg: "rgb(134, 134, 131)", // 滑块背景颜色
		color: "#fff", // 文字颜色
		fontSize: 14, // 文字大小
		bgColor: "#33CC00", // 背景颜色
		textMsg: "按住滑块，拖拽验证", // 提示文字
		successMsg: "验证通过了哦", // 验证成功提示文字
		successColor: "red", // 滑块验证成功提示文字颜色
		time: 400, // 返回时间
		callback: function(result) { // 回调函数，true(成功),false(失败)
			$("#result2").text(result);
		}
	});*/

	// 还原
	$("#reset1").click(function() {
		$("#slider1").slider("restore");
	});

/*	$("#reset2").click(function() {
		$("#slider2").slider("restore");
	});*/
</script>

</html>
