<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.UUID"%>
    <%
    UUID uuid = UUID.randomUUID();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>报销单列表</title>
		  <!-- plugins:css -->
  
  	<link rel="stylesheet" href="/jboa/css/commComm.min.css">
  	<link rel="stylesheet" href="/jboa/css/trace.min.css">
    <link href="/jboa/css/font-awesome.css?v=4.4.0" rel="stylesheet">
	
  <!-- endinject -->
  <!-- inject:css -->
  <link rel="stylesheet" href="/jboa/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="" />
  <link rel="stylesheet" href="/jboa/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
		<link rel="stylesheet" href="/jboa/vendors/css/vendor.bundle.base.css">
  <style>
  	.page-title{
  		color: red;
  	}
  	
  </style>
	</head>
	<body>
		<div class="page-header head">
	            <h3 class="page-title">
	             <span class="page-title-icon bg-gradient-primary text-white mr-2">
            	<i class="mdi mdi-food"></i>             
              </span>          	          
              费用报销单
            </h3>
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">新增费用报销</a></li>
                <li class="breadcrumb-item active" aria-current="page">费用报销</li>
              </ol>
            </nav>
          </div>
       <!--内容-->
       <div>
       	<div style="margin-left:30px ;">
       		<button class="btn btn-primary btn-default" type="button" name="tj"><i class="fa fa-check"></i>&nbsp;提交</button>
       		<button class="btn btn-warning btn-default" type="button" name="bc"><i class="fa fa-save"></i>&nbsp;&nbsp;<span class="bold">保存</span>  </button>
       		<button class="btn btn-danger btn-default" type="button"><i class="fa fa-backward"></i>&nbsp;&nbsp;<span class="bold">返回</span>  </button>
       		
       	</div>
       		<div>
       			<table>
                                    <!--查看正文-->
                                    <!-- ngIf: normalCondition() && (formModel.showWordHtmlContent || formModel.showPDFFlg || formModel.xlsFileFlg) -->
                                    <div class="htmlPadding" id="htmlPadding">
                                        <form id="templateContent" name="templateContent" class="text-left ng-pristine ng-valid">
                                            <div random-code="6B3A6735DB" id="6B3A6735DB">
                                                <div data-ng-init="loadPageToInitScroll()" id="contentTrace" ng-bind-html="formModel.contentMemo|to_trusted" class="ng-binding"><center>
<table width="720" height="" align="center" bordercolor="#000000" style="border-collapse: separate;" bgcolor="#ffffff" border="0" cellspacing="0" cellpadding="1">
<tbody>
<tr>
<td height="50" align="center" style="border-color: rgb(0, 0, 0);" bgcolor="" colspan="4">
<span style="font-size: 23pt;">
<font color="#000000">
费用报销单
</font>
</span>
</td>
</tr>

<tr>
<td width="60" height="35" style="border-color: rgb(0, 0, 0);" bgcolor="">流水号：</td>
<td height="20" style="border-color: rgb(0, 0, 0);">
<input name="流水号" title="流水号" class="InputStyle_Edit" id="MAFO_3" datafld="SYS_SEL_AUTONUM" value="流水号{自动流水号}" manydictnum="0" tempforautonum="" fieldtype="2" fieldlength="255" defaultshowvalue="" fieldtitle="lsh" relation="" sql="0" type="hidden" oldvalue=""><span id="MAFO_3_6B3A6735DB" elname="流水号" datafld="SYS_SEL_AUTONUM" style="" fieldid="TraceD0018866EPJ" randomcode="6B3A6735DB" template="829c365f5c134c6eb8bbd0f3">BMYS_20181127011</span>
</td>
<td width="80" height="20" align="center" style="border-color: rgb(0, 0, 0);" bgcolor="">申请日期</td>
<td width="150" height="20" align="center" style="border-color: rgb(0, 0, 0);" bgcolor="">
<input name="申请日期" title="申请日期" class="InputStyle_Edit" id="MAFO_4" datafld="SYS_SEL_DATE" value="申请日期{日期选择}" manydictnum="" tempforautonum="" fieldtype="3" fieldlength="255" defaultshowvalue="" fieldtitle="sqrq" relation="" sql="" showstyle="yyyy-MM-dd" type="hidden" oldvalue=""><span id="MAFO_4_6B3A6735DB" elname="申请日期" datafld="SYS_SEL_DATE" style="" fieldid="TraceD001895UF48" randomcode="6B3A6735DB">2018-11-27</span>
</td>
</tr>
</tbody>
</table>
</center>

<center>
<table width="720" height="" align="center" bordercolor="#000000" style="border-style: solid; border-collapse: collapse;" bgcolor="#ffffff" border="1" cellspacing="0" cellpadding="1">
<tbody>
<tr>
<td width="100" height="35" align="center" style="border-style: solid; border-color: rgb(0, 0, 0);" bgcolor="">申请部门</td>
<td width="150" height="20" align="center" style="border-style: solid; border-color: rgb(0, 0, 0);" bgcolor="">
<input name="申请部门" title="申请部门" class="InputStyle_Edit" id="MAFO_1" datafld="SYS_SEL_CREATERDEPT" value="${emp.department.departmentid }" manydictnum="" tempforautonum="" fieldtype="2" fieldlength="255" defaultshowvalue="" fieldtitle="sqbm" relation="" sql="" type="hidden" oldvalue=""><span id="MAFO_1_6B3A6735DB" elname="申请部门" datafld="SYS_SEL_CREATERDEPT" style="" fieldid="TraceD001893V5O6" randomcode="6B3A6735DB" memo="ROOT">${emp.department.departmentname }</span>
</td>
<td width="100" height="20" align="center" style="border-style: solid; border-color: rgb(0, 0, 0);" bgcolor="">申请人</td>
<td width="120" height="20" align="center" style="border-style: solid; border-color: rgb(0, 0, 0);" bgcolor="">
<input name="申请人" title="申请人" class="InputStyle_Edit" id="MAFO_2" datafld="SYS_SEL_CREATERNAME" value="${emp.employeeid }" manydictnum="" tempforautonum="" fieldtype="2" fieldlength="255" defaultshowvalue="" fieldtitle="sqr" relation="" sql="" type="hidden" oldvalue=""><span id="MAFO_2_6B3A6735DB" elname="申请人" datafld="SYS_SEL_CREATERNAME" style="" fieldid="TraceD001891NU6B" randomcode="6B3A6735DB" memo="user">${emp.employeename }</span>
</td>


<td width="100" height="20" align="center" style="border-style: solid; border-color: rgb(0, 0, 0);" bgcolor="">总金额</td>
<td width="150" height="20" align="center" style="border-style: solid; border-color: rgb(0, 0, 0);" bgcolor="">
<input name="总金额" title="总金额" class="InputStyle_Edit" id="MAFO_5" datafld="SYS_SEL_DATE" value="" manydictnum="" tempforautonum="" fieldtype="3" fieldlength="255" defaultshowvalue="" fieldtitle="ysyf" relation="" sql=""  type="hidden" oldvalue=""><table cellspacing="0" cellpadding="0" id="MAFO_5_6B3A6735DB_table"><tbody><tr><td>
	<div class="template_date_show_div" style="min-width:108px">
		<input datafld="SYS_SEL_DATE" type="text" class="template_date_input" onfocus="this.select();" elname="总金额" id="MAFO_5_6B3A6735DB" style="width:108px;height: 23px" fieldid="TraceD001889CG61" randomcode="6B3A6735DB"></div></td></tr></tbody></table>
</td>
</tr>
<tr>
<td height="20" align="center" style="border-style: solid; border-color: rgb(0, 0, 0);" bgcolor="" colspan="6">

<table class="template_table_default_color" id="list_table_0" cellspacing="0" cellpadding="1" width="100%"><tbody rowmax="9" datanum="9" deltbl="" newtablename="htoa_yssq_mxb" id="ListTable_0" titlestr=";预算费用项目;金额;用途说明;">
	<tr id="tableTitle_0" height="30">
		<td tabletitle="预算费用项目" width="120" style=";text-align:center;color:#696969;font-size:10pt;text-align:center;border-width:1px;border-color:#B2B2B2;border-style:solid;background-color:#ECECEC;">预算费用项目</td>
		<td tabletitle="金额" width="100" style=";text-align:center;color:#696969;font-size:10pt;text-align:center;border-width:1px;border-color:#B2B2B2;border-style:solid;background-color:#ECECEC;">金额</td>	
		<td tabletitle="用途说明" width="250" style=";text-align:center;color:#696969;font-size:10pt;text-align:center;border-width:1px;border-color:#B2B2B2;border-style:solid;background-color:#ECECEC;">用途说明</td>
		<td tabletitle="凭据截图" width="150" style=";text-align:center;color:#696969;font-size:10pt;text-align:center;border-width:1px;border-color:#B2B2B2;border-style:solid;background-color:#ECECEC;">凭据截图</td>
		<td align="center" width="40" style="color: rgb(105, 105, 105); font-size: 10pt; text-align: center; border-width: 1px; border-color: rgb(178, 178, 178); border-style: solid; background-color: rgb(236, 236, 236); cursor: pointer;">
			<table width="40">
				<tbody>
					<tr>
						<td width="24"><span name="add" rowid="ListTable_0_1" class="template_list_add" tablename="htoa_yssq_mxb"></span></td>		
		</tr>
		</tbody>
		</table>
		</td>
	</tr>
	
					
	</tbody>
	
	</table>
</td>
</tr>


<tr>
<td height="80" align="center" style="border-style: solid; border-color: rgb(0, 0, 0);" bgcolor="">事由</td>
<td height="20" align="center" style="border-style: solid; border-color: rgb(0, 0, 0);" bgcolor="" colspan="5">
<input name="事由" title="事由" class="InputStyle_Edit" id="MAFO_7" datafld="SYS_SEL_CUPDTRACEMIND" style="width: 98%; height: 69px;" value="事由{原因}" manydictnum="" tempforautonum="" fieldtype="5" fieldlength="255" defaultshowvalue="" fieldtitle="zjl" relation="" sql=";imgName;date;" showstyle="" showlast="false" fielduse="" fieldhide="" defaulttruevalue="" type="hidden" oldvalue="">
	<div elname="事由" datafld="SYS_SEL_CUPDTRACEMIND" showtype=";imgName;date;" showstyle="" divstyle="" style=";height:99%;" fieldid="TraceD0018878JUQ" randomcode="6B3A6735DB">
		<textarea style="border: 0px;width: 617px;height: 77px;" class="cn_sy"></textarea>
	</div>
</td>
</tr>
<tr>
<td height="60" align="center" style="border-style: solid; border-color: rgb(0, 0, 0);" bgcolor="">流程说明</td>
<td height="20" style="border-style: solid; border-color: rgb(0, 0, 0);" colspan="5">
申请流程：
<br>
<br>
申请人
<font color="#7f7f7f">
→经理→总经理→财务
</font>
</td>
</tr>
</tbody>
</table>
<br>
</center>

<textarea name="javascript" style="display: none"></textarea></div>
                                            </div>
                                        </form>
                                    </div>
                           
       			</table>    			
       		</div>
       </div>
       

	</body>
<script type="text/javascript" src="/jboa/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$("[name=add]").click(function(){
			var app="<tr id='ListTable_0_6' rownumber='6' height='50' rowindex='6' class='zj'>"+
					"<td style='color:#696969;border-width:1px;border-color:#B2B2B2;border-style:solid;;text-align:center;background-color: rgb(250, 255, 189) '>"+
					"<input id='LISTFO_费用项目_6_6B3A6735DB' elname='费用项目_6' datafld='TEXT' style='border:1px solid #ccc; height:41px;color:#696969;background-color: rgb(250, 255, 189)' class='template_input_focus_style cost' title='费用项目' listtablename='htoa_yssq_mxb' rowindex='6' fieldid='TraceD0018972ACC' randomcode='6B3A6735DB'>"+
					"</td>"+
				"<td style='color:#696969;border-width:1px;border-color:#B2B2B2;border-style:solid;;text-align:center;background-color: rgb(250, 255, 189)'>"+
				"<input id='LISTFO_金额_6_6B3A6735DB' elname='金额_6' datafld='TEXT' style='border:1px solid #ccc;height:41px;color:#696969;background-color: rgb(250, 255, 189)' class='template_input_focus_style cn_money' title='金额' listtablename='htoa_yssq_mxb' rowindex='6' fieldid='TraceD0018972ACC' randomcode='6B3A6735DB'>"+
				"</td>"+
				"<td style='color:#696969;border-width:1px;border-color:#B2B2B2;border-style:solid;;text-align:left;background-color: rgb(250, 255, 189)'>"+			
				"<input id='LISTFO_用途说明_6_6B3A6735DB' elname='用途说明_6' datafld='TEXT' style='border:1px solid #ccc;height:41px;color:#696969;background-color: rgb(250, 255, 189)' class='template_input_focus_style cn_use' title='用途说明' listtablename='htoa_yssq_mxb' rowindex='6' fieldid='TraceD0018962818' randomcode='6B3A6735DB'>"+	
				"</td>"+
			"<td  style='color:#696969;border-width:1px;border-color:#B2B2B2;border-style:solid;;text-align:center;background-color: rgb(250, 255, 189)'>"+	
			"<input id='LISTFO_凭据截图_6_6B3A6735DB' style='height:41px;color:#696969;background-color: rgb(250, 255, 189)' class='template_input_focus_style photoshow' title='凭据截图' rowindex='6' listtablename='htoa_yssq_mxb' fieldid='TraceD0018972ACC' randomcode='6B3A6735DB' type='file'>"+
			"<img style='dispaly:none;' im='' ds=''/>"+
			"</td>"+			
		"<td align='center' width='40' style='color:#696969;border-width:1px;border-color:#B2B2B2;border-style:solid;'><table width='40'><tbody>"+		
			"<tr>"+
			"<td id='deltd' style='text-align: center' width='16'>"+
			"<span name='del' rowid='ListTable_0_6' class='template_list_del' tablename='htoa_yssq_mxb'></span></td></tr></tbody></table></td>"+
			"</tr>"; 
			$("#tableTitle_0").after(app);
		});
		
		$(document).on("click","[name=del]",function(){
			$(this).parents(".zj").remove();
			
		})
		
		
	
	//data:base64数据       name:文件名(feng.jpg)
		/* var imgObj1 = {
		"data" : "[]",
		"name" : "[]"
		};//图片对象 */
	//	de+="{\"subtotal\":\""+$(".cn_money").val()+"\",\"desc\":\""+$(".cn_use").val()+"\"},";			
		var imgobj="";
	 	var data="";
		$(function() {
		//选择预览图片		
		$(document).on(
				"change",
					".photoshow",
				function(e) {
					var xx=$(this);
					xx.hide();
					 var fr = new FileReader();//读取文件
					var file = this.files[0];//选择第一个文件 
					
						xx.next().show();
					var _temp = file.name.match(/\.jpg|\.png|\.gif|\.bmp/i);
					if (!_temp) {
						this.value = "";
						alert("目前只支持jpg,png,bmp,gif格式图片文件");
						xx.show();
						return false;
					} else if (file.size > (10*1024 * 1024)) {
						this.value = "";
						alert("目前只支持小于1M大小图片文件");
						xx.show();
						return false;
					}
				
					fr.readAsDataURL(file);//读取文件
					//操作文件事件
					fr.onload = function() {
						var base64Data = this.result;//获得base编码字符串格式
						/* 
							data= base64Data.substring(base64Data								
								.indexOf(';base64,') + 8); *///设置base64数据字符串 */
								xx.next().show();
								xx.next().css({"height":"41px","width":"60px","text-align":"center"});
						xx.next().attr("src", base64Data);//显示图片
						xx.next().attr("im",file.name);
						xx.next().attr("ds", base64Data.substring(base64Data								
								.indexOf(';base64,') + 8));
					}
					
					
					
				});	
		//通用新增方法
		function add(num){
		
			var re={};
			re["createman"]=$("#MAFO_2").val();
			re["departmentid"]=$("#MAFO_1").val();
			re["nextdealman"]=${emp.pid};
			re["event"]=$(".cn_sy").val();
		 	re["totalcount"]=$(".cn_money").val(); 
				if(num=="2"){
					re["statusid"]=2;
				}
			if(num=="1"){
					re["statusid"]=1;
			}
		
			var abc=0;	
			re["details"]=[]
 			$(".zj").each(function(){			
 				var detail={};
 				detail["subtotal"]=$(this).find($(".cn_money")).val();
 				detail["desc"]=$(this).find($(".cn_use")).val();
 				detail["pictruename"]=$(this).find('img').attr("im")
 				detail["pictruepath"]=$(this).find('img').attr("ds");
 		
 				re.details[abc]=detail;
 				abc++;
 			})
 			
			$.ajax("/jboa/remburse/addRemburse", {
				type : "post",
				dataType : "json",
				contentType:"application/json",//非常重要
				data:JSON.stringify(re),//非常重要
				timeout : 5000,
				success : function(data) {
					if (data.code == 200) {
						alert("保存成功");
						location.href = '/jboa/remburse/querylist';
					} else {
						alert("保存失败");
						location.reload();
					}
				}
			});
			
			}
		//点击提交按钮
		$(document).on("click","[name=tj]",function(){
			add("2");		
			})
		//点击保存按钮
		$(document).on("click","[name=bc]",function(){
			 add("1"); 
	
		})
		
	});
	</script>
</html>
