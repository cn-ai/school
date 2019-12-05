package com.accp.msgconvert.action;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.msgconvert.biz.BillBiz;
import com.accp.msgconvert.pojo.Bill;
import com.github.pagehelper.PageInfo;
@Controller
@RequestMapping("/bill")
public class BillAction {
	@Autowired
	private BillBiz biz;
//查询
	@RequestMapping(value="querylist",method=RequestMethod.GET)
	@ResponseBody
	public PageInfo<Bill> queryList(Integer num,Integer size){
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=2;
		}
		return biz.queryList(num, size);	
	}
//删除
	@RequestMapping(value="delbill",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,String> delbill(String [] billno){
		for (String b : billno) {	
			biz.delBill(Integer.valueOf(b));
		}
		Map<String,String> map=new HashMap<String, String>();
		map.put("code", "200");
		map.put("msg", "删除成功");
		return map;
	}
}
