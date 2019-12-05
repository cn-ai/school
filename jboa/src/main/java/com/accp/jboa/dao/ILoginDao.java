package com.accp.jboa.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.jboa.pojo.Employee;

public interface ILoginDao {
//登录
	Employee Login(@Param("employeename") String employeename,@Param("password") String password);
}
