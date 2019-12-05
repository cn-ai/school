<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="d" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>查看请假</title>
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
              	请假查看
           </h3>
		</div>
		<div class="card">
		<div class="card-body">
				                	<div class="form-inline">
				                		<h5>起始时间:</h5>&nbsp;&nbsp;&nbsp;&nbsp;
				                    <input name="startTime" id="starttime" value="<d:formatDate value="${startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" class="form-control mb-2 mr-sm-2" style="font-size: 16px;padding: 5px;" id="beginTime" placeholder="开始时间">
				                  	<h5>至</h5>  &nbsp;&nbsp;
				                    <div class="input-group mb-2 mr-sm-2">
				                      <input  class="form-control" name="endtime" id="endtime" value="<d:formatDate value="${endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"  style="font-size: 16px;padding: 5px;" id="endTime" placeholder="结束时间">
				                    </div>
				                    <button onclick="queryPage(this)" class="btn btn-gradient-primary mb-2" style="padding: 7px;height: 30px;"><i class="mdi mdi-yeast"></i> 查询 </button>
				                  </div>
				                  <table class="table table-hover">
				                    <thead>
				                      <tr>
				                        <th>编号</th>
				                        <th>名称</th>
				                        <th>发起时间</th>
				                        <th>审批时间</th>
				                        <th>审批意见</th>
				                        <th>审批状态</th>
				                        <th>待处理人</th>
				                        <th>操作</th>
				                      </tr>
				                    </thead>
				                      <tbody>
         	<c:forEach items="${pageinfo.list}" var="temp">
           		<tr>
                       <td>${temp.leaveid}</td>
                       <td>${temp.createManName}请假${temp.totalcount}天</td>
                       <td><d:formatDate value="${temp.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                       <c:forEach items="${temp.check}" var="check" varStatus="stat">
                           <c:if test="${stat.last}" >
                       
	                        <td><d:formatDate value="${check.checktime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	                        <td>
	                        	
	                        		<c:if test="${check.checkresult==1}">
	                        		<span class="text-success">通过</span>
		                        	</c:if>
		                        	<c:if test="${check.checkresult==2}">
		                        		<span class="text-danger">拒绝</span>
		                        	</c:if>
		                        	<c:if test="${check.checkresult==3}">
		                        		<span class="text-danger">打回</span>
		                        	</c:if>
	                        </td>
	                       </c:if>
                       </c:forEach>
                       <c:if test="${temp.check.size()==0}">
                       	<th></th>
               			<th></th>
                       </c:if>
                       
                       <td>${temp.statusName}</td>
                       <c:if test="${temp.nextdealman ==emp.employeeid }">
                       <td>${emp.employeename}</td>
                       </c:if>
                       <td>
                       <td>
                       	<c:if test="${emp.employeename==temp.createManName || emp.department.departmentid == temp.departmentid && emp.position.positionid == 1 || emp.position.positionid == 0 || emp.position.positionid == 4}">
                       		<a href="/jboa/leave/queryLeavedetail?pageNum=1&leaveid=${temp.leaveid}&type=普通" title="查看"><i class="mdi mdi-yeast"></i></a>
                       	</c:if>
                       	<!-- <a href="leaveAlter.jsp" title="修改"><i class="mdi mdi-wrench"></i></a> -->
                       	<c:if test="${temp.createman != emp.employeeid && temp.nextdealman ==emp.employeeid &&temp.statusid != 4}">
                       		<a href="/jboa/leave/queryLeavedetail?pageNum=1&leaveid=${temp.leaveid}&type=审批" title="审批"><i class="mdi mdi-comment-check"></i></a>
                       	</c:if>
                       	<c:if test="${temp.statusid == 4 && emp.position.positionid == 4 }">
                       		<a href="/jboa/leave/queryLeavedetail?pageNum=1&leaveid=${temp.leaveid}&type=审批" title="存档"><i class="mdi mdi-comment-check"></i></a>
                       	</c:if>
                       	<!-- <a href="" title="提交"><i class="mdi mdi-apple-keyboard-caps"></i></a> -->
                       	<!-- <a href="" title="删除"><i class="mdi mdi-delete-forever"></i></a> -->
                       </td>
                 	</tr>
           	</c:forEach>
           	<c:if test="${pageinfo.list.size()==0}">
           		<td colspan="7" style="text-align: center;"><h4>暂无数据</h4></td>
           	</c:if>
          </tbody>
				                  </table>
				                  <br>
				                 <div class="btn-group" role="group" aria-label="Basic example" style="height: 35px;margin-left: 30%;text-align: center;margin-top: 20px;">
		                          <button type="button" class="btn btn-info" style="padding: 5px 10px;" onclick="queryPage(this)"  <c:if test="${pageinfo.isLastPage==false}">disabled="disabled"</c:if>>首页</button>
		                         
		                          <button type="button" class="btn btn-info" style="padding: 5px 10px;" onclick="queryPage(this)"   <c:if test="${pageinfo.hasPreviousPage==false}">disabled="disabled"</c:if>>上一页</button>
		                          <blockquote class="blockquote" style="margin: 0px;height: 37px;padding: 0px 20px;font-size: 14px;">
		                          		 第 <c:if test="${pageinfo.total==0}">0</c:if><c:if test="${pageinfo.total!=0}">${pageinfo.pageNum}</c:if> /  ${pageinfo.pages} 页
		                          		<br />   
		                          		${pageinfo.total} 条记录
								 							</blockquote>
		                          <button type="button" class="btn btn-info" style="padding: 5px 10px;" onclick="queryPage(this)" <c:if test="${pageinfo.hasNextPage==false}">disabled="disabled"</c:if>>下一页</button>
		                          <button type="button" class="btn btn-info" style="padding: 5px 10px;" onclick="queryPage(this)" <c:if test="${pageinfo.isFirstPage==false}">disabled="disabled"</c:if>>尾页</button>
		                        </div>
				                  </div>
				                  <script type="text/javascript" src="/jboa/js/jquery-1.12.4.js"></script>
			<script src="/jboa/js/laydate/laydate.js"></script>
			<script type="text/javascript">
		        var start = laydate.render({
		        	  elem: '#starttime',
		        	  trigger: 'click',
		        	  type:"datetime",
		        	  format:"yyyy-MM-dd HH:mm:ss",
		        	  theme: 'molv',
		        	  calendar: true,
		        	  done:function(value,dates){
		        		  end.config.min ={
		                          year:dates.year, 
		                          month:dates.month-1,
		                          date: dates.date+1, 
		                          hours: 0, 
		                          minutes: 0, 
		                          seconds : 0
		                 };
		        	  }
		        	});
		        var end = laydate.render({
		      	  elem: '#endtime',
		      	  min:1,
		      	  trigger: 'click',
		      	  type:"datetime",
		      	  theme: 'molv',
		      	  format:"yyyy-MM-dd HH:mm:ss",
		      	  calendar: true
		      	  })
		      	  function queryPage(one){
		        	switch ($(one).text()) {
						case "首页":
							window.location = "/jboa/leave/queryLeave?pageNum=1&positionid=${emp.position.positionid}&departmentid=${emp.department.departmentid}&employeeid=${emp.employeeid}&starttime="+$("#starttime").val()+"&endtime="+$("#endtime").val()+"";
							break;
						case "上一页":
							window.location = "/jboa/leave/queryLeave?pageNum=${pageinfo.prePage}&positionid=${emp.position.positionid}&departmentid=${emp.department.departmentid}&employeeid=${emp.employeeid}&starttime="+$("#starttime").val()+"&endtime="+$("#endtime").val()+"";
							break;
						case "下一页":
							window.location = "/jboa/leave/queryLeave?pageNum=${pageinfo.nextPage}&positionid=${emp.position.positionid}&departmentid=${emp.department.departmentid}&employeeid=${emp.employeeid}&starttime="+$("#starttime").val()+"&endtime="+$("#endtime").val()+"";
								break;
						case "尾页":
							window.location = "/jboa/leave/queryLeave?pageNum=${pageinfo.lastPage}&positionid=${emp.position.positionid}&departmentid=${emp.department.departmentid}&employeeid=${emp.employeeid}&starttime="+$("#starttime").val()+"&endtime="+$("#endtime").val()+"";
							break;
						case " 查询 ":
							window.location = "/jboa/leave/queryLeave?pageNum=1&positionid=${emp.position.positionid}&departmentid=${emp.department.departmentid}&employeeid=${emp.employeeid}&starttime="+$("#starttime").val()+"&endtime="+$("#endtime").val()+"";
							break;
					}
		        	
		          }
			</script>
	</body>
</html>
