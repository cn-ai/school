package com.accp.jboa.pojo;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

public class Tb_check {
private int	checkid;//审查记录编号
private int	bizid;//业务编号，关联请假表或报销主表
private int	typeid;//关联请假表或报销主表中type_id字段
@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
private Timestamp	checktime;//审查时间
private int	checkman;//审查人编号
private String checkManName;//审查人姓名

private int checkresult;//审查结果，外键，关联审查结果表
private String	checkcomment;//审查意见
private String checkResultName;//结果

public String getCheckManName() {
	return checkManName;
}
public void setCheckManName(String checkManName) {
	this.checkManName = checkManName;
}
public String getCheckResultName() {
	return checkResultName;
}
public void setCheckResultName(String checkResultName) {
	this.checkResultName = checkResultName;
}
public int getCheckid() {
	return checkid;
}
public void setCheckid(int checkid) {
	this.checkid = checkid;
}
public int getBizid() {
	return bizid;
}
public void setBizid(int bizid) {
	this.bizid = bizid;
}
public int getTypeid() {
	return typeid;
}
public void setTypeid(int typeid) {
	this.typeid = typeid;
}
public Timestamp getChecktime() {
	return checktime;
}
public void setChecktime(Timestamp checktime) {
	this.checktime = checktime;
}
public int getCheckman() {
	return checkman;
}
public void setCheckman(int checkman) {
	this.checkman = checkman;
}
public int getCheckresult() {
	return checkresult;
}
public void setCheckresult(int checkresult) {
	this.checkresult = checkresult;
}
public String getCheckcomment() {
	return checkcomment;
}
public void setCheckcomment(String checkcomment) {
	this.checkcomment = checkcomment;
}

}
