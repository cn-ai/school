package com.accp.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Account;
import com.accp.pojo.Transaction_record;

public interface IAccountDao {
	/**
	 *登录 
	 * @param cardno 卡号
	 * @param password 密码
	 * @return
	 */
	Account Login(@Param("cardno") String cardno,@Param("password") String password);
	/**
	 * 根据卡号查询余额
	 * @param cardno 
	 * @return
	 */
	Transaction_record queryBalance(String cardno);
}
