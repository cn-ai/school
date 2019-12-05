package com.example.demo.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.StudentBiz;
import com.example.demo.pojo.T_record;
import com.example.demo.pojo.T_student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c/users")
public class UserAction {
	@Autowired
	private StudentBiz biz;
	@GetMapping("login")
	public String Login(Model mo,T_student student,HttpSession session) {
		T_student stu=biz.Login(student.getStuname(),student.getCode());
		if(stu!=null) {
			session.setAttribute("stu", stu);
			return "index";
		}else {
			mo.addAttribute("msg", "用户名或密码错误");
			return "login";
		}
	}
	@GetMapping("querystudent")
	public String queryStudent(Integer pageNum,Integer pageSize,Model mo) {
		if(pageNum==null) {
			pageNum=1;
		}
		if(pageSize==null) {
			pageSize=3;
		}
		PageInfo<T_student> pageInfo= biz.queryStudent(pageNum, pageSize);
		mo.addAttribute("pageInfo", pageInfo);
		return "student";
	}
	
	@GetMapping("loadrecord/{code}")
	@ResponseBody
	public PageInfo<T_record> loadRecord(@PathVariable String code){
		PageInfo<T_record> info= biz.loadRecord(code, null, null, 1, 10);
		return info;
	}
	@GetMapping("queryrecord")
	public String queryRecord(String stuname,String rname,Integer pageNum,Integer pageSize,Model mo) {
		if(pageNum==null) {
			pageNum=1;
		}
		if(pageSize==null) {
			pageSize=3;
		}
		if(stuname==null) {
			stuname="";
		}
		if(rname==null) {
			rname="";
		}
		PageInfo<T_record> pageinfo=biz.loadRecord(null, stuname, rname, pageNum, pageSize);
		mo.addAttribute("pageinfo", pageinfo);
		return "recode";
	}
	
	@RequestMapping("addrecode")
	public String Toaddrecode(Model mo) {
		List<T_student> list=biz.loadStudent();
		mo.addAttribute("list", list);
		return "addrecode";
	}
	@PostMapping(value="addrecord",produces="text/html;charset=utf-8")
	@ResponseBody
	public String addrecord(T_record record) {
		biz.addRecord(record);
		return "<script type='text/javascript'charset='utf-8'>alert('新增成功');location.href='/c/users/queryrecord';</script>";
	}
	@GetMapping(value="delrecord",produces="text/html;charset=utf-8")
	@ResponseBody
	public String delrecord(Integer rid) {
		biz.delRecord(rid);
		return "<script type='text/javascript'charset='utf-8'>alert('删除成功');location.href='/c/users/queryrecord';</script>";
	}
	@GetMapping(value="recordOne")
	public String recordOne(Integer rid,Model mo) {
		T_record record=biz.recordOne(rid);
		mo.addAttribute("record", record);
		List<T_student> list=biz.loadStudent();
		mo.addAttribute("list", list);
		return "updaterecord";
	}
	@PostMapping(value="updaterecord",produces="text/html;charset=utf-8")
	@ResponseBody
	public String updaterecord(T_record record) {
		biz.updateRecord(record);
		return "<script type='text/javascript'charset='utf-8'>alert('修改成功');location.href='/c/users/queryrecord';</script>";
	}
	
}
