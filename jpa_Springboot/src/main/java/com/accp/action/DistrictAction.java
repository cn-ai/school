package com.accp.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.DistrictBiz;
import com.accp.dao.IDistrictDao;
import com.accp.pojo.District;
import com.accp.pojo.Quality;
import com.accp.vo.QueryVo;

@Controller
public class DistrictAction {
	@Autowired
	private DistrictBiz biz;
	
	@RequestMapping("/queryDistrict")
	public String queryDistrict(Model mo,Integer index, Integer size, String name){
		if(index==null) {
			index=0;
		}
		if(size==null) {
			size=2;
		}
		if(name==null) {
			name=null;
		}
		List<District> dlist=biz.queryDistrict();		
		Page<QueryVo> page=biz.queryQueryVo(new PageRequest(index, size),name);
		mo.addAttribute("dlist", dlist);
		mo.addAttribute("page", page);
		mo.addAttribute("pageNum", index);
		mo.addAttribute("pages", page.getTotalPages());
		mo.addAttribute("number", page.getTotalElements());
		return "index";
	}
	
	@RequestMapping("/query")
	public String queryd(Model mo) {
		List<District> dlist=biz.queryDistrict();
		mo.addAttribute("dlist", dlist);
		return "add";
	}
	@PostMapping(value="/add",produces="text/html;charset=utf-8")
	@ResponseBody
	public String add(Quality q) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		q.setLastmodifytime(new Date());
		System.out.println(q);
		biz.add(q);
		return "<script type='text/javascript'charset='utf-8'>alert('新增成功');location.href='/queryDistrict';</script>";
	}
}
