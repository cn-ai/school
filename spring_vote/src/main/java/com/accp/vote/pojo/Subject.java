package com.accp.vote.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Subject {
private int id;
private String title;//投票标题
private int type;//投票类型 0.单选 1:多选
@JSONField(format="yyy-MM-dd HH:mm:ss")
private Date startDate;//开启投票时间
@JSONField(format="yyy-MM-dd HH:mm:ss")
private Date overDate;//结束投票时间;
private int join;//参与人数
private int way;//投票机制
private int uid;//用户编号
private int stoptype;//停止状态 0:未停止 1:停止

private List<Option> option=new ArrayList<Option>();

public List<Option> getOption() {
	return option;
}
public void setOption(List<Option> option) {
	this.option = option;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getOverDate() {
	return overDate;
}
public void setOverDate(Date overDate) {
	this.overDate = overDate;
}
public int getJoin() {
	return join;
}
public void setJoin(int join) {
	this.join = join;
}
public int getWay() {
	return way;
}
public void setWay(int way) {
	this.way = way;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getStoptype() {
	return stoptype;
}
public void setStoptype(int stoptype) {
	this.stoptype = stoptype;
}

}
