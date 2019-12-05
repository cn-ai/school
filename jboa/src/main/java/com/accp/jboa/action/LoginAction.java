package com.accp.jboa.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.jboa.biz.LoginBiz;
import com.accp.jboa.pojo.Employee;

@Controller
@RequestMapping("/login")
public class LoginAction {
	@Autowired
	private LoginBiz biz;
	
/**
 * 登录
 * @param mo
 * @param employeename
 * @param password
 * @param session
 * @return
 */
	@RequestMapping(value="dl",produces="text/html;charset=utf-8")
	@ResponseBody
	public String Login(Model mo,String employeename,String password,HttpSession session) {
		Employee emp= biz.Login(employeename, password);
		if(emp!=null) {
			session.setAttribute("emp", emp);
			
			return "<script type='text/javascript'charset='utf-8'>alert('登录成功');location.href='/jboa/index.jsp';</script>";
		}
		return "<script type='text/javascript' charset='utf-8'>alert('用户名或密码错误！');location.href='/jboa/login.jsp';</script>";
	}
}
