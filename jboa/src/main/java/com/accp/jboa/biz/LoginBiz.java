package com.accp.jboa.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.jboa.dao.ILoginDao;
import com.accp.jboa.pojo.Employee;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class LoginBiz {
	@Autowired
	private ILoginDao dao;
	
	
/**
 * 登录
 * @return
 */
	public Employee Login(String employeename,String password) {
		return dao.Login(employeename, password);
	}
}
