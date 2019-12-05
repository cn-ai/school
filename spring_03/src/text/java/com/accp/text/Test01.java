package com.accp.text;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.biz.AccountBiz;
import com.accp.pojo.Transaction_record;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:xxx.xml" })
public class Test01 {
	@Autowired
	private AccountBiz biz;
	@Test
	public void Testbiz() {
		biz.Login("201811120001");
	}
	
	public void Testadd() throws Exception {
		Transaction_record record=new Transaction_record(48, "a", new Date(), 4, 4, "消费");
		biz.addRecord(record);
	}
	public void TestPwd() {
		biz.updatePwd("3", "0001201811120002");
	}
}
