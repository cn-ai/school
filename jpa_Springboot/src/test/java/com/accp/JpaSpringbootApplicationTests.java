package com.accp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accp.biz.DistrictBiz;
import com.accp.vo.QueryVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaSpringbootApplicationTests {
	@Autowired
	private DistrictBiz biz;
	
	@Test
	public void contextLoads() {
		Page<QueryVo> list=biz.queryQueryVo(new PageRequest(0, 2));
		for (QueryVo vo : list) {
			System.out.println(vo);
		}
	}

}
