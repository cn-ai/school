package com.accp.Vote.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* @ClassName: revert 
* @Description: ���Իظ�������Ϣ������
* @author ����
* @date 2018��11��14�� ����3:20:51 
*
 */
public class vo_revert {
	private Integer id; //�ظ����
	private Integer mid; //����id
	private String content; //��������
	private Integer uid; //�û�id
	@JSONField(format = "yyyy-MM-dd")
	private Date caretedate; //����ʱ��
	private String uname;//�û�����
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Date getCaretedate() {
		return caretedate;
	}
	public void setCaretedate(Date caretedate) {
		this.caretedate = caretedate;
	}
	public vo_revert(Integer id, Integer mid, String content, Integer uid, Date caretedate, String uname) {
		super();
		this.id = id;
		this.mid = mid;
		this.content = content;
		this.uid = uid;
		this.caretedate = caretedate;
		this.uname = uname;
	}
	public vo_revert() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
