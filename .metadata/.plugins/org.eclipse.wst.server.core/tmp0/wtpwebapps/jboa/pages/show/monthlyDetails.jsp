<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>清泉办公管理系统</title>
  <!-- plugins:css -->
		<link rel="stylesheet" href="../../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
		<link rel="stylesheet" href="../../vendors/css/vendor.bundle.base.css">
		<!-- endinject -->
		<!-- inject:css -->
		<link rel="stylesheet" href="../../css/style.css">
		<!-- endinject -->
		<link rel="shortcut icon" href="../../../../images/favicon.png" />
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
                <i class="mdi mdi-file-chart"></i>                 
              </span>
              	部门详细信息
           </h3>
		</div>
		<div class="col-lg-12 grid-margin stretch-card">
 					 <div class="card">
				                <div class="card-body">
				                	<h4>年份： 2018年 月份: 11月 &nbsp;
				                	<button type="button" class="btn btn-gradient-info btn-icon-text" style="padding: 10px;">
				                		导出
				                		<i class="mdi mdi-printer btn-icon-append"></i>                                                                              
                        </button>
				                	</h4>
				                  <table class="table table-striped table-bordered" style="margin-top: 20px;">
				                    <thead>
				                      <tr>
				                        <th>编号</th>
				                        <th>总计</th>
				                        <th>消费人员</th>
				                      </tr>
				                    </thead>
				                    <tbody>
				                      <tr>
				                        <td>1</td>
				                        <td>￥16356.0</td>
				                        <td>王传军</td>
				                      </tr>
				                     
				                    </tbody>
				                    <tfoot>
				                    	 <tr>
				                        <td class="alert-warning font-weight-bold">总计</td>
				                        <td class="alert-warning font-weight-bold">￥16356.0</td>
				                        <td class="alert-warning" colspan="3"></td>
				                      </tr>
				                    </tfoot>
				                  </table>
				                    <div class="btn-group" role="group" aria-label="Basic example" style="height: 35px;margin-left: 30%;text-align: center;margin-top: 20px;">
		                          <button type="button" class="btn btn-info" style="padding: 5px 10px;">首页</button>
		                          <button type="button" class="btn btn-info" style="padding: 5px 10px;">上一页</button>
		                          <blockquote class="blockquote" style="margin: 0px;height: 37px;padding: 0px 20px;font-size: 14px;">
		                          		 第 1 / 9 页
		                          		<br />   
		                          		55 条记录
								 							</blockquote>
		                          <button type="button" class="btn btn-info" style="padding: 5px 10px;">下一页</button>
		                          <button type="button" class="btn btn-info" style="padding: 5px 10px;">尾页</button>
		                        </div>
				                </div>
				                
                				<h4 style="text-align: center;">
				                   		<a href=""><button type="button" class="btn btn-gradient-primary mr-2">查看柱状图</button></a>
					                    <a href=""><button type="button" class="btn btn-gradient-info mr-2">查看饼状图</button></a>
					                    <a href=""><button type="button" class="btn btn-gradient-dark mr-2">查看曲线图</button></a>
				                </h4>
				              </div>
				             </div>
				              <div class="col-lg-12 grid-margin stretch-card">
										  <div class="card">
  												<div class="card-body" >
  													<div id="Chartjs">
										 	
														 </div>
				             			</div>
				             </div>
				          </div>
				                <!-- plugins:js -->
					  <script src="../../js/ichart.1.2.1.min.js"></script>
					  <!-- endinject -->
					  <script type="text/javascript">
							$(function(){
							var flow=[];
							for(var i=0;i<4;i++){
								flow.push(Math.floor(Math.random()*(60000+((i%12)*5)))+10);
							}
							var data1 = [
							         	{
							         		name : '报销金额',
							         		value:flow,
							         		color:'#0d8ecf',
							         		line_width:2
							         	}
							         ];
					         
							var labels = ["丁磊","雷军","刘某","卢老爷"];
							
							var line = new iChart.LineBasic2D({
								render : 'Chartjs',//ID
								data: data1,
								align:'center',
								title : '曲线图',
								animation:true,
								animation_duration:1000,
								subtitle : '本部门报销统计',
								footnote : '数据来源：财务部',
								width : 800,
								height : 400,
								sub_option:{
									smooth : true,//平滑曲线
									point_size:10
								},
								tip:{
									enable:true,
									shadow:true
								},
								legend : {
									enable : false
								},
								crosshair:{
									enable:true,
									line_color:'#62bce9'
								},
								coordinate:{
									width:600,
									valid_width:500,
									height:260,
									axis:{
										color:'#9f9f9f',
										width:[0,0,2,2]
									},
									grids:{
										vertical:{
											way:'share_alike',
									 		value:12
										}
									},
									scale:[{
										 position:'left',	
										 start_scale:0,
										 end_scale:100000,
										 scale_space:10000,
										 scale_size:2,
										 scale_color:'#9f9f9f'
									},{
										 position:'bottom',	
										 labels:labels
									}]
								}
							});
						//开始画图
						line.draw();
					});
					</script>
</body>

</html>
