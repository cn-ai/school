package com.accp.jboa.vo;

import java.sql.Timestamp;

import com.accp.jboa.pojo.Employee;
import com.accp.jboa.pojo.Tb_reimburse;
import com.accp.jboa.pojo.Tb_status;

public class ReimburseVo {
	private int employeeid;
	private String employeename;//用户姓名
	private String password;//密码

	private int positionid;//职位编号，外键
	private String status;//用户状态
	private int pid;//上一级

	private int reimburseid;
	private int typeid;
	private int createman;//报销人编号
	private Timestamp createtime;//创建时间
	private int departmentid;//部门编号
	private int nextdealman;//下个处理人
	private String event;//报销事由
	private float totalcount;//报销总金额
	private String nextpreson;
	
	
	
//查询详情
	private int id;
	private int mainid;//报销主表编号
	private float subtotal;//事项金额
	private String desc;//事项描述
	private String pictruename;//报销单图片名
	private String pictruepath;//报销单真实路径
	
//审查
	private int	checkid;//审查记录编号
	private int	bizid;//业务编号，关联请假表或报销主表
	private int	typeid_sc;//关联请假表或报销主表中type_id字段
	private Timestamp	checktime;//审查时间
	private int	checkman;//审查人编号
	private int checkresult;//审查结果，外键，关联审查结果表
	private String	checkcomment;//审查意见
//审查结果
	private int	resultid;
	private String	resultname;
	
	
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
	public int getCheckid() {
		return checkid;
	}
	public void setCheckid(int checkid) {
		this.checkid = checkid;
	}
	public int getBizid() {
		return bizid;
	}
	public void setBizid(int bizid) {
		this.bizid = bizid;
	}
	public int getTypeid_sc() {
		return typeid_sc;
	}
	public void setTypeid_sc(int typeid_sc) {
		this.typeid_sc = typeid_sc;
	}
	public Timestamp getChecktime() {
		return checktime;
	}
	public void setChecktime(Timestamp checktime) {
		this.checktime = checktime;
	}
	public int getCheckman() {
		return checkman;
	}
	public void setCheckman(int checkman) {
		this.checkman = checkman;
	}
	public int getCheckresult() {
		return checkresult;
	}
	public void setCheckresult(int checkresult) {
		this.checkresult = checkresult;
	}
	public String getCheckcomment() {
		return checkcomment;
	}
	public void setCheckcomment(String checkcomment) {
		this.checkcomment = checkcomment;
	}
	public int getResultid() {
		return resultid;
	}
	public void setResultid(int resultid) {
		this.resultid = resultid;
	}
	public String getResultname() {
		return resultname;
	}
	public void setResultname(String resultname) {
		this.resultname = resultname;
	}
	public String getNextpreson() {
		return nextpreson;
	}
	public void setNextpreson(String nextpreson) {
		this.nextpreson = nextpreson;
	}
	private int statusid;
	private String statusname;
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPositionid() {
		return positionid;
	}
	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getReimburseid() {
		return reimburseid;
	}
	public void setReimburseid(int reimburseid) {
		this.reimburseid = reimburseid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getCreateman() {
		return createman;
	}
	public void setCreateman(int createman) {
		this.createman = createman;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public int getNextdealman() {
		return nextdealman;
	}
	public void setNextdealman(int nextdealman) {
		this.nextdealman = nextdealman;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public float getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(float totalcount) {
		this.totalcount = totalcount;
	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public String getStatusname() {
		return statusname;
	}
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
	
	
}
