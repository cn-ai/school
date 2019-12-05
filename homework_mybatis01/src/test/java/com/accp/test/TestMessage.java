package com.accp.test;

import java.util.Scanner;

import org.junit.Test;

import com.accp.dao.IMassageDao;
import com.accp.dao.Impl.MassageDao;

public class TestMessage {
	private IMassageDao dao=new MassageDao();
	@Test	
	public void menu() throws Exception {
		do {
			Scanner input=new Scanner(System.in);
			System.out.println("------主菜单------");
			System.out.println("1.查询留言");
			System.out.println("2.添加留言");
			System.out.println("3.退出系统");
			System.out.println("请选择");
			String option=input.next();
			switch(option) {
			case "1":
				dao.SelectAll();
				break;
			case "2":
				dao.Save();
				break;
			case "3":
				System.out.println("谢谢使用");
				System.exit(0);		
			}
		} while (true);
	
}
	
}
