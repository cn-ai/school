package com.accp.ssm_02.pojo;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

public class T_paper {
	private int pid;
	private String title;// 论文题目
	private int type;// 论文类型
	private String paperSummary;// 论文摘要
	private String paperPath;// 路径
	private String createdBy;// 创建人
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp creationDate;// 创建时间
	private String modifyBy;// 修改人
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Timestamp modifyDate;// 修改时间
	private String fileName;// 论文文件名

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPaperSummary() {
		return paperSummary;
	}

	public void setPaperSummary(String paperSummary) {
		this.paperSummary = paperSummary;
	}

	public String getPaperPath() {
		return paperPath;
	}

	public void setPaperPath(String paperPath) {
		this.paperPath = paperPath;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
