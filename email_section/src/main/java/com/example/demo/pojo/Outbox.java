package com.example.demo.pojo;

import java.sql.Timestamp;

public class Outbox {
private int outid;
private String title;//标题
private String content;//内容
private int inUid;//发件人编号
private String inName;//发件人名称
private String inEmail;//发件人邮箱
private Timestamp time;//发件时间
private String outUemail;//收件人邮箱
private String outUname;//收件人姓名
private String outCopyUemail;//抄送人邮箱
private String outCopyUname;//抄送人姓名
private String outSecretUemail;//密送人邮箱
private String outSecretUname;//秘送人姓名
private int outState;//收件状态 0.普通 1.抄送 2密送
private int typeState;//回执状态: 0不回执 1未回执 2已回执
private int state;//邮件状态 0.已读 1.未读 2.红旗 3.回收站
private int type;//邮箱类型 0普通 1紧急 2回执
private int accessoryId;//附件编号
private int manner;//接受方式 0普通 1抄送 2密送

public int getOutid() {
	return outid;
}
public void setOutid(int outid) {
	this.outid = outid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getInUid() {
	return inUid;
}
public void setInUid(int inUid) {
	this.inUid = inUid;
}
public String getInName() {
	return inName;
}
public void setInName(String inName) {
	this.inName = inName;
}
public String getInEmail() {
	return inEmail;
}
public void setInEmail(String inEmail) {
	this.inEmail = inEmail;
}
public Timestamp getTime() {
	return time;
}
public void setTime(Timestamp time) {
	this.time = time;
}
public String getOutUemail() {
	return outUemail;
}
public void setOutUemail(String outUemail) {
	this.outUemail = outUemail;
}
public String getOutUname() {
	return outUname;
}
public void setOutUname(String outUname) {
	this.outUname = outUname;
}
public String getOutCopyUemail() {
	return outCopyUemail;
}
public void setOutCopyUemail(String outCopyUemail) {
	this.outCopyUemail = outCopyUemail;
}
public String getOutCopyUname() {
	return outCopyUname;
}
public void setOutCopyUname(String outCopyUname) {
	this.outCopyUname = outCopyUname;
}
public String getOutSecretUemail() {
	return outSecretUemail;
}
public void setOutSecretUemail(String outSecretUemail) {
	this.outSecretUemail = outSecretUemail;
}
public String getOutSecretUname() {
	return outSecretUname;
}
public void setOutSecretUname(String outSecretUname) {
	this.outSecretUname = outSecretUname;
}
public int getOutState() {
	return outState;
}
public void setOutState(int outState) {
	this.outState = outState;
}
public int getTypeState() {
	return typeState;
}
public void setTypeState(int typeState) {
	this.typeState = typeState;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getAccessoryId() {
	return accessoryId;
}
public void setAccessoryId(int accessoryId) {
	this.accessoryId = accessoryId;
}
public int getManner() {
	return manner;
}
public void setManner(int manner) {
	this.manner = manner;
}

}
