package com.accp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import org.junit.Test;

import com.accp.order.biz.OrderBiz;
import com.accp.order.pojo.Bill;
import com.accp.order.pojo.Detail;

public class Test01 {
	Scanner input = new Scanner(System.in);
	private OrderBiz biz=new OrderBiz();
	private void save() {
		/*String orderid= UUID.randomUUID().toString().replace("-", "");*/
		String m=String.valueOf(Math.random()*9+1*100000000);
		String m2=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime());
		m=m.substring(0, 4);
		
		Bill bill=new Bill(m+m2,new Date(), "小洋人", "株洲", "ss", "haha", "小小", "小花");
		bill.getDetail().add(new Detail("酸奶", 12, 2, 12*2, 0));
		bill.getDetail().add(new Detail("苹果", 12, 2, 12*2, 0));
		bill.getDetail().add(new Detail("牛奶", 12, 2, 12*2, 0));
		biz.saveOrderWithDetail(bill);
	}

	private void queryById() {
		System.out.println("请输入订单号:");
		String id=input.next();
		Bill b=biz.queryOrderbyId(id);		
		if(b!=null) {
			System.out.println(b);
		}else {
			System.out.println("对不起,没有此订单");
		}
		for (Detail d : b.getDetail()) {
			System.out.println(d);
		}
	}
	
	private void deleteOrderAndDetail() {
		System.out.println("请输入订单编号:");
		String id=input.next();
		int count=biz.deleteOrderAndDetail(id);
		if(count>0) {
			System.out.println("删除成功");
		}
	}
	@Test
	public void testMenu() throws Exception {
		do {
		System.out.println("欢迎使用一系列操作：");
		System.out.println("1.添加\t2.查询\t3.删除\t4.退出");
		System.out.println("请选择:");
		String option = input.next();
		switch (option) {
		case "1":
			save();
			break;
		case "2":
			queryById();
			break;
		case "3":
			deleteOrderAndDetail();
			break;
		case "4":
			System.out.println("感谢使用！");
			System.exit(0);
			break;
		default:
			System.out.println("没有此选项");
			break;
		}
		} while (true);
	}
}
