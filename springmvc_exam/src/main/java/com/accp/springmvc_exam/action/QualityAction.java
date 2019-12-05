package com.accp.springmvc_exam.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.springmvc_exam.biz.QualityBiz;
import com.accp.springmvc_exam.pojo.District;
import com.accp.springmvc_exam.pojo.air_quality_index;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/air")
public class QualityAction {
	@Autowired
	private QualityBiz biz;
	
	@RequestMapping("queryAll")
	public String queryAll(Model mo, Integer districtid,Integer num,Integer size) {
		if(num==null) {
			num=1;
		}
		if(size==null) {
			size=2;
		}
		List<District> list=biz.queryDistrict();
		PageInfo<air_quality_index> pageInfo=biz.queryAll(districtid, num, size);
		mo.addAttribute("list", list);
		mo.addAttribute("info", pageInfo);
		return "query";
	}
	@RequestMapping("add")
	@ResponseBody
	public String addAir(air_quality_index air) {

		biz.insertAir(air);
		return "<script type='text/javascript'charset='utf-8'>alert('success');location.href='/spring_exam/air/queryAll';</script>";
	}
	@RequestMapping("toadd")
	public String load(Model mo) {
		List<District> list=biz.queryDistrict();
		mo.addAttribute("list", list);
		return "add";
	}
	@RequestMapping("toupdate")
	public String toupdate(Model mo, Integer id) {
		air_quality_index air=	biz.loadAir(id);
		List<District> list=biz.queryDistrict();
		mo.addAttribute("list", list);
		mo.addAttribute("air", air);
		return "update";
	}
	@RequestMapping("update")
	@ResponseBody
	public String updateAir(air_quality_index air) {
		biz.updateAir(air);
		return "<script type='text/javascript'charset='utf-8'>alert('success');location.href='/spring_exam/air/queryAll';</script>";
	}
//删除
	@RequestMapping("del")
	@ResponseBody
	public String delAir(Model mo, Integer id) {
		biz.delAir(id);
		return "<script type='text/javascript'charset='utf-8'>alert('success');location.href='/spring_exam/air/queryAll';</script>";	
	}
}
