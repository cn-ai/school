package com.accp.vote.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Item {
private int item;
private int sid;//投票内容id
private int oid;//投票选项id
private int uid;//用户id
@JSONField(format="yyyy-MM-dd HH:mm:ss")
private Date createdate;//投票时间
public int getItem() {
	return item;
}
public void setItem(int item) {
	this.item = item;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public Date getCreatedate() {
	return createdate;
}
public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}
public Item() {
	// TODO Auto-generated constructor stub
}
}
