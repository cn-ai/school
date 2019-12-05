package com.accp.jboa.pojo;

import com.accp.jboa.vo.Base64ImageVo;

public class Reimburse_detail {
	private int id;
	private int mainid;//报销主表编号
	private float subtotal;//事项金额
	private String desc;//事项描述
	private String pictruename;//报销单图片名
	private String pictruepath;//报销单真实路径
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMainid() {
		return mainid;
	}
	public void setMainid(int mainid) {
		this.mainid = mainid;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPictruename() {
		return pictruename;
	}
	public void setPictruename(String pictruename) {
		this.pictruename = pictruename;
	}
	public String getPictruepath() {
		return pictruepath;
	}
	public void setPictruepath(String pictruepath) {
		this.pictruepath = pictruepath;
	}
	
}
