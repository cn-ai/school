package com.example.demo.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ILoginDao;
import com.example.demo.pojo.Users;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class LoginBiz {
	@Autowired
	private ILoginDao logindao;
	//登录
	public Users Login(String uemail,String upwd) {
		return logindao.Login(uemail, upwd);
	} 
	//注册
	@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public int reg(Users user) {
		return logindao.reg(user);
	}
	//验证邮箱是否存在
	public Users testLogin(String uemail) {
		return logindao.testEmail(uemail);
	}
}
