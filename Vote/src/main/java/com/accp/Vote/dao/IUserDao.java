package com.accp.Vote.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.Vote.pojo.user;
/**
 * 
* @ClassName: IUserDao 
* @Description: �û����ݷ��ʲ�
* @author ����
* @date 2018��11��14�� ����3:26:49 
*
 */
public interface IUserDao {
	//�û���Ϣ
	public user queryUser(@Param("user")Object user);
	//ע���û�
	public void saveUser(@Param("user")Object user);
}
