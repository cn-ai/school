package com.accp.mybatis_house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.mybatis_house.pojo.Area;
import com.accp.mybatis_house.pojo.District;
import com.accp.mybatis_house.pojo.Type;
import com.accp.mybatis_house.pojo.User;
import com.accp.mybatis_house.vo.vo;

public interface IUserDao {
//新增用户
	int zc(@Param("user") User user);
//登录
	User Login(@Param("uname") String uname,@Param("upwd") String upwd);
//查询相同名称
	User loadName(@Param("uname") String uname);
//查询地区
	List<District> querydistrict();
//查询房型
	List<Type> querytype();
//查询面积
	List<Area> queryarea();
}
