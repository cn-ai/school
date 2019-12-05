package com.example.demo.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.biz.MessageBiz;
import com.example.demo.pojo.Login;

@Controller
@RequestMapping("/c/login")
public class UserAction {
	@Autowired
	private MessageBiz biz;
	@GetMapping("validateLogin")
	@ResponseBody
	public String validateLogin(HttpSession session,String uname,String upwd) {
		Login login=biz.dl(uname, upwd);
		if(login!=null) {
			session.setAttribute("user", login);
			return "redirect:/index.html";
		}
		return "<script>alert('用户名或密码错误');location.href='/view/tologin';</script>";
	}
}
