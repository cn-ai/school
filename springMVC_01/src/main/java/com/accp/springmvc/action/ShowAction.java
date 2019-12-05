package com.accp.springmvc.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accp.springmvc.pojo.User;

@Controller
public class ShowAction {
	@RequestMapping(value = "/show1", method = RequestMethod.POST)
	public String Show(User user, Model mo) throws Exception {
		if(user.getCity().length()<=0||user.getUname().length()<=0) {
			mo.addAttribute("msg", "昵称或城市不能为空");
			return "/test.jsp";
		}else if(user.getLanguage()==null) {
			mo.addAttribute("msg", "请选择你擅长的语言");
			return "/test.jsp";
		}else {
			mo.addAttribute("user",user);
			return "/show.jsp";
		}
		
	}
}
