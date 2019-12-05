package com.accp.ssm_flight.test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accp.ssm_flight.pojo.FlightInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-web.xml" })
@WebAppConfiguration
public class FlightActionTest {
	@Autowired
	private WebApplicationContext wac;
	// mvc_handler测试对象
	private MockMvc mvc;

	@Before
	public void initMvc() {
		//构建者模式
		this.mvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	/**
	 * 关键方法 perform：请求方式及路径
	 * andExpect：状态码
	 * andDo：打印消息
	 * andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理；
	 * mockMvc.perform(get("/person/list?p=2&s=2")).andExpect(status().isOk()).andDo(print())
	 * .andReturn();
	 * @throws Exception 
	 */
	@Test
	public void TestAction() throws Exception {
	MvcResult result=this.mvc.perform(get("/flight/list?flight=001")).andExpect(status().isOk()).andDo(print()).andReturn();
		//使用逻辑渲染数据
		List<FlightInfo> list= (List<FlightInfo>) result.getModelAndView().getModel().get("list");
		for (FlightInfo info : list) {
			System.out.println(info);
		}
	}
}
