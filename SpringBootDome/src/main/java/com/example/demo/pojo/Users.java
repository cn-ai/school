package com.example.demo.pojo;

public class Users {
private int id;
private String name;
private String love;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLove() {
	return love;
}
public void setLove(String love) {
	this.love = love;
}
public Users(int id, String name, String love) {
	super();
	this.id = id;
	this.name = name;
	this.love = love;
}
public Users() {
	// TODO Auto-generated constructor stub
}
}
