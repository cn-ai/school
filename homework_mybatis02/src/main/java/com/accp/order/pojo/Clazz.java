package com.accp.order.pojo;

import java.util.ArrayList;
import java.util.List;

public class Clazz {
	private int clazzid;
	private String clazzname;
	private List<Student> student=new ArrayList<>();
	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public int getClazzid() {
		return clazzid;
	}

	public void setClazzid(int clazzid) {
		this.clazzid = clazzid;
	}

	public String getClazzname() {
		return clazzname;
	}

	public void setClazzname(String clazzname) {
		this.clazzname = clazzname;
	}
public Clazz() {
	// TODO Auto-generated constructor stub
}

public Clazz( String clazzname) {
	super();
	
	this.clazzname = clazzname;
}

@Override
public String toString() {
	return "Clazz [clazzid=" + clazzid + ", clazzname=" + clazzname + "]";
}

}
