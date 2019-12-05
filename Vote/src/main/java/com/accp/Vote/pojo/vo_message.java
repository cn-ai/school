package com.accp.Vote.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: message 
* @Description: 留言基本信息描述类
* @author 筠颜
* @date 2018年11月14日 下午3:15:01 
*
 */
public class vo_message {
	private Integer id; //留言编号
	private Integer sid;//投票内容id
	private String content;//留言内容
	private Integer uid;//用户id
	private Integer uname;//用户名称
	@JSONField(format = "yyyy-MM-dd")
	private Date caretedate;//留言时间
	
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
