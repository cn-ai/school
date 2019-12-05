package com.accp.jboa.vo;

public class EmployeeVo {

	private Integer employeeId;
	private String employeeName;
	private String positionName;
	private Integer positionId;
	private String departmentName;
	private Integer departmentId;
	private String name1;
	private Integer name1Id;
	
	@Override
	public String toString() {
		return "EmployeeVo [employeeId=" + employeeId + ", employeeName=" + employeeName + ", positionName="
				+ positionName + ", positionId=" + positionId + ", departmentName=" + departmentName + ", departmentId="
				+ departmentId + ", name1=" + name1 + ", name1Id=" + name1Id + "]";
	}
	public EmployeeVo() {
		super();
	}
	public EmployeeVo(Integer employeeId, String employeeName, String positionName, Integer positionId,
			String departmentName, Integer departmentId, String name1, Integer name1Id) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.positionName = positionName;
		this.positionId = positionId;
		this.departmentName = departmentName;
		this.departmentId = departmentId;
		this.name1 = name1;
		this.name1Id = name1Id;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public Integer getName1Id() {
		return name1Id;
	}
	public void setName1Id(Integer name1Id) {
		this.name1Id = name1Id;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	
}
