package com.accp.jboa.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Tb_reimburseVo {

	private Integer reimburseId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime;
	private String name1;
	private Integer name1id;
	private String positionName;
	private Integer positionId;
	private String departmentName;
	private String name2;
	private String name2id;
	private float totalCount;
	private String statusName;
	private Integer statusId;
	private String event;
	
	
	
	public Tb_reimburseVo(Integer reimburseId, Date createTime, String name1, Integer name1id, String positionName,
			Integer positionId, String departmentName, String name2, String name2id, float totalCount,
			String statusName, Integer statusId, String event) {
		super();
		this.reimburseId = reimburseId;
		this.createTime = createTime;
		this.name1 = name1;
		this.name1id = name1id;
		this.positionName = positionName;
		this.positionId = positionId;
		this.departmentName = departmentName;
		this.name2 = name2;
		this.name2id = name2id;
		this.totalCount = totalCount;
		this.statusName = statusName;
		this.statusId = statusId;
		this.event = event;
	}
	
	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Integer getName1id() {
		return name1id;
	}
	public void setName1id(Integer name1id) {
		this.name1id = name1id;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getName2id() {
		return name2id;
	}
	public void setName2id(String name2id) {
		this.name2id = name2id;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Tb_reimburseVo() {
		super();
	}
	public Integer getReimburseId() {
		return reimburseId;
	}
	public void setReimburseId(Integer reimburseId) {
		this.reimburseId = reimburseId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public float getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(float totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "Tb_reimburseVo [reimburseId=" + reimburseId + ", createTime=" + createTime + ", name1=" + name1
				+ ", name1id=" + name1id + ", positionName=" + positionName + ", positionId=" + positionId
				+ ", departmentName=" + departmentName + ", name2=" + name2 + ", name2id=" + name2id + ", totalCount="
				+ totalCount + ", statusName=" + statusName + ", statusId=" + statusId + ", event=" + event + "]";
	}
	
}
