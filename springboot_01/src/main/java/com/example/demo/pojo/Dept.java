package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.List;

public class Dept {
private int did;
private String dname;
private String daddress;

private List<Emp> list=new ArrayList<Emp>();


public List<Emp> getList() {
	return list;
}
public void setList(List<Emp> list) {
	this.list = list;
}
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public String getDaddress() {
	return daddress;
}
public void setDaddress(String daddress) {
	this.daddress = daddress;
}

}
