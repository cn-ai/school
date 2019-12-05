package com.accp.order.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.order.pojo.Bill;

public interface IOrderDao {
	//新增主详表
	int saveBillWithDetail(@Param("bill") Bill bill);
	//根据订单号查询
	Bill queryAllBillAndDetail(@Param("billno") String billno);
	//输入订单号,移除订单与订单明细信息.
	int deleteBillAndDetail(@Param("billno") String billno);
}
