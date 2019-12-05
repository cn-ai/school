package com.accp.spring01.pojo;

import java.util.Date;
import java.util.List;

import org.junit.experimental.theories.FromDataPoints;

public class Employee {
//姓名
	public String name;
//性别
	public String sex;
//出生日期
	public Date birthdayDate;
//爱好
	List<String> loves;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthdayDate() {
		return birthdayDate;
	}
	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}
	public List<String> getLoves() {
		return loves;
	}
	public void setLoves(List<String> loves) {
		this.loves = loves;
	}
	public void display() {
		System.out.println("姓名:"+this.name);
		System.out.println("性别:"+this.sex);
		System.out.println("出生日期:"+this.birthdayDate.toLocaleString());
		for (String l : loves) {
			System.out.println("爱好:"+l);
		}
	}
}
