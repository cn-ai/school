package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Users;

public interface ILoginDao {
//登录
	Users Login(@Param("uemail") String uemail,@Param("upwd")String upwd);
//注册
	int reg(@Param("user") Users user);
//验证邮箱是否存在
	Users testEmail(@Param("uemail") String uemail);
}
