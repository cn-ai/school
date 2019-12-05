package com.example.demo.pojo;

import java.sql.Timestamp;

public class Inbox {
	private int inid;
	private String title;//标题
	private String content;//内容
	private int inUid;//发件人编号
	private String inName;//发件人名称
	private String inEmail;//发件人邮箱
	private int type;//0 普通  1紧急  2回执
	private int sate;//0 草稿 1.定时发送 2已发送 3.未发送'
	private Timestamp time;//发件时间
	private int typeSate;//回执状态 0未回执 1已回执
	private String outUemail;//收件人名称
	private String outUname;//收件人名称
	private String outCopyUemail;//抄送人邮箱
	private String outCopyUname;//抄送人姓名
	private String outSecretUemail;//秘送人邮箱
	private String outSecretUname;//密送人名称
	
	public int getInid() {
		return inid;
	}
	public void setInid(int inid) {
		this.inid = inid;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSate() {
		return sate;
	}
	public void setSate(int sate) {
		this.sate = sate;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getTypeSate() {
		return typeSate;
	}
	public void setTypeSate(int typeSate) {
		this.typeSate = typeSate;
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
	
}
