package com.accp.springmvc.pojo;

import java.util.List;

public class User {
private String uname;
private String city;
private List<String> language;
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public List<String> getLanguage() {
	return language;
}
public void setLanguage(List<String> language) {
	this.language = language;
}


}
