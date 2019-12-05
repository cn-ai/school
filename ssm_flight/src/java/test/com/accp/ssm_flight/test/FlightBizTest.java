package com.accp.ssm_flight.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.ssm_flight.biz.FlightBiz;
import com.accp.ssm_flight.pojo.FlightInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-web.xml" })
public class FlightBizTest {
	@Autowired
	private FlightBiz biz;
	@Test
	public void Testquerylist() {
		  biz.querylist("001");
	}
}
