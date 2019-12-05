package com.accp.msgconvert.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.msgconvert.dao.IBillDao;
import com.accp.msgconvert.pojo.Bill;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class BillBiz {
	@Autowired
	private IBillDao dao;
	
//查询
	public PageInfo<Bill> queryList(Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Bill> list= dao.queryList();
		PageInfo<Bill> info=new PageInfo<Bill>(list);
		return info;
	}
	
//删除
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void delBill(int billno) {
		dao.delBill(billno);
	}
}
