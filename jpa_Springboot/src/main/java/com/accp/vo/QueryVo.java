package com.accp.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
public class QueryVo {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="districtid")
	private int districtid;	
	@Column(name="monitortime")
	@JSONField(format="yyyy-MM-dd")
	private Date monitortime;
	@Column(name="pm10")
	private int pm10;
	@Column(name="pm25")
	private int pm25;
	@Column(name="monitoringstation")
	private String monitoringstation;
	@Column(name="lastmodifytime")
	@JSONField(format="yyyy-MM-dd")
	private Date lastmodifytime;
	public int getDistrictid() {
		return districtid;
	}
	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}
	public Date getLastmodifytime() {
		return lastmodifytime;
	}
	public void setLastmodifytime(Date lastmodifytime) {
		this.lastmodifytime = lastmodifytime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getMonitortime() {
		return monitortime;
	}
	public void setMonitortime(Date monitortime) {
		this.monitortime = monitortime;
	}
	public int getPm10() {
		return pm10;
	}
	public void setPm10(int pm10) {
		this.pm10 = pm10;
	}
	public int getPm25() {
		return pm25;
	}
	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}
	public String getMonitoringstation() {
		return monitoringstation;
	}
	public void setMonitoringstation(String monitoringstation) {
		this.monitoringstation = monitoringstation;
	}

	

	
}
