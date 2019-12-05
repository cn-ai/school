<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="d" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> -消息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="/jboa/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="/jboa/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="/jboa/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="/jboa/css/animate.css" rel="stylesheet">
    <link href="/jboa/css/query/style.css" rel="stylesheet">
	
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row">
        	<div class="col-sm-12 animated fadeInRight">
                <div class="mail-box-header" >
                    <h2>
                    	消息箱 (${pageinfo.total})
                	</h2>
                    <div class="mail-tools tooltip-demo m-t-md" style="padding-bottom: 18px;" >
                        <div class="btn-group pull-right">
                        	<c:if test="${pageinfo.hasPreviousPage!=false}">
                        		<button class="btn btn-white btn-sm"><i class="fa fa-arrow-left"></i></button>
                        	</c:if>
                            <c:if test="${pageinfo.hasNextPage!=false}">
                            	<button class="btn btn-white btn-sm"><i class="fa fa-arrow-right"></i></button>
                            </c:if>

                        </div>

                    </div>
                </div>
                <div class="mail-box" >

                    <table class="table table-hover table-mail">
                        <tbody>
                           	<c:forEach items="${pageinfo.list}" var="temp">
	                           	<tr class="read">
	                           		
	                                <td class="check-mail">
	                                   
	                                </td>
	                                <td class="mail-ontact">
		                                <button onclick="Sw('<c:if test="${temp.type_id==1}">请假</c:if><c:if test="${temp.type_id==2}">报销</c:if>','${temp.message_sta}','${temp.biz_id}')" style="border: 0px;background: white;">
		                                	<c:if test="${temp.message_sta==2||temp.message_sta==3}">向</c:if><span class="text-warning">${temp.addresserName}</span><c:if test="${temp.type_id==1}">申请请假</c:if><c:if test="${temp.type_id==2}">申请报销</c:if>
		                                	<c:if test="${temp.message_sta==2||temp.message_sta==3}"><span style="color:red">已审批</span></c:if>
		                                </button>
		                               <c:if test="${temp.message_sta==0}">
		                                	<span class="label label-warning pull-right">待处理</span>
		                                </c:if>
		                                <c:if test="${temp.message_sta==2}">
		                                	<span class="label label-warning pull-right">待阅读</span>
		                                </c:if>
	                                </td>
	                                <td class="mail-subject">
	                                	 <button onclick="Sw('<c:if test="${temp.type_id==1}">请假</c:if><c:if test="${temp.type_id==2}">报销</c:if>','${temp.message_sta}','${temp.biz_id}')" style="border: 0px;background: white;">
		                                 	<c:if test="${temp.type_id==1}">
		                                 		<c:if test="${temp.message_sta==0||temp.message_sta==1}">申请请假${temp.context}天</c:if>			
		                                 		<c:if test="${temp.message_sta==2||temp.message_sta==3}">${temp.context}</c:if>	
											</c:if>
		                                 	<c:if test="${temp.type_id==2}">申请报销${temp.context}元</c:if>
		                                   </button>
	                                </td>
	                                <td class=""></td>
	                                <td class="text-right mail-date">时间：<d:formatDate value="${temp.createDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                            </tr>
                           	</c:forEach>
                           	<c:if test="${pageinfo.list.size()==0}">
                           		<tr class="read">
	                                <td colspan="5" style="text-align: center;"><h3>暂无消息</h3></td>
	                            </tr>
                           	</c:if>
                        </tbody>
                    </table>


                </div>
         	</div>
        </div>
    </div>


    <!-- 全局js -->
    <script src="/jboa/js/jquery.min.js?v=2.1.4"></script>
    <script src="/jboa/js/bootstrap.min.js?v=3.3.6"></script>



    <!-- 自定义js -->
    <script src="/jboa/js/content.js?v=1.0.0"></script>


    <!-- iCheck -->
    <script src="/jboa/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
        function Sw(site,code,bId){
        	if(site=="请假"){
        		if(code==2){
        			$.post("/jboa/leave/updateMessageajax",{"bizId":bId,"addressees_id":${emp.employeeid}},function(ret){});
        		}
        		setTimeout(function(){
        			window.location="/jboa/leave/queryLeave?pageNum=1&positionid=${emp.position.positionid}&departmentid=${emp.department.departmentid}&employeeid=${emp.employeeid}";
            	},500);
        		}else if(site=="报销"){
        		
        	}
        }
    </script>

    
    

</body>

</html>

