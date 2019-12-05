package com.example.demo.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class T_record {
private int rid;
private String rname;
private String stucode;
private Date createDate;
private String createBy;
private String des;
private T_student student;

public T_student getStudent() {
	return student;
}
public void setStudent(T_student student) {
	this.student = student;
}

public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}

public String getRname() {
	return rname;
}
public void setRname(String rname) {
	this.rname = rname;
}
public String getStucode() {
	return stucode;
}
public void setStucode(String stucode) {
	this.stucode = stucode;
}
public String getCreateBy() {
	return createBy;
}
public void setCreateBy(String createBy) {
	this.createBy = createBy;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}

}
