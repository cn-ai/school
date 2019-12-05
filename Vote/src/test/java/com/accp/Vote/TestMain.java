package com.accp.Vote;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.Vote.dao.ISubjectDao;
import com.accp.Vote.dao.IUserDao;
import com.accp.Vote.pojo.item;
import com.accp.Vote.pojo.subject;
import com.accp.Vote.pojo.user;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-ctx.xml"})
public class TestMain {
	@Autowired
	private ISubjectDao dao;
	@Test
	public void Testname() {
//		item i = new item();
//		i.setSid(1);
//		i.setUid(2);
//		System.out.println(dao.queryWay("1",i)>0);
//		dao.queryItems("1");
	}
}
