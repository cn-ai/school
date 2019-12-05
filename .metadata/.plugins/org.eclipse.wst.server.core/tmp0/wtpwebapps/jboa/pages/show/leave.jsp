<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="UTF-8">
		<title>申请假期</title>
		<!-- plugins:css -->
		<link rel="stylesheet" href="../../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
		<link rel="stylesheet" href="../../vendors/css/vendor.bundle.base.css">
		<!-- endinject -->
		<!-- inject:css -->
		<link rel="stylesheet" href="../../css/style.css">
		<!-- endinject -->
		<link rel="shortcut icon" href="../../../../images/favicon.png" />
		<link rel="stylesheet" href="/jboa/css/laydate.css" />
		<link rel="stylesheet" href="/jboa/css/defalut/laydate.css" />
		<script src="/jboa/js/laydate.js"></script>
		<style type="text/css">
			tr td{
				padding: 5px;
			}body{
				padding: 10px;width: 1000px;
				background: #f2edf3;
			}
			.laydate-icon{border:1px solid #ccc; background:url(/jboa/images/icon.png) 250px no-repeat;}
		</style>
	</head>
	<body style="padding: 10px;width: 1000px;" >
		
		<div class="page-header border-bottom" style="padding-bottom: 5px;">
			<h3 class="page-title">
              <span class="page-title-icon bg-gradient-primary text-white mr-2">
                <i class="mdi mdi-run"></i>                 
              </span>
              	请假申请
           </h3>
		</div>
		<div class="card">
			<div class="card-body">
		<form action="/jboa/leave/addleave" method="post">
		<table class="table" width="100%" style="text-align:center;border-color:#b66dff ;">
			<thead>
				<tr>
					<td colspan="4"><h3 class="font-weight-bold">请假详情</h3></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td  class="font-weight-bold">
						姓名
					</td>
					<td>${emp.employeename }
					<input type="hidden" name="createman" value="${emp.employeeid }">
					</td>
					
					<td  class="font-weight-bold">部门</td>
					<td>${emp.department.departmentname }
					<input type="hidden" name="departmentid" value="${emp.department.departmentid }">
					</td>
				</tr>
				<tr>
					<td  class="font-weight-bold">
						开始时间 <span style="color: red;">*</span>
					</td>
					<td><input name="starttime" placeholder="开始时间" class="laydate-icon form-control" style="text-align: center;font-size: 16px;height: 40px;padding: 5px;" id="start"></td>
					<td class="font-weight-bold">结束时间 <span style="color: red;">*</span></td>
					<td><input name="endtime" placeholder=" 结束时间" class="laydate-icon form-control" style="text-align: center;font-size: 16px;height: 40px;padding: 5px;" id="end">
						<input type="hidden" name="nextdealman" value="${emp.pid }">
					</td>
					
				</tr>
				
				<tr>
					<td  class="font-weight-bold">请假日期</td>
					<td colspan="3" style="text-align: center;"><input type="hidden" name="totalcount"> <span id="day"></span>天</td>
				</tr>
				<tr>
					<td  class="font-weight-bold">请假事由 <span style="color: red;">*</span></td>
					<td colspan="3" style="text-align: center;">
                      <textarea class="form-control" id="exampleTextarea1" rows="4" name="event"></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<button type="submit" class="btn btn-gradient-primary mr-2">提交</button>
						<button class="btn btn-light">返回</button>
					</td>
				</tr>
			</tfoot>
			
		</table>
		</form>	
	</div>
	</div>
	</body>
	<script type="text/javascript" src="/jboa/js/jquery-1.12.4.js"></script>
		<script src="/jboa/js/laydate/laydate.js"></script>
	<script>
        //日期范围限制
          var start = laydate.render({
        	  elem: '#start',
        	  min:0,
        	  trigger: 'click',
        	  type:"datetime",
        	  format:"yyyy-MM-dd HH:mm:ss",
        	  theme: 'molv',
        	  calendar: true,
        	  value:new Date(),
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
      	  elem: '#end',
      	  min:1,
      	  trigger: 'click',
      	  type:"datetime",
      	theme: 'molv',
      	btns: ['clear', 'confirm'],
      	  format:"yyyy-MM-dd HH:mm:ss",
      	  calendar: true,
      	  done: function(value, date, endDate){
      		   var startTime=$("#start").val();
      	    	var endTime=value;
      	        if(startTime!=""){
      	       	 var time1 = Date.parse(new Date(startTime));
      				 var time2 = Date.parse(new Date(endTime));
      				 var count = Math.abs(parseInt((time2 - time1)/1000/3600/24));
      		   					  count++;
      					  $("#day").text(count);
      					  $("[name=totalcount]").val(count);
      					  }
      	        
     			 
            }
       
    	});
        
     
        
   </script>
   	
			
</html>
