package com.accp.ajax.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.ajax.pojo.Tb_Bill;

public interface IBillAndDetailDao {
/**
 * 新增主详表
 * @param bill
 */
	void addBillAndDetail(@Param("bill") Tb_Bill bill);
/**	
 * 查询最大的订单
 * @param billno
 * @return
 */
	Tb_Bill loadBill();
}
