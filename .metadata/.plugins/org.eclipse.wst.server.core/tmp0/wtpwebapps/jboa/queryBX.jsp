<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>查询报销单列表</title>
	 
	  <link rel="shortcut icon" href="favicon.ico"> 
	  <link href="/jboa/css/bootstrap.min.css" rel="stylesheet">
      <link href="/jboa/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Data Tables -->
    <link href="/jboa/css/dataTables.bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" href="/jboa/css/laydate.css" />
	<link rel="stylesheet" href="/jboa/css/defalut/laydate.css" />
    <link href="/jboa/css/animate.css" rel="stylesheet">
    <link href="/jboa/css/query/style.css?v=4.1.0" rel="stylesheet">
    
    <link rel="stylesheet" href="/jboa/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
	<link rel="stylesheet" href="/jboa/vendors/css/vendor.bundle.base.css">
        <!-- layerDate plugin javascript -->
     <script src="/jboa/js/jquery.min.js?v=2.1.4"></script>
    <script src="/jboa/js/laydate.js"></script>
    <script src="/jboa/js/bootstrap.min.js"></script>
     <script src="/jboa/js/content.js?v=1.0.0"></script>
	  	<style>
	.breadcrumb-item a{
		color: #007bff;
	}
	.page-title{
		display: inline-block;
		color: red;
	}
	#cn_query{
		display: inline-block;
		float: right;
	}
	.cn_tr td{
		text-align: center;
		width: 50px;
		padding:2px;
	}
	.cn_td{
		
	}
	tr td{
		padding: 4px;
	}
	.laydate-icon{border:1px solid #ccc; background:url(/jboa/images/icon.png) 140px no-repeat}
	  	</style>
	</head>
	<body>
			<div class="page-header head">
		
            <h3 class="page-title">
             
            	  费用报销单列表
            </h3>
            <nav aria-label="breadcrumb" id="cn_query">
              <ol class="breadcrumb" >
                <li class="breadcrumb-item"><a href="#">查询费用报销</a></li>
                <li class="breadcrumb-item active" aria-current="page">费用报销</li>
              </ol>
            </nav>
          </div>
          <form action="/jboa/remburse/querylist" method="post" id="myfrom">
          <div >
          		<div class="form-group">
                                        <label class="col-sm-1 control-label" style="padding: 0px;text-align: center;margin-top:8px ;">订单状态:</label>
                                        <div class="col-sm-2" style="padding: 0px;">
                                            <select class="form-control m-b" name="account">
                                            	<option value="-1">不限</option>
                                            <c:forEach items="${list }" var="l">
                                            	<option value="${l.statusid }" ${l.statusid==account?"selected":"" }>${l.statusname }</option>
                                            </c:forEach>
											</select>
                                        </div>
                         <!--
                         	作者：offline
                         	时间：2018-11-28
                         	描述：开始时间
                         -->
                       <div class="form-group">
                                        <label class="col-sm-1 control-label" style="padding: 0px;text-align: center;margin-top:8px ;margin-left: 10px;">开始时间:</label>
                                        <div class="col-sm-2" style="padding: 0px;">
                                         <!--   <input id="hello"  placeholder="开始时间" class=" laydate-icon form-control layer-date ">-->
                                       <input placeholder="开始日期" class="laydate-icon form-control layer-date" id="start" name="starttime" value="${starttime }">	
                                        </div>
                        </div>
                        <div class="form-group">
                                        <label class="col-sm-1 control-label" style="padding: 0px;text-align: center;margin-top:8px ;margin-left: 10px;">结束时间:</label>
                                        <div class="col-sm-2" style="padding: 0px;">
                                           <!-- <input id="end" placeholder="结束时间" class="laydate-icon form-control layer-date">                               -->
                                            <input placeholder="结束日期" class="laydate-icon form-control layer-date" id="end" name="endtime" value="${endtime }">	
                                        </div>
                        </div>
                        </div>
                        <a href="javascript:void(0);" class="btn btn-primary cx" style="margin-left: 10px;" >查询</a>   
                    
             </div>
             </form>
        <div class="ibox-content">
                        <table class="table table-striped table-bordered table-hover dataTables-example dataTable" id="DataTables_Table_0">
                            <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>填报日期</th>
                                    <th>填报人</th>
                                    <th>总金额</th>
                                    <th>状态</th>
                                    
                                        <th>操作</th>
                                </tr>
                            </thead>
                            <tbody id="content">
                            
                            <c:forEach items="${pageinfo.list }" var="list">
                            	 <tr class="">
                                    <td class=" ">${list.reimburseid }</td>
                                    <td class=" ">${list.createtime }
                                    </td>
                                    <td class=" ">${list.employeename }</td>
                                    <td class="center ">${list.totalcount }</td>
                                    <td class="center ">${list.statusname }</td>
                                
                                    
                                    
                                    <td class="center "><a href="/jboa/remburse/detail?reimburseid=${list.reimburseid }&typeid=${list.typeid}">查看</a>
                                    	<c:if test="${emp.employeeid!=list.employeeid and list.statusid==2}">
                                    <a  href="/jboa/remburse/sh?reimburseid=${list.reimburseid }&typeid=${list.typeid}">审核</a>
                                    	</c:if>
                                    	<c:if test="${list.statusid==1 }">
                                    		 <a  href="">提交</a>
                                    		  <a  href="">编辑</a>
                                    		  <a  href="">删除</a>
                                    	</c:if>
                                    	<c:if test="${list.statusid==6 }">
                                    		<a  href="">编辑</a>
                                    	</c:if>
                                    </td>
                                    	
                                    	
                                </tr>
                            </c:forEach>
                                
                            </tbody>
                            
                        </table>

                    </div>
                   <div class="row"><div class="col-sm-6"><div class="dataTables_info" id="DataTables_Table_0_info" role="alert" aria-live="polite" aria-relevant="all">显示 1 到 10 项，共 ${pageinfo.total } 项</div></div><div class="col-sm-6"><div class="dataTables_paginate paging_simple_numbers" id="DataTables_Table_0_paginate"><ul class="pagination"><li class="paginate_button previous" aria-controls="DataTables_Table_0" tabindex="0" id="DataTables_Table_0_previous"><a href="javascript:void(0);" onclick="PageShow(0);">上一页</a></li><li class="paginate_button " aria-controls="DataTables_Table_0" tabindex="0"><a href="javascript:void(0)"onclick="PageShow(1);">1</a></li><li class="paginate_button " aria-controls="DataTables_Table_0" tabindex="0"><a href="javascript:void(0)" onclick="PageShow(2);">2</a></li><li class="paginate_button " aria-controls="DataTables_Table_0" tabindex="0"><a href="javascript:void(0);" onclick="PageShow(3);">3</a></li><li class="paginate_button " aria-controls="DataTables_Table_0" tabindex="0"><a href="javascript:void(0);" onclick="PageShow(4);">4</a></li><li class="paginate_button " aria-controls="DataTables_Table_0" tabindex="0"><a href="javascript:void(0);" onclick="PageShow(5);">5</a></li><li class="paginate_button " aria-controls="DataTables_Table_0" tabindex="0"><a href="javascript:void(0);" onclick="PageShow(6);">6</a></li><li class="paginate_button next" aria-controls="DataTables_Table_0" tabindex="0" id="DataTables_Table_0_next"><a href="javascript:void(0);" onclick="PageShow(7);">下一页</a></li></ul></div></div></div>
	
	
	</body>
	<script type="text/javascript" src="/jboa/js/jquery-1.12.4.js"></script>
	<script>
        //日期范围限制
        var start = {
            elem: '#start',
            format: 'YYYY/MM/DD hh:mm:ss',   
            max: '2099-06-16 23:59:59', //最大日期
            istime: true,
            istoday: false,
            festival:true,//显示节日
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };
        var end = {
            elem: '#end',
            format: 'YYYY/MM/DD hh:mm:ss', 
            max: '2099-06-16 23:59:59',
            istime: true,
            istoday: false,//显示今天
            festival:true,//显示节日
            choose: function (datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        laydate(start);
        laydate(end);
        
        $("#content tr:even").addClass("gradeX");
        $("#content tr:odd").addClass("gradeC");
        
	function PageShow(num){
		switch (num) {
		case 0:
			if(${pageinfo.hasPreviousPage}){
				location.href="/jboa/remburse/querylist?num=${pageinfo.prePage}&account=${account}&starttime=${starttime}&endtime=${endtime}";
				$(".pagination>.disabled>a").css("cursor","pointer");
			}else{
				alert("没有上一页");
				$(".pagination>.disabled>a").css("cursor","not-allowed");
			} 
				break;
		case 1:
	
		location.href="/jboa/remburse/querylist?num=1&account=${account}&starttime=${starttime}&endtime=${endtime}";
		break;
		case 2:
		location.href="/jboa/remburse/querylist?num=2&account=${account}&starttime=${starttime}&endtime=${endtime}";
		break;
		case 3:
		location.href="/jboa/remburse/querylist?num=3&account=${account}&starttime=${starttime}&endtime=${endtime}";
		break;
		case 4:
		location.href="/jboa/remburse/querylist?num=4&account=${account}&starttime=${starttime}&endtime=${endtime}";
		break;
		case 5:
		location.href="/jboa/remburse/querylist?num=5&account=${account}&starttime=${starttime}&endtime=${endtime}";
		break;
		case 6:
		location.href="/jboa/remburse/querylist?num=6&account=${account}&starttime=${starttime}&endtime=${endtime}";
		break;
		case 7:
			if(${pageinfo.hasNextPage}){
		location.href="/jboa/remburse/querylist?num=${pageinfo.nextPage}&account=${account}&starttime=${starttime}&endtime=${endtime}";
			}else{
				alert("没有下一页");
			}
		break;
		
		default:
			break;
		}
		
	}
   </script>
   <script type="text/javascript">
   $(".cx").click(function(){
	   $("#myfrom").submit();
   })
    
  
   
 
   </script>
</html>
