package com.accp.Vote.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.Vote.pojo.user;
/**
 * 
* @ClassName: IUserDao 
* @Description: 用户数据访问层
* @author 筠颜
* @date 2018年11月14日 下午3:26:49 
*
 */
public interface IUserDao {
	//用户信息
	public user queryUser(@Param("user")Object user);
	//注册用户
	public void saveUser(@Param("user")Object user);
}
