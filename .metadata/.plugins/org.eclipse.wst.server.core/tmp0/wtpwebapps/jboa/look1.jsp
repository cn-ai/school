<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核报销</title>
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
</head>
<body style="height:400px;">
	<!--模拟窗口 审核-->
	<form action="jboa/remburse/addsp">
	  <div class=" inmodal" id="myModal2" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog" style="width:1000px;">
                <div class="modal-content animated flipInY">
                    <div class="modal-header">
                        
                        <h4 class="modal-title">查看报销单</h4>
                        <small class="font-bold">报销时间:<span>${reimburse.createtime }</span>
                    </div>
                    <div class="modal-body">
                      	<div class="pages">
				<!--增加报销单 区域 开始-->
				<table width="100%" border="1" cellspacing="0" cellpadding="0" class="addform-base">
					<caption style="color: red;">基本信息</caption>
					<tbody>
						<tr class="cn_tr">
							<td>编&nbsp;&nbsp;号：</td><td class="cn_td">${reimburse.employeeid }</td>
							
							<td>填&nbsp;写&nbsp;人：</td><td class="cn_td"><input type="hidden" name="checkman"> ${reimburse.employeename }</td>
							
							<td>部&nbsp;&nbsp;门：</td><td class="cn_td">${sessionScope.emp.department.departmentname }</td>
							
							<td>职&nbsp;&nbsp;位：</td><td class="cn_td">${sessionScope.emp.position.positionname }</td>
							
						</tr>
						<tr class="cn_tr">
						
							<td style="width: 60px;">总金额：</td><td class="cn_td">${reimburse.totalcount }</td>&nbsp;&nbsp;&nbsp;
							<td style="width: 70px;">填报时间：</td><td class="cn_td" style="width: 140px;padding: 2px;">2012-04-05 12:03:34</td>
							<td style="padding: 2px;">状态：</td><td class="cn_td">${reimburse.statusname }</td>
							<td style="width: 70px;">待处理人：</td><td class="cn_td">${reimburse.nextpreson }</td>
						</tr>
						
					</tbody>
				</table>
				<p>&nbsp;</p>
				<p><hr style="border-color: #000;"></p>
				<p style="color: red;">报销详情</p>
				<table width="100%" style=" text-align: center;"  border="0" cellspacing="0" cellpadding="0" class="addform-base">
					<thead >
						<tr style="border-bottom-width: 1px;border-color: #000000;">
							<td>用途说明</td>
							<td>消费金额</td>
							<td>票据截图</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${detaillist }" var="detail">
							<tr>
								<td>
									<span>${detail.desc }</span>
								</td>
								<td>
									<span>${detail.subtotal }</span>
								</td>
								<td><img class="img" src="/jboa/${detail.pictruename }"></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<p>&nbsp;</p>
				<p><hr style="border-color: #000;"></p>
				<p style="color: red;">审核详情</p>

				<table style="text-align: center;" width="100%" border="0" cellspacing="0" cellpadding="0" class="addform-base">
					<thead>
						
							<tr >
								<td width="15%">审查人</td>
								<td width="40%">审查意见</td>
								<td width="30%">审查时间</td>
								<td width="15%">审查结果</td>
							</tr>
						
					</thead>
					<tbody>
						<c:forEach items="${checklist }" var="check">
							<tr>
								<td>
									<span>${check.checkman }</span>
								</td>
								<td>
									<span>${check.checkcomment }</span>
								</td>
								<td>
									<span>${check.checktime }</span>
								</td>
								<td>
									<span class="weight">${check.resultname }</span>
								</td>
							</tr>
					</c:forEach>	
						
						

					</tbody>

				</table>
				
				<p>&nbsp;</p>
				<p><hr style="border-color: #000;"></p>
				<p style="color: red;">领导审核</p>
				<div style="border: 1px solid #000; width: 550px;height:80px;background: #FFFFFF;border-radius: 5%;">
					<textarea style="border: 0px;width: 548px;height:78px;" name="sh"></textarea>		
				</div>
				<p>&nbsp;</p>
				<p>
					<a class="btn btn-success btn-rounded" href="javascript:void(0)" onclick="sc(this)">通过</a>
					<a class="btn btn-warning btn-rounded" href="javascript:void(0)" onclick="sc(this)">打回</a>
					<a class="btn btn-danger btn-rounded" href="javascript:void(0)" onclick="sc(this)">拒绝</a>
					
				</p>
				<!--增加报销单 区域 结束-->
			</div>
                    </div> 
                   <div class="modal-footer" style="margin-left:894px">
                       
                      <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="fh()">返回</button>
                    </div>
                </div>
            </div>
        </div>
        </form>
</body>
<script type="text/javascript" src="/jboa/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
function fh(){
	location.href="/jboa/remburse/querylist";
}
function sc(button){

	var name=$(button).text();
	if(name=="通过"){
		location.href="/jboa/remburse/addsp?bizid=${reimburse.reimburseid}&checkman=${emp.employeeid}&checkresult=1&checkcomment"+$("[name=sh]").val();
	}else if(name=="拒绝"){
		location.href="/jboa/remburse/addsp?bizid=${reimburse.reimburseid}&checkman=${emp.employeeid}&checkresult=2&checkcomment"+$("[name=sh]").val();
	}else if(name=="打回"){
		location.href="/jboa/remburse/addsp?&bizid=${reimburse.reimburseid}&checkman=${emp.employeeid}&checkresult=3&checkcomment"+$("[name=sh]").val();
	}
	
}
</script>
</html>