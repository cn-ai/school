package com.accp.order.pojo;

public class Student {
private int sid;
private String sname;
private String sCardId;
private String sex;
private int clazzid;
private Clazz clazz;

public Clazz getClazz() {
	return clazz;
}
public void setClazz(Clazz clazz) {
	this.clazz = clazz;
}
public int getClazzid() {
	return clazzid;
}
public void setClazzid(int clazzid) {
	this.clazzid = clazzid;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getsCardId() {
	return sCardId;
}
public void setsCardId(String sCardId) {
	this.sCardId = sCardId;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public Student(String sname, String sCardId, String sex) {
	super();
	this.sname = sname;
	this.sCardId = sCardId;
	this.sex = sex;

}

public Student(String sname, String sCardId, String sex, int clazzid) {
	super();
	this.sname = sname;
	this.sCardId = sCardId;
	this.sex = sex;
	this.clazzid = clazzid;
}
public Student(int sid, int clazzid) {
	super();
	this.sid=sid;
	this.clazzid=clazzid;

}
public Student() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", sCardId=" + sCardId + ", sex=" + sex + "]";
}



}
