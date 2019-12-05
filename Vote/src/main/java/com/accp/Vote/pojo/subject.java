package com.accp.Vote.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* @ClassName: subject 
* @Description: 投票内容基本信息描述类
* @author 筠颜
* @date 2018年11月14日 下午3:14:08 
*
 */
public class subject {
	private Integer id; // 投票编号
	private String title; //投票标题
	private Integer type; //投票类型 0.单选 1:多选
	@JSONField(format = "yyyy-MM-dd")
	private Date startdate; //开启投票时间
	@JSONField(format = "yyyy-MM-dd")
	private Date overdate; //结束投票时间
	private Integer join; //参与人数
	private Integer way; //投票机制
	private Integer uid; //用户编号
	private Integer stoptype; //停止状态 0:未停止 1:停止
	
	private List<option> option = new ArrayList<option>();  //投票选项
	
	private List<vo_message> messages = new ArrayList<vo_message>();  //留言
	
	
	public List<vo_message> getMessages() {
		return messages;
	}
	public void setMessages(List<vo_message> messages) {
		this.messages = messages;
	}
	public List<option> getOption() {
		return option;
	}
	public void setOption(List<option> option) {
		this.option = option;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getOverdate() {
		return overdate;
	}
	public void setOverdate(Date overdate) {
		this.overdate = overdate;
	}
	public Integer getJoin() {
		return join;
	}
	public void setJoin(Integer join) {
		this.join = join;
	}
	public Integer getWay() {
		return way;
	}
	public void setWay(Integer way) {
		this.way = way;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getStoptype() {
		return stoptype;
	}
	public void setStoptype(Integer stoptype) {
		this.stoptype = stoptype;
	}
	public subject(String title, Integer type, Date startdate, Date overdate, Integer join, Integer way, Integer uid,
			Integer stoptype) {
		super();
		this.title = title;
		this.type = type;
		this.startdate = startdate;
		this.overdate = overdate;
		this.join = join;
		this.way = way;
		this.uid = uid;
		this.stoptype = stoptype;
	}
	public subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
