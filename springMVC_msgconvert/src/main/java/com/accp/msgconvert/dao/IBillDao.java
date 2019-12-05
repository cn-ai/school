package com.accp.msgconvert.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.msgconvert.pojo.Bill;

public interface IBillDao {
//查询
	 List<Bill> queryList();
//删除
	void  delBill(@Param("billno") int billno);
}
