<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>审核请假</title>
		<!-- plugins:css -->
		<link rel="stylesheet" href="../../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
		<link rel="stylesheet" href="../../vendors/css/vendor.bundle.base.css">
		<!-- endinject -->
		<!-- inject:css -->
		<link rel="stylesheet" href="../../css/style.css">
		<!-- endinject -->
		<link rel="shortcut icon" href="../../../../images/favicon.png" />
		<style type="text/css">
			tr td{
				padding: 5px;
			}
			body{
				padding: 10px;width: 1000px;
				background: #f2edf3;
			}
		</style>
	</head>
	<body>
		
		<div class="page-header border-bottom" style="padding-bottom: 5px;">
			<h3 class="page-title">
              <span class="page-title-icon bg-gradient-primary text-white mr-2">
                <i class="mdi mdi-run"></i>                 
              </span>
              修改请假情况	
           </h3>
		</div>
		
              <div class="card">
                  <div class="card-body">
				
		<table class="table" width="100%" style="text-align:center;border-color:#b66dff ;">
			<thead>
				<tr>
					<td colspan="4"><h3 class="font-weight-bold">请假详情</h3></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="font-weight-bold">
						填写人：
					</td>
					<td>郭胜强</td>
					<td class="font-weight-bold">部门：</td>
					<td>财务部</td>
				</tr>
				<tr>
					<td class="font-weight-bold">
						开始时间 <span style="color: red;">*</span>
					</td>
					<td><input type="date" class="form-control" style="text-align: center;font-size: 16px;height: 40px;padding: 5px;"></td>
					<td class="font-weight-bold">结束时间<span style="color: red;">*</span></td>
					<td><input type="date" class="form-control" style="text-align: center;font-size: 16px;height: 40px;padding: 5px;"></td>
				</tr>
				<tr style="display: none;">
					<td colspan="4" class="font-weight-bold" style="text-align: center;color: red;">错误提示：<span id="tishi">Meg</span></td>
				</tr>
				<tr>
					<td class="font-weight-bold">请假日期</td>
					<td colspan="3" style="text-align: center;"><span id="day">4</span> 天</td>
				</tr>
				<tr>
					<td class="font-weight-bold">请假事由 <span style="color: red;">*</span></td>
					<td colspan="3" style="text-align: center;">
                      <textarea class="form-control" id="exampleTextarea1" rows="4"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		 <table class="table table-striped" style="margin-top: 20px;">
		 							<thead >
		 								<tr style="text-align: center;">
		 									<td colspan="4"><h3 class="font-weight-bold">审批进度</h3></td>
		 								</tr>
		 							</thead>
				                    <thead>
				                      <tr>
				                        <th>审查人</th>
				                        <th>审查意见</th>
				                        <th>审查时间</th>
				                        <th>审查结果</th>
				                      </tr>
				                    </thead>
				                    <tbody>
				                      <tr>
				                        <td>吴迪高</td>
				                        <td>太好了</td>
				                        <td>2018-10-14 10:10:10</td>
				                        <td>通过</td>
				                      </tr>
				                    </tbody>
				                  </table>
				                  <div style="margin-top: 20px;">
				                  	<a href="leaveList.jsp" class="btn btn-gradient-success mr-2" >修改</a>
				                  	<a href="leaveList.jsp" class="btn btn-gradient-dark mr-2" >返回</a>
				                  </div>
				                   
				               </div>
				             
				              </div>
	</body>
</html>
