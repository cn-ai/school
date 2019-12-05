package com.accp.entity;

import java.util.Date;

public class Message {
private int id;
private String userName;
private String title;
private String contents;
private Date createTime;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContents() {
	return contents;
}
public void setContents(String contents) {
	this.contents = contents;
}

public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public Message() {
	// TODO Auto-generated constructor stub
}
public Message(String userName, String title, String contents, Date createTime) {
	super();
	this.userName = userName;
	this.title = title;
	this.contents = contents;
	this.createTime = createTime;
}
@Override
public String toString() {
	return "Massage [id=" + id + ", userName=" + userName + ", title=" + title + ", contents=" + contents
			+ ", createTime=" + createTime + "]";
}
}
