package com.accp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accp.spring01.biz.TestBizImpl;
import com.accp.spring01.whyioc.Printer;

public class Test01 {
	@Test
	public void testEmp() throws Exception{
		ApplicationContext ca=new ClassPathXmlApplicationContext("spring_txt.xml");
		Printer p=(Printer) ca.getBean("printer");
		p.printer();
	}
	@Test
	public void testBiz() throws Exception{
		ApplicationContext ca=new ClassPathXmlApplicationContext("biz_txt.xml");
		TestBizImpl biz=(TestBizImpl)ca.getBean("biz");
		biz.add();
		biz.del();
	}
}
