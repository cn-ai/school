package com.example.demo.pojo;

import java.util.Date;

public class Student {
public Student(String uname, Date birthday, String love) {
		super();
		this.uname = uname;
		this.birthday = birthday;
		this.love = love;
	}
public Student() {
	// TODO Auto-generated constructor stub
}
private int uid;
private String uname;
private Date birthday;
private String love;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getLove() {
	return love;
}
public void setLove(String love) {
	this.love = love;
}

}
