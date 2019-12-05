package com.accp.Vote.pojo;

/**
 * 
* @ClassName: user 
* @Description: 用户基本信息描述表
* @author 筠颜
* @date 2018年11月14日 下午2:57:42 
*
 */
public class user {
	private Integer uid;//用户编号
	private String uname;//用户账号
	private String upwd;//用户密码
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public user(Integer uid, String uname, String upwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
