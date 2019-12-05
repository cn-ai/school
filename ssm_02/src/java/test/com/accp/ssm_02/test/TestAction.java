package com.accp.ssm_02.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.accp.ssm_02.pojo.T_user;
import com.accp.ssm_02.vo.PaperVo;
import com.github.pagehelper.PageInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-web.xml"})
@WebAppConfiguration
public class TestAction {
	@Autowired
	private WebApplicationContext wac;// 非常重要
	private MockMvc mockMvc;// mvc_handler测试对象
	@Before
	public void initMockMvc() {
		// 构建者模式
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	@Test
	public void TestLogin() throws Exception {
		MvcResult mr = this.mockMvc.perform(get("/user/login?userName=123&userPassword=admin")).andExpect(status().isOk()).andDo(print())
				.andReturn();
		T_user user=(T_user)mr.getModelAndView().getModel().get("user");
		System.out.println(user.getUserCode()+"\n"+user.getUserPassword());
	}
	@Test
	public void TestQuery() throws Exception {
		MvcResult mr = this.mockMvc.perform(get("/user/query?pageNum=1&pageSize=2")).andExpect(status().isOk()).andDo(print())
				.andReturn();
		PageInfo<PaperVo> info=(PageInfo<PaperVo>) mr.getModelAndView().getModel().get("info");
		for (PaperVo vo : info.getList()) {
			System.out.println(vo.getTitle());
		}
	}
}
