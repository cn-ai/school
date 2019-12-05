package com.accp.Vote.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* @ClassName: revert 
* @Description: 留言回复基本信息描述类
* @author 筠颜
* @date 2018年11月14日 下午3:20:51 
*
 */
public class vo_revert {
	private Integer id; //回复编号
	private Integer mid; //留言id
	private String content; //留言内容
	private Integer uid; //用户id
	@JSONField(format = "yyyy-MM-dd")
	private Date caretedate; //留言时间
	private String uname;//用户姓名
	
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
