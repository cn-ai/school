package com.example.demo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewAction {
	
/**
 * 由于templates不能客户端访问，因此要借助action转发
 * @return
 */
	@RequestMapping("login")
	public String Tologin() {
		return "login";//模板的文件名相同
	}
	@RequestMapping("home")
	public String ToHome() {
		return "home";
	}
	
	@RequestMapping("student")
	public String Tostudent() {
		return "student";
	}
	
	
}
