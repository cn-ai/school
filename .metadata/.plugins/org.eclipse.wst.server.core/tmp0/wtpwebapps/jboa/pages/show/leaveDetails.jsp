<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="d" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>请假详情</title>
		<!-- plugins:css -->
		<link rel="stylesheet" href="/jboa/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
		<link rel="stylesheet" href="/jboa/vendors/css/vendor.bundle.base.css">
		<!-- endinject -->
		<!-- inject:css -->
		<link rel="stylesheet" href="/jboa/css/style.css">
		<!-- endinject -->
		<link rel="shortcut icon" href="/jboa/images/favicon.png" />
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
              	请假详情
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
					<td>${Page.createManName}</td>
					<td class="font-weight-bold">部门：</td>
					<td>${Page.departmentName}</td>
				</tr>
				<tr>
					<td class="font-weight-bold">
						开始时间 
					</td>
					<td><d:formatDate value="${Page.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td class="font-weight-bold">结束时间</td>
					<td><d:formatDate value="${Page.endtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td class="font-weight-bold">请假日期</td>
					<td colspan="3" style="text-align: center;"><span id="day">${Page.totalcount}</span> 天</td>
				</tr>
				<tr>
					<td class="font-weight-bold">请假事由 </td>
					<td colspan="3" style="text-align: center;">
                      ${Page.event}
					</td>
				</tr>
				<tr>
					<td class="font-weight-bold">审批状态 </td>
					<td colspan="3" style="text-align: center;">
                      	${Page.statusName}
					</td>
				</tr>
			</tbody>
		</table>
		 <table class="table table-striped" style="margin-top: 20px;">
				                    <thead>
				                      <tr>
				                        <th>审查人</th>
				                        <th>审查意见</th>
				                        <th>审查时间</th>
				                        <th>审查结果</th>
				                      </tr>
				                    </thead>
				                    <tbody>
				                     <c:forEach items="${Page.check}" var="temp">
					                    <tr>
					                        <td>${temp.checkManName}</td>
					                        <td>${temp.checkcomment}</td>
					                        <td><d:formatDate value="${temp.checktime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					                      	<c:if test="${temp.checkresult==1}">
	                        				<td class="text-success">通过</td>
		                        			</c:if>
		                        			<c:if test="${temp.checkresult==2}">
		                        				<td class="text-danger">拒绝</td>
		                        			</c:if>
		                        			<c:if test="${temp.checkresult==3}">
		                        				<td class="text-danger">打回</td>
		                        			</c:if>					                     
		                        			
					                     </tr>
				                    </c:forEach>
				                    <c:if test="${Page.check.size()==0}">
				                    	 <tr style="text-align: center;">
					                        <td colspan="4">暂无新的审批结果</td>
					                     </tr>
				                    </c:if>
				                    </tbody>
				                  </table>
				                  <div style="margin-top: 20px;">
				                  	
				                  	 <a href="/jboa/leave/queryLeave?pageNum=1&positionid=${emp.position.positionid}&departmentid=${emp.department.departmentid}&employeeid=${emp.employeeid}" class="btn btn-gradient-dark mr-2" >返回</a>
				                  </div>
				                   
				               </div>
				             
				              </div>
	</body>
</html>
