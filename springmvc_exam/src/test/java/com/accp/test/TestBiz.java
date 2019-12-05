package com.accp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.springmvc_exam.biz.QualityBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-ctx.xml" })
public class TestBiz {
	private QualityBiz biz;
	@Test
	public void TestqueryAll() {
		biz.queryAll(-1, 1, 2);
	}
}
