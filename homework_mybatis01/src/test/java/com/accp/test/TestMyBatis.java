package com.accp.test;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accp.entity.Student;

public class TestMyBatis {
	private SqlSession session;
	@Before
	public void init() throws Exception {
		//1.构建核心配置文件解析器(类)
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		//2.构建SqlSessionFactory[重量级]
		SqlSessionFactory ssf=ssfb.build(Resources.getResourceAsStream("config.xml"));
		//构建SqlSession[轻量级]
		session=ssf.openSession();
		
	}
	
	@After
	public void over() throws Exception{
		session.close();
	}
	
	@Test
	public void TestAll() throws Exception {
		//操作
		
		//标准查询分为map和实体
		/*List<Map<Object, Object>> list=session.selectList("com.accp.DemoDao.selectAll");
		for (Map<Object, Object> map : list) {
			System.out.println(map.get("id")+"\t"+map.get("name")+"\t"+map.get("sex")+"\t"+map.get("brithday")+"\t"+map.get("img"));
		}*/
		
		List<Student> list=session.selectList("com.accp.DemoDao.selectAll");
		for (Student stu : list) {
			System.out.println(stu);
		}
	}
	//带条件查询
	@Test
	public void TestById() throws Exception{
		/*Map m=new HashMap<>();
		m.put("id", 1);*/
		Student stu=session.selectOne("com.accp.DemoDao.selectById", 1);
		System.out.println(stu.toString());
	}
//查询未成年
	@Test
	public void TestCount() throws Exception{
		Long count=session.selectOne("com.accp.DemoDao.queryCount");
		System.out.println(count);
	}
	@Test
	public void TestLike()throws Exception {
		Map m=new HashMap<>();
		m.put("name", "李");
		m.put("sex", "女");
		List<Student> list=session.selectList("com.accp.DemoDao.queryLike", m);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	@Test
	public void Save()throws Exception {
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date d=sdf.parse("2012-04-05");
			int count=session.insert("com.accp.DemoDao.save", new Student("李二","男",d,"sss"));
			if(count>0) {
				System.out.println("新增成功");
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}
	}
	@Test
	public void Del()throws Exception  {
		try {
			int count=session.delete("com.accp.DemoDao.del", 1);
			System.out.println(count);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}
	}
	
	
}
