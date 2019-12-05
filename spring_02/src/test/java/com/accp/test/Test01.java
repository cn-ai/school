package com.accp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accp.biz.OrderBiz;

public class Test01 {
	@Test
public void Test01() {
	ApplicationContext ca=new ClassPathXmlApplicationContext("orderBiz.xml");
	OrderBiz biz=(OrderBiz)ca.getBean("biz");
	biz.addOrder();
	biz.updateOrder();
	biz.deleteOrder("10010");
}
}
