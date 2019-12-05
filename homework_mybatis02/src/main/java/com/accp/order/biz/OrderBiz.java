package com.accp.order.biz;

import java.io.IOException;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.accp.order.dao.IOrderDao;
import com.accp.order.pojo.Bill;

public class OrderBiz {
	
private Logger logger=Logger.getRootLogger();
private SqlSessionFactory ssf;
	public OrderBiz() {
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		try {
			ssf=ssfb.build(Resources.getResourceAsStream("config.xml"));
		} catch (IOException e) {
			logger.error("配置文件文件读取错误",e);
		}		
	}
	//新增
	public int saveOrderWithDetail(Bill bill) {	
		SqlSession session = null;
		try {
			session=ssf.openSession();
			IOrderDao dao=session.getMapper(IOrderDao.class);
			int count= dao.saveBillWithDetail(bill);			
			 session.commit();
			 return count;
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		
	}
	//根据订单号查询
	public Bill queryOrderbyId(String id) {
		SqlSession session = null;
		try {
			session=ssf.openSession();
			IOrderDao dao=session.getMapper(IOrderDao.class);
			return dao.queryAllBillAndDetail(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}		
	}
	//删除
	public int deleteOrderAndDetail(String id) {
		SqlSession session=null;
		try {
			session =ssf.openSession();
			IOrderDao dao=	session.getMapper(IOrderDao.class);
			int count=dao.deleteBillAndDetail(id);
			session.commit();
			return count;
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		
	}
}
