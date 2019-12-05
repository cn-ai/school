package com.accp.biz;

import org.springframework.beans.factory.annotation.Autowired;

import com.accp.dao.IAccountDao;
import com.accp.pojo.Account;

public class AccountBiz {
	@Autowired
	public IAccountDao dao;
//登录
	public Account Login(String cardno, String password) {
		return dao.Login(cardno, password);
	}
	
}
