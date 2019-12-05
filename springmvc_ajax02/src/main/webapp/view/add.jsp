<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div style="width: 700px;height: auto;border: 1px solid #00B5F1;">
			<h3 style="margin:0px;height: 30px;width: 700px;border-bottom: 1px solid #00B5F1;background-color: #00E8D7;color: blue;">采购入库</h3>
			<p>
				<label>单据编号：</label>
				<input type="text" name="billno" style="border-radius: 15%;border: 1px solid #00B5F1;"/>
				<label style="margin-left: 30px;">单据日期：</label>
				<input type="date" name="billdate" style="border-radius: 15%;border: 1px solid #00B5F1;"/>
			</p>
				<p>
				<label>供应商：</label>
				<input type="text" name="suppliername" style="border-radius: 15%;border: 1px solid #00B5F1;"/>
				<label style="margin-left: 30px;">供应商地址：</label>
				<input type="text" name="supplieraddress" style="border-radius: 15%;border: 1px solid #00B5F1;"/>
			</p>
				<p>
				<label>部门：</label>
				<input type="text" name="department" style="border-radius: 15%;border: 1px solid #00B5F1;"/>
				<label style="margin-left: 30px;">仓库：</label>
				<input type="text" name="warehouse" style="border-radius: 15%;border: 1px solid #00B5F1;"/>
			</p>
				<p>
				<label>采购人员：</label>
				<input type="text" name="buyer" style="border-radius: 15%;border: 1px solid #00B5F1;"/>
				<label style="margin-left: 30px;">制单人员：</label>
				<input type="text" name="executor" style="border-radius: 15%;border: 1px solid #00B5F1;"/>
			</p>
			<p>
				<label style="text-align:justify; ">入库明细：</label>
				<textarea cols="60" rows="10" name="detail"></textarea>
				
			</p>
			<p>
				<button onclick="jz()">加载测试数据</button>
				<button onclick="fwq()">加载服务端数据</button>
				<button onclick="add()">保存</button>
				<input type="reset" value="清空" onclick="qk()"/>
			</p>
		</div>
	</body>
	<script type="text/javascript" src="/springmvc_ajax02/js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
//加载服务器数据
	function fwq(){
		$.ajax({
			url:"/springmvc_ajax02/bill/load",
			type:"post",
			dataType:"json",
			contentType:"application/json",
			success:function(result){
				$("[name=billno]").val(result.billno);
				$("[name=billdate]").val(result.billdate);
				$("[name=suppliername]").val(result.suppliername);
				$("[name=supplieraddress]").val(result.supplieraddress);
				$("[name=department]").val(result.department);
				$("[name=warehouse]").val(result.warehouse);
				$("[name=buyer]").val(result.buyer);
				$("[name=executor]").val(result.executor);
				var detail=JSON.stringify(result.detail);
				$("[name=detail]").val(detail);
			}
		})
	}
	
	function qk(){
		$("[name=billno]").val("");
		$("[name=billdate]").val("");
		$("[name=suppliername]").val("");
		$("[name=supplieraddress]").val("");
		$("[name=department]").val("");
		$("[name=warehouse]").val("");
		$("[name=buyer]").val("");
		$("[name=executor]").val("");		
		$("[name=detail]").val("");
	}
	
//新增
	function add(){
		var bill={};
		bill["billno"]=$("[name=billno]").val();
		bill["billdate"]=$("[name=billdate]").val();
		bill["suppliername"]=$("[name=suppliername]").val();
		bill["supplieraddress"]=$("[name=supplieraddress]").val();
		bill["department"]=$("[name=department]").val();
		bill["warehouse"]=$("[name=warehouse]").val();
		bill["buyer"]=$("[name=buyer]").val();
		bill["executor"]=$("[name=executor]").val();
	//反序列化成数组
		bill["detail"]=JSON.parse($("[name=detail]").val());
		$.ajax({
			url:"/springmvc_ajax02/bill/add",
			type:"post",
			dataType:"json",
			contentType:"application/json",
			data:JSON.stringify(bill),
			success:function(map){
				if(map.code=="200"){
					alert("新增成功");
				}
			}			
		})
	}

//加载测试数据
	function jz(){
	var testjson={
			"billno":"20160119001",          //单据编号
			"billdate":"2016-01-19",         //单据日期
			"suppliername":"联想株洲总代理",     // 供应商
			"supplieraddress":"株洲天元区黄山路", //供应商地址
			"department":"物控部",             //采购所属部门
			"warehouse":"株洲仓",              //入库仓库
			"buyer":"牛采购",                  //采购人员
			"executor":"小花",                 //制单人
			"details":[{                      //商品明细数据
			"billno":"20160119001",         //商品编号
			"lineid":1,                     //序号，或者行号
			"goodsname":"联想笔记本",          //商品名称
			"goodsnum":10,                  //数量
			"goodsprice":3000.00,           //单价
			"goodsmoneyamt":30000.00,       //金额
			"ispresent":0               //是否赠品
		},{
			"billno":"20160119001",
			"lineid":2,
			"goodsname":"数码相机",
			"goodsnum":10,
			"goodsprice":2000.00,
			"goodsmoneyamt":20000.00,
			"ispresent":1
		}]};	
	$("[name=billno]").val(testjson.billno);
	$("[name=billdate]").val(testjson.billdate);
	$("[name=suppliername]").val(testjson.suppliername);
	$("[name=supplieraddress]").val(testjson.supplieraddress);
	$("[name=department]").val(testjson.department);
	$("[name=warehouse]").val(testjson.warehouse);
	$("[name=buyer]").val(testjson.buyer);
	$("[name=executor]").val(testjson.executor);
//序列化
	var jsonstring=JSON.stringify(testjson.details);
		$("[name=detail]").val(jsonstring);	
}
	</script>
</html>