package com.example.demo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class WebAction {
	@GetMapping("login")
	public String toLogin() {
		return "login";
	}
}
