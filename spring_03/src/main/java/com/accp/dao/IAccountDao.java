package com.accp.dao;

import java.util.List;

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
	Account Login(@Param("cardno") String cardno);
	/**
	 * 新增记录表的转出
	 * @param rdcord
	 * @return
	 */
	int addRecord(@Param("rdcord") Transaction_record rdcord);
	/**
	 * 新增记录表的转入
	 * @param rdcord2
	 * @return
	 */
	int addRecord2(@Param("rdcord2")Transaction_record rdcord2);
	/**
	 * 修改用户表的金额
	 * @param account
	 * @return
	 */
	int updateAccount(@Param("account")Account account);
	/**
	 * 查询交易记录
	 * @return
	 */
	List<Transaction_record>  queryDeal(@Param("datebegin")String datebegin,@Param("dateend")String dateend);
	/**
	 * 修改密码
	 * @param pwd
	 * @param cardno
	 * @return
	 */
	int updatePwd(@Param("pwd")String pwd,@Param("cardno")String cardno);
}
