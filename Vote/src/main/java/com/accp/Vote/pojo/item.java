package com.accp.Vote.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: item 
* @Description: 选项基本信息描述类
* @author 筠颜
* @date 2018年11月14日 下午3:17:18 
*
 */
public class item {
	private Integer id;//选项id
	private Integer sid;//投票内容id
	private Integer oid;//投票选项id
	private Integer uid;//用户id
	@JSONField(format = "yyyy-MM-dd")
	private Date caretedate;//投票时间
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
