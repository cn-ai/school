package com.accp.jboa.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Tb_reimburse {
private int reimburseid;
private int typeid;
private int createman;//报销人编号
private Timestamp createtime;//创建时间
private int departmentid;//部门编号
private int nextdealman;//下个处理人
private String event;//报销事由
private float totalcount;//报销总金额
private int statusid;//状态，外键，关联状态表
private String nextpreson;//

public String getNextpreson() {
	return nextpreson;
}
public void setNextpreson(String nextpreson) {
	this.nextpreson = nextpreson;
}
//详情
private List<Reimburse_detail> details=new ArrayList<Reimburse_detail>();

public List<Reimburse_detail> getDetails() {
	return details;
}
public void setDetails(List<Reimburse_detail> details) {
	this.details = details;
}
public int getReimburseid() {
	return reimburseid;
}
public void setReimburseid(int reimburseid) {
	this.reimburseid = reimburseid;
}
public int getTypeid() {
	return typeid;
}
public void setTypeid(int typeid) {
	this.typeid = typeid;
}
public int getCreateman() {
	return createman;
}
public void setCreateman(int createman) {
	this.createman = createman;
}
public Timestamp getCreatetime() {
	return createtime;
}
public void setCreatetime(Timestamp createtime) {
	this.createtime = createtime;
}
public int getDepartmentid() {
	return departmentid;
}
public void setDepartmentid(int departmentid) {
	this.departmentid = departmentid;
}
public int getNextdealman() {
	return nextdealman;
}
public void setNextdealman(int nextdealman) {
	this.nextdealman = nextdealman;
}
public String getEvent() {
	return event;
}
public void setEvent(String event) {
	this.event = event;
}
public float getTotalcount() {
	return totalcount;
}
public void setTotalcount(float totalcount) {
	this.totalcount = totalcount;
}
public int getStatusid() {
	return statusid;
}
public void setStatusid(int statusid) {
	this.statusid = statusid;
}


}
