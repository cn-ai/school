package com.accp.ajax.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.ajax.biz.BillBiz;
import com.accp.ajax.pojo.Tb_Bill;

@Controller
@RequestMapping("/bill")
public class BillAction {
	@Autowired
	private BillBiz biz;
	
	@RequestMapping("add")
	@ResponseBody
	public Map<String,String> addBillAndDetail(@RequestBody Tb_Bill bill){
		biz.addBillAndDetail(bill);
		Map<String,String> map=new HashMap<String, String>();
		map.put("code", "200");
		map.put("msg", "添加成功");
		return map;
	}
	@RequestMapping("load")
	@ResponseBody
	public Tb_Bill loadBill() {
		Tb_Bill bill=biz.loadBill();
		return bill;
	}
}
