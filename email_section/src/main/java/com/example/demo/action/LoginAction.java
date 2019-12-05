package com.example.demo.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.biz.LoginBiz;
import com.example.demo.biz.OutboxBiz;
import com.example.demo.pojo.Outbox;
import com.example.demo.pojo.Users;

@RestController
@RequestMapping("/api")
public class LoginAction {
	@Autowired
	private LoginBiz loginBiz;

	//登录
	@GetMapping(value="/login/{uemail}/{upwd}")
	public Map<String, String> Login(HttpSession session,@PathVariable String uemail,@PathVariable String upwd) {
		Users user=loginBiz.Login(uemail, upwd);
		Map<String,String> map=new HashMap<String,String>();
		if(user!=null) {
			session.setAttribute("user", user);
			map.put("code","200");
			map.put("msg","登录成功");
		}	
		return map;
	}
	//注册
	@PostMapping(value="/reg")
	public Map<String, String> reg(@RequestBody Users user){
		Map<String,String> mapjson=new HashMap<String,String>();
		System.out.println("fd");
		int count=loginBiz.reg(user);
		mapjson.put("code","200");
		mapjson.put("msg","注册成功");
		return mapjson;
	}
	//验证邮箱是否存在
	@GetMapping(value="/testlogin/{uemail}")
	public Map<String, String> testlogin(@PathVariable String uemail) {
		Users user=loginBiz.testLogin(uemail);
		Map<String,String> map=new HashMap<String,String>();
		if(user!=null) {
			map.put("code","200");
			map.put("msg","邮箱已存在");
		}	
		return map;
	}
	/**
	 * 收件箱操作
	 * @return
	 */
	@Autowired
	private OutboxBiz outboxbiz;
	//查询收件箱
	@GetMapping("/outbox/find/{state}/{inuid}")
	public List<Outbox> queryOutbox(@PathVariable int state,@PathVariable int inuid){
		return outboxbiz.queryOutbix(state, inuid);
	}
}
