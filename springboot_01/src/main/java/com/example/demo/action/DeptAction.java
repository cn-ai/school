package com.example.demo.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.biz.DeptBiz;
import com.example.demo.pojo.Dept;
import com.example.demo.pojo.Emp;

@RestController
@RequestMapping("/api")
public class DeptAction {
	@Autowired
	private DeptBiz biz;
	@GetMapping("depts")
	public List<Dept> queryDeptList(){
		return biz.queryDeptList();
	}
	@GetMapping("depts/emp/{did}")
	public List<Emp> queryEmpList(@PathVariable Integer did){
		return biz.queryEmpList(did);
	}
	@DeleteMapping("depts/delemp/{eid}/{did}")
	public  Map<String, String> delEmp(@PathVariable Integer eid,@PathVariable Integer did) {
		biz.delEmp(eid);
		Map<String, String> map=new HashMap<String, String>();
		map.put("code", "200");
		map.put("msg", "success");
		map.put("count",String.valueOf(biz.queryEmpList(did).size()));
		return map;
	}
}
