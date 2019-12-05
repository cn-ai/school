package com.example.demo.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Users;

@RestController
@RequestMapping("/api")
public class UsersAction {
	@GetMapping("users/user/{id}")
	public Users loadUserId(@PathVariable Integer id) {
		return new Users(1,"dd","ddc");
	}
}
