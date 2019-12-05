package com.accp.entity;

import java.util.Date;

public class Student {
	public Student() {
		// TODO Auto-generated constructor stub
	}
public Student(String name, String sex, Date brithday, String img) {
		super();	
		this.name = name;
		this.sex = sex;
		this.brithday = brithday;
		this.img = img;
	}

private int id;//与查询列名相同
private String name;
private String sex;
private Date brithday;
private String img;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

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

public Date getBrithday() {
	return brithday;
}

public void setBrithday(Date brithday) {
	this.brithday = brithday;
}

public String getImg() {
	return img;
}

public void setImg(String img) {
	this.img = img;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", brithday=" + brithday + ", img=" + img + "]";
}



}
