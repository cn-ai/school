package com.accp.ssm_02.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.ssm_02.biz.PaperBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-ctx.xml"})
public class TestBiz {
	@Autowired
	private PaperBiz biz;
	@Test
	public void TestLogin() {
		biz.Login("123", "admin");
	}
}
