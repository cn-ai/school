package com.accp.jboa.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Tb_leave {
private int leaveid;
private int typeid;//
private int createman;//请假人编号
private String createManName;//请假人姓名
private int  departmentid;//请假人部门编号
private String departmentName;//请假人部门名称
public String getCreateManName() {
	return createManName;
}
public void setCreateManName(String createManName) {
	this.createManName = createManName;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
private Timestamp createtime;//创建时间

private Timestamp starttime;//请假开始时间

private Timestamp endtime;//请假结束时间
private int nextdealman;//下个处理人，外键
private String nextdealmanname;//处理人

private String event;//请假事由
private int totalcount;//请假总天数
private int statusid;//状态
private String statusName;//状态名称

public String getNextdealmanname() {
	return nextdealmanname;
}
public void setNextdealmanname(String nextdealmanname) {
	this.nextdealmanname = nextdealmanname;
}
public String getStatusName() {
	return statusName;
}
public void setStatusName(String statusName) {
	this.statusName = statusName;
}
private List<Tb_check> check=new ArrayList<Tb_check>();//多条审核记录

public List<Tb_check> getCheck() {
	return check;
}
public void setCheck(List<Tb_check> check) {
	this.check = check;
}
public int getLeaveid() {
	return leaveid;
}
public void setLeaveid(int leaveid) {
	this.leaveid = leaveid;
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
public int getDepartmentid() {
	return departmentid;
}
public void setDepartmentid(int departmentid) {
	this.departmentid = departmentid;
}
public Timestamp getCreatetime() {
	return createtime;
}
public void setCreatetime(Timestamp createtime) {
	this.createtime = createtime;
}
public Timestamp getStarttime() {
	return starttime;
}
public void setStarttime(Timestamp starttime) {
	this.starttime = starttime;
}
public Timestamp getEndtime() {
	return endtime;
}
public void setEndtime(Timestamp endtime) {
	this.endtime = endtime;
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
public int getTotalcount() {
	return totalcount;
}
public void setTotalcount(int totalcount) {
	this.totalcount = totalcount;
}
public int getStatusid() {
	return statusid;
}
public void setStatusid(int statusid) {
	this.statusid = statusid;
}

}
