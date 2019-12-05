package com.accp.Vote.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* @ClassName: subject 
* @Description: ͶƱ���ݻ�����Ϣ������
* @author ����
* @date 2018��11��14�� ����3:14:08 
*
 */
public class subject {
	private Integer id; // ͶƱ���
	private String title; //ͶƱ����
	private Integer type; //ͶƱ���� 0.��ѡ 1:��ѡ
	@JSONField(format = "yyyy-MM-dd")
	private Date startdate; //����ͶƱʱ��
	@JSONField(format = "yyyy-MM-dd")
	private Date overdate; //����ͶƱʱ��
	private Integer join; //��������
	private Integer way; //ͶƱ����
	private Integer uid; //�û����
	private Integer stoptype; //ֹͣ״̬ 0:δֹͣ 1:ֹͣ
	
	private List<option> option = new ArrayList<option>();  //ͶƱѡ��
	
	private List<vo_message> messages = new ArrayList<vo_message>();  //����
	
	
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
