package com.accp.ajax.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.ajax.dao.IBillAndDetailDao;
import com.accp.ajax.pojo.Tb_Bill;

@Service
@Transactional(propagation= Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class BillBiz {
	@Autowired
	private IBillAndDetailDao dao;
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void addBillAndDetail(Tb_Bill bill) {
		dao.addBillAndDetail(bill);
	}
	
	public Tb_Bill loadBill() {
		return dao.loadBill();
	}
}
