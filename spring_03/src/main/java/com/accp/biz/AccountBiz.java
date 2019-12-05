package com.accp.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.accp.dao.IAccountDao;
import com.accp.pojo.Account;
import com.accp.pojo.Transaction_record;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class AccountBiz {
	@Autowired
	public IAccountDao dao;
//登录
	public Account Login(String cardno) {
		return dao.Login(cardno);
	}
	/**
	 * 新增记录表的转出
	 * @param rdcord
	 * @return
	 */
	public int addRecord(Transaction_record rdcord) {
		return dao.addRecord(rdcord);
	}
	/**
	 * 新增记录表的转入
	 * @param rdcord2
	 * @return
	 */
	public int addRecord2(Transaction_record rdcord2) {
		return dao.addRecord2(rdcord2);
	}
	/**
	 * 修改用户表的金额
	 * @param account
	 * @return
	 */
	public int updateAccount(Account account) {
		return dao.updateAccount(account);
	}
	/**
	 * 查询交易记录
	 * @param pageNum
	 * @param pageSize
	 * @param datebegin
	 * @param dateend
	 * @return
	 */
	public PageInfo<Transaction_record> queryDeal(int pageNum,int pageSize,String datebegin,String dateend){
		PageHelper.startPage(pageNum, pageSize);
		List<Transaction_record> list=dao.queryDeal(datebegin, dateend);
		PageInfo<Transaction_record> info=new PageInfo<Transaction_record>(list);
		return info;
	}
	/**
	 * 修改密码
	 * @param pwd
	 * @param cardno
	 * @return
	 */
	public int updatePwd(String pwd,String cardno) {
		return dao.updatePwd(pwd, cardno);
	}
}
