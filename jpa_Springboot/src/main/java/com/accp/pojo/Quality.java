package com.accp.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name="air_quality_index")
public class Quality implements Serializable{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="districtid")
	private int districtid;
	@Column(name="monitortime")
	@JSONField(format="yyyy-MM-dd")
	private String monitortime;
	@Column(name="pm10")
	private int pm10;
	@Column(name="pm25")
	private int pm25;
	@Column(name="monitoringstation")
	private String monitoringstation;
	@Column(name="lastmodifytime")
	@JSONField(format="yyyy-MM-dd")
	private Date lastmodifytime;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Quality [id=" + id + ", districtid=" + districtid + ", monitortime=" + monitortime + ", pm10=" + pm10
				+ ", pm25=" + pm25 + ", monitoringstation=" + monitoringstation + ", lastmodifytime=" + lastmodifytime
				+ "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDistrictid() {
		return districtid;
	}
	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}
	public String getMonitortime() {
		return monitortime;
	}
	public void setMonitortime(String monitortime) {
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
	public Date getLastmodifytime() {
		return lastmodifytime;
	}
	public void setLastmodifytime(Date lastmodifytime) {
		this.lastmodifytime = lastmodifytime;
	}

}
