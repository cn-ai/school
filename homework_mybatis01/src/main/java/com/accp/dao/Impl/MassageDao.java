package com.accp.dao.Impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.accp.dao.IMassageDao;
import com.accp.entity.Message;

public class MassageDao implements IMassageDao{
	private SqlSession session;
	
	public void init() throws Exception {
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf=ssfb.build(Resources.getResourceAsReader("config.xml"));
		session=ssf.openSession();
	}
	
	public void over () throws Exception  {
		session.close();
	}
	
	@Override
	public void SelectAll() throws Exception {
		init();
		List<Message> list=session.selectList("com.accp.Test.queryAll");
		for (Message message : list) {
			System.out.println("留言人\t"+message.getId()+"\t留言时间\t"+message.getCreateTime());
			System.out.println("留言标题\t"+message.getTitle()+"\t留言内容\t"+message.getContents());
		}
		over();
	}

	@Override
	public void Save() throws Exception {
		try {
			init();
			Scanner input=new Scanner(System.in);
			System.out.println("请输入留言人姓名:");
			String name=input.next();
			System.out.println("请输入留言标题:");
			String title=input.next();
			System.out.println("请输入留言内容:");
			String contents=input.next();
			int count=session.insert("com.accp.Test.save",new Message(name, title, contents, new Date()));
			if(count>0) {
				System.out.println("留言成功!");
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
		}finally {
			over();
		}
	}

}
