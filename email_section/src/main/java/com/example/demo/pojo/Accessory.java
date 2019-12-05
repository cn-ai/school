package com.example.demo.pojo;

public class Accessory {
private int aid;
private int inid;//发件人邮箱
private String url;//附件地址
private String name;//附件名称
private float size;//附件大小


public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public int getInid() {
	return inid;
}
public void setInid(int inid) {
	this.inid = inid;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getSize() {
	return size;
}
public void setSize(float size) {
	this.size = size;
}

}
