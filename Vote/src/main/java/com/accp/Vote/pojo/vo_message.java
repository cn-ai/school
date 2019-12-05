package com.accp.Vote.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: message 
* @Description: ���Ի�����Ϣ������
* @author ����
* @date 2018��11��14�� ����3:15:01 
*
 */
public class vo_message {
	private Integer id; //���Ա��
	private Integer sid;//ͶƱ����id
	private String content;//��������
	private Integer uid;//�û�id
	private Integer uname;//�û�����
	@JSONField(format = "yyyy-MM-dd")
	private Date caretedate;//����ʱ��
	
	private List<vo_revert> revert = new ArrayList<vo_revert>();
	
	
	public Integer getUname() {
		return uname;
	}
	public void setUname(Integer uname) {
		this.uname = uname;
	}
	public List<vo_revert> getRevert() {
		return revert;
	}
	public void setRevert(List<vo_revert> revert) {
		this.revert = revert;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
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
	public vo_message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public vo_message(Integer id, Integer sid, String content, Integer uid, Date caretedate) {
		super();
		this.id = id;
		this.sid = sid;
		this.content = content;
		this.uid = uid;
		this.caretedate = caretedate;
	}
	
	 
}
