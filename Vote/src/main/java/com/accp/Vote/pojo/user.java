package com.accp.Vote.pojo;

/**
 * 
* @ClassName: user 
* @Description: �û�������Ϣ������
* @author ����
* @date 2018��11��14�� ����2:57:42 
*
 */
public class user {
	private Integer uid;//�û����
	private String uname;//�û��˺�
	private String upwd;//�û�����
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
