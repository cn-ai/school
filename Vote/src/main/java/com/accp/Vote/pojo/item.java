package com.accp.Vote.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: item 
* @Description: ѡ�������Ϣ������
* @author ����
* @date 2018��11��14�� ����3:17:18 
*
 */
public class item {
	private Integer id;//ѡ��id
	private Integer sid;//ͶƱ����id
	private Integer oid;//ͶƱѡ��id
	private Integer uid;//�û�id
	@JSONField(format = "yyyy-MM-dd")
	private Date caretedate;//ͶƱʱ��
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
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
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
	public item(Integer id, Integer sid, Integer oid, Integer uid, Date caretedate) {
		super();
		this.id = id;
		this.sid = sid;
		this.oid = oid;
		this.uid = uid;
		this.caretedate = caretedate;
	}
	public item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
