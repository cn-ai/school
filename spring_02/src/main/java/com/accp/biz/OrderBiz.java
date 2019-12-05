package com.accp.biz;

import java.util.Date;

public class OrderBiz {
	public void addOrder(){
		//延迟3秒
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("下订单");
	}

	public void updateOrder(){
		
		//延迟10秒
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("修改订单");
		
		
		
	}

	public void deleteOrder(String sno){
		//延迟4秒
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sno==null){
			throw new RuntimeException("订单编号不能为空");
		}
		System.out.println("删除订单"+sno);
		
	}
}
