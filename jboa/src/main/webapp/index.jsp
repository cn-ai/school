<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>清泉办公管理系统</title>
		<!-- plugins:css -->
		
		<link rel="stylesheet" href="/jboa/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
		<link rel="stylesheet" href="/jboa/vendors/css/vendor.bundle.base.css">
		<!-- endinject -->
		<!-- inject:css -->
		<link rel="stylesheet" href="/jboa/css/style.css">
		<!-- endinject -->
		<link rel="shortcut icon" href="/jboa/images/logo.jpg" />
		 <link href="/jboa/css/query/style.css?v=4.1.0" rel="stylesheet">
	<style>
		.cn_ld .label{
			line-height: 12px;
   			 padding: 1px 5px;
    		position: absolute;
   			 right: 0px;
    		top: 12px;	
    		left: 6px;
    	 	border-radius: 50%;
		}
		.nav-link .label{
			    display: inline;
    			padding: .2em .6em .3em;
    			font-size: 75%;
    			font-weight: 700;
    			line-height: 1;
    			color: #fff;
    			text-align: center;
   				white-space: nowrap;
   				vertical-align: baseline;
    			border-radius: 50%;
		}
	</style>
	</head>

	<body>
		<div class="container-scroller">
			<!-- partial:partials/_navbar.html -->
			<nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
				<div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
					<img class="brand-logo" src="/jboa/images/bitbug_favicon.ico" alt="logo" width="32" height="32" />
					<a class="navbar-brand" style="width: 200px;" href="index.html">清泉办公管理系统</a>

				</div>
				<div class="navbar-menu-wrapper d-flex align-items-stretch">

					<ul class="navbar-nav navbar-nav-right">
						<li class="nav-item nav-profile dropdown">
							<a class="nav-link dropdown-toggle" id="profileDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
								<div class="nav-profile-img">
									<img src="/jboa/images/faces/face1.jpg" alt="image">
									<span class="availability-status online"></span>
								</div>
								<div class="nav-profile-text">
									<p class="mb-1 text-black">${emp.employeename }</p>
								</div>
							</a>
							<div class="dropdown-menu navbar-dropdown" aria-labelledby="profileDropdown">
								<a class="dropdown-item" href="/jboa/login.jsp">
									<i class="mdi mdi-cached mr-2 text-success"></i> 切换用户
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/jboa/login.jsp">
									<i class="mdi mdi-logout mr-2 text-primary"></i> 退出登陆
								</a>
							</div>
						</li>
						<li class="nav-item d-none d-lg-block full-screen-link">
							<a class="nav-link">
								<i class="mdi mdi-fullscreen" id="fullscreen-button"></i>
							</a>
						</li>

						<li class="nav-item dropdown">
							<a style="width: 30px;" class="nav-link count-indicator dropdown-toggle cn_ld" id="notificationDropdown" href="#" data-toggle="dropdown">
								<i class="mdi mdi-bell-outline"></i>
								<span class="label label-danger" id="cn_msg"></span>
								<!--通知红点-->
							</a>
							<div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="notificationDropdown">
								<h6 class="p-3 mb-0">通知栏</h6>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item preview-item">
									<div class="preview-thumbnail">
										<div class="preview-icon bg-success">
											<i class="mdi mdi-calendar"></i>
										</div>
									</div>
									<div class="preview-item-content d-flex align-items-start flex-column justify-content-center" id="cn_message">
										<h6 class="preview-subject font-weight-normal mb-1">请假申请</h6>
										<p class="text-gray ellipsis mb-0">
											
										</p>
									</div>
								</a>
								
									

								
								<div class="dropdown-divider"></div>
								<h6 class="p-3 mb-0 text-center">my mailbox</h6>
							</div>
						</li>
					</ul>
					<button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="mdi mdi-menu"></span>
        </button>
				</div>
			</nav>
			<!-- partial -->
			<div class="container-fluid page-body-wrapper">
				<!-- partial:partials/_sidebar.html -->
				<nav class="sidebar sidebar-offcanvas" id="sidebar">
					<ul class="nav">
						<li class="nav-item nav-profile">
							<a href="#" class="nav-link">
								<div class="nav-profile-image">
									<img src="/jboa/images/faces/face1.jpg" alt="profile">
									<span class="login-status online"></span>
									<!--change to offline or busy as needed-->
								</div>
								<div class="nav-profile-text d-flex flex-column">
									<span class="font-weight-bold mb-2">${emp.employeename }</span>
									<span class="text-danger text-small" style="color:#fe7c7c66">部门:${emp.department.departmentname }</span>
									
									<span class="text-danger text-small" style="margin-top:5px;color:#fe7c7c66">职位:${emp.position.positionname }</span>
								</div>
								<i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="JavaScript:void(0);">
								<span class="menu-title"  onclick="Switch(this)">首页</span>
								<i class="mdi mdi-home menu-icon"></i>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="collapse" href="#ui-bill" aria-expanded="false" aria-controls="ui-bill">
								<span class="menu-title">报销单管理</span>
								<i class="menu-arrow"></i>
								<i class="mdi mdi-food menu-icon"></i>
							</a>
							<div class="collapse" id="ui-bill">
								<ul class="nav flex-column sub-menu">
									<li class="nav-item">
										<a class="nav-link cn_addbx" url="bxList.jsp" onclick="Switch(this)">新增报销单</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" url="/jboa/remburse/querylist" onclick="Switch(this)">查看报销单</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="collapse" href="#ui-leave" aria-expanded="false" aria-controls="ui-leave">
								<span class="menu-title">请假管理</span>
								<i class="menu-arrow"></i>
								<i class="mdi mdi-run menu-icon"></i>
							</a>
							<div class="collapse" id="ui-leave">
								<ul class="nav flex-column sub-menu">
									<li class="nav-item">
										<a class="nav-link" href="javascript:void(0)" onclick="Switch(this)">请假</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="javascript:void(0)" onclick="Switch(this)">查看请假</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="collapse" href="#ui-statistics" aria-expanded="false" aria-controls="ui-statistics">
								<span class="menu-title">统计报表</span>
								<i class="menu-arrow"></i>
								<i class="mdi mdi-file-chart  menu-icon"></i>
							</a>
							<div class="collapse" id="ui-statistics">
								<ul class="nav flex-column sub-menu">
									<li class="nav-item">
										<a class="nav-link" href="javascript:void(0)" onclick="Switch(this)">报销单月度统计</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="javascript:void(0)" onclick="Switch(this)">报销单年度统计</a>
									</li>

								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="collapse" href="#ui-message" aria-expanded="false" aria-controls="ui-message">
								<span class="menu-title">信息中心</span>
								<!-- <span class="label label-danger">16</span> -->
								<i class="menu-arrow"></i>
								<i class="mdi mdi-message-processing menu-icon"></i>
							</a>
							<div class="collapse" id="ui-message">
								<ul class="nav flex-column sub-menu">
									<li class="nav-item">
										<a class="nav-link"  url="/jboa/leave/queryMessage?pageNum=1&addressees_id=${emp.employeeid }" onclick="Switch(this)">信息收件箱</a>
									</li>
									
								</ul>
							</div>
						</li>
					</ul>
				</nav>
				<!-- partial -->
				<div class="main-panel">
					<div class="content-wrapper">
						<iframe id="iframe" src="pages/show/show.jsp" style="overflow: visible;" scrolling="yes" frameborder="no" width="100%" height="1000">
          	
          </iframe>
					</div>
					<!-- content-wrapper ends -->
					<!-- partial:partials/_footer.html -->
					<footer class="footer">
						<div class="d-sm-flex justify-content-center justify-content-sm-between">
							<span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2099 <a href="" target="_blank">BootstrapDash</a>. All rights reserved. </span>
							<span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with
              <i class="mdi mdi-heart text-danger"></i> - More Templates <span style="color: #1bcfb4;">研发二部</span> - -<i class="mdi mdi-heart text-danger"></i>曹娜<i class="mdi mdi-heart text-danger"></i> </span>
						</div>
					</footer>
					<!-- partial -->
				</div>
				<!-- main-panel ends -->
			</div>
			<!-- page-body-wrapper ends -->
		</div>
		<!-- container-scroller -->

		<!-- plugins:js -->
		<script src="/jboa/vendors/js/vendor.bundle.base.js"></script>
		<script src="/jboa/vendors/js/vendor.bundle.addons.js"></script>
		<!-- endinject -->
		<!-- Plugin js for this page-->
		<!-- End plugin js for this page-->
		<!-- inject:js -->
		<script src="/jboa/js/off-canvas.js"></script>
		<script src="/jboa/js/misc.js"></script>
		<!-- endinject -->
		<!-- Custom js for this page-->
		<script src="/jboa/js/dashboard.js"></script>
		<!-- End custom js for this page-->
	</body>
	<script src="/jboa/js/jquery-1.12.4.js"></script>
	<script>
		function Switch(site) {
		
			switch($(site).text()) {
				case "首页":
				$("#iframe").attr("src","pages/show/show.jsp");
					break;
				case "新增报销单":
					var url=$(site).attr("url");
					$(".content-wrapper iframe").attr("src",url);
					break;
				case "查看报销单":
						var url=$(site).attr("url");
					$(".content-wrapper iframe").attr("src",url);
					break;
				case "请假":
					$("#iframe").attr("src","pages/show/leave.jsp");
					break;
				case "查看请假":
					$("#iframe").attr("src","/jboa/leave/queryLeave?pageNum=1&positionid=${emp.position.positionid}&departmentid=${emp.department.departmentid}&employeeid=${emp.employeeid}");	
					break;
				case "报销单月度统计":
					$("#iframe").attr("src","pages/show/monthlyStatistics.jsp");
					break;
				case "报销单年度统计":
						$("#iframe").attr("src","pages/show/yearlyStatistics.jsp");
					break;
				case "信息收件箱":
					var url=$(site).attr("url");
					$(".content-wrapper iframe").attr("src",url);
					break;
				
			}
		}
 </script>
<script type="text/javascript">

	 
	var count = 0;
	//ajax轮询消息
	window.setInterval(Message,4000); 
	
    function Message() {
    	count = 0;
    	
    	$("#cn_message").html("");
    	
    	$.post("/jboa/leave/queryMessageAjax",{"addressees_id":${emp.employeeid},"pageNum":1},function(res){
    		$.each(res.list,function(i,data){
    		
    				count++;
    				/* 消息数量 */
    				$("#cn_msg").text(count);
    				/* 提示内容信息 */
    				var ht = "";
    					//请假
    					if(data.type_id==1){
    						var message = "<h6 class=\"preview-subject font-weight-normal mb-1\">"+data.addresserName+"申请请假</h6>";
    						if(data.message_sta==2){
    							message = "<h6 class=\"preview-subject font-weight-normal mb-1\">您申请的请假,"+data.addresserName+"已审批</h6>";
    						}
    						ht = "<div class=\"dropdown-divider\"></div>"+
										"<a href='javascript:void(0)' onclick='Sw("+data.type_id+","+data.message_sta+","+data.biz_id+")' name='查看请假' class=\"dropdown-item preview-item\">"+
										"<div class=\"preview-thumbnail\">"+
											"<div class=\"preview-icon bg-success\">"+
											"	<i class=\"mdi mdi-run\"></i>"+
										"	</div>"+
										"</div>"+
										"<div class=\"preview-item-content d-flex align-items-start flex-column justify-content-center\">"+
										message+
										"	<p class=\"text-gray mb-0\">"+
										"申请时间："+data.createDate+
										"	</p>"+
									"	</div>"+
									"</a>";
    					}else{
    					//报销
    						ht = "<div class=\"dropdown-divider\"></div>"+
										"<a class=\"dropdown-item preview-item\">"+
										"<div class=\"preview-thumbnail\">"+
											"<div class=\"preview-icon bg-primary\">"+
											"	<i class=\"mdi mdi-food\"></i>"+
										"	</div>"+
										"</div>"+
										"<div class=\"preview-item-content d-flex align-items-start flex-column justify-content-center\">"+
										"	<h6 class=\"preview-subject font-weight-normal mb-1\">"+data.addresserName+"申请工作报销</h6>"+
										"	<p class=\"text-gray mb-0\">"+
										"申请时间："+data.createDate+
										"	</p>"+
									"	</div>"+
									"</a>";
    					}
    				$("#cn_message").append(ht);
    			
    		})
    		if(count==0){
    			$("#cn_message").html("<div class=\"dropdown-divider\"></div>"+
    					"<a class=\"dropdown-item preview-item\">"+
    					"<div class=\"preview-thumbnail\">"+
    					"</div>"+
    					"<div class=\"preview-item-content d-flex align-items-start flex-column justify-content-center\">"+
    					"	<h6 class=\"preview-subject font-weight-normal mb-1\"></h6>"+
    					"	<p class=\"text-gray mb-0\">"+
    					"		暂无新信息"+
    					"	</p>"+
    				"	</div>"+
    				"</a>");
    			$("#cn_msg").hide();
    		}
    	},"json");   
   	}
    function Sw(site,code,bId){
    	
    	if(site==1){
    		if(code==2){
    			$.post("/jboa/leave/updateMessageajax",{"bizId":bId,"addressees_id":${emp.employeeid}},function(ret){
    				
    			});
    		}
    		setTimeout(function(){
        		window.location="/jboa/leave/queryLeave?pageNum=1&positionid=${emp.position.positionid}&departmentid=${emp.department.departmentid}&employeeid=${emp.employeeid}";
        	},500);
    	}else if(site==2){
    		
    	}
    } 

</script>
</html>