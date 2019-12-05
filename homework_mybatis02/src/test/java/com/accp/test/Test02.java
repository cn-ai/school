package com.accp.test;

import java.util.Scanner;

import org.junit.Test;

import com.accp.order.biz.StudentBiz;
import com.accp.order.pojo.Clazz;
import com.accp.order.pojo.Student;

public class Test02 {
	Scanner input = new Scanner(System.in);
	
	private StudentBiz biz = StudentBiz.stuBiz();
	
	public void save() {
		Clazz clazz=new Clazz("java22");		
		clazz.getStudent().add(new Student("曹娜", "19990829", "女"));
		clazz.getStudent().add(new Student("小花","20000909","男"));
		clazz.getStudent().add(new Student("小小", "32340400", "女"));
		clazz.getStudent().add(new Student("小明", "43454655", "男"));
		biz.saveStudentAndClazz(clazz);
	
	}
	public void delete() {
		System.out.println("请输入学生编号:");
		int id=input.nextInt();
		int count=biz.delStudent(id);
		if(count>0) {
			System.out.println("移出成功");
		}
	}
	public void update() {
		System.out.println("请输入学生编号:");
		int id=input.nextInt();
		System.out.println("请输入班级号:");
		int cid=input.nextInt();
		Student stu=new Student(id, cid);
		int count=biz.updateStudent(stu);
		if(count>0) {
			System.out.println("转班成功");
		}
	}
	
	public void queryClazz() {
		System.out.println("请输入班级：");
		String name=input.next();
		for (	Clazz clazz:biz.queryClazzAndStudent(name)) {
			System.out.println("班级："+clazz);
			System.out.println("人数："+clazz.getStudent().size());
			for (Student stu : clazz.getStudent()) {
				System.out.println(stu);
			}
		}	
	}
	

	public void queryStudent() {
		System.out.println("请输入学生：");
		String sname=input.next();
		for (Student stu : biz.queryStudentAndClazz(sname)) {
			System.out.println("学生信息："+stu);
			System.out.println("班级信息:"+stu.getClazz());
		}
	}
	
	@Test
	public void testMenu() throws Exception {
		System.out.println("主菜单");
		System.out.println("1.新开一个班,并为该班指定三个学生\r\n" + "2.某学生被学校开除,请将该学生删除\r\n" + "3.学生从一个班转到另一个班\r\n"
				+ "4.查找指定班级的所有学生信息\r\n" + "5.打印某个学生的信息及该学生的班级信息\r\n" + "6.退出");
		System.out.println("请选择:");
		String option = input.next();
		switch (option) {
		case "1":
			save();
			break;
		case "2":
			delete();
			break;
		case "3":
			update();
			break;
		case "4":
			queryClazz();
			break;
		case "5":
			queryStudent();
			break;
		case "6":
			System.out.println("谢谢使用");
			System.exit(0);
			break;
		default:
			break;
		}

	}
}
