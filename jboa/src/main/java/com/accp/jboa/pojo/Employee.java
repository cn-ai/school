package com.accp.jboa.pojo;

public class Employee {
private int employeeid;
private String employeename;//用户姓名
private String password;//密码
private int departmentid;//所属部门编号，外键
private int positionid;//职位编号，外键
private String status;//用户状态
private int pid;//上一级

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
//部门
private Department department;
//职位
private Tb_opsition position;

public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}
public Tb_opsition getPosition() {
	return position;
}
public void setPosition(Tb_opsition position) {
	this.position = position;
}
public int getEmployeeid() {
	return employeeid;
}
public void setEmployeeid(int employeeid) {
	this.employeeid = employeeid;
}
public String getEmployeename() {
	return employeename;
}
public void setEmployeename(String employeename) {
	this.employeename = employeename;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getDepartmentid() {
	return departmentid;
}
public void setDepartmentid(int departmentid) {
	this.departmentid = departmentid;
}
public int getPositionid() {
	return positionid;
}
public void setPositionid(int positionid) {
	this.positionid = positionid;
}



}
