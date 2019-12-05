package com.accp.order.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill {
private String billno;
private Date billdate;
private String suppliername;
private String supplieraddress;
private String department;
private String warehouse;
private String buyer;
private String executor;
private List<Detail> detail=new ArrayList<>();

public List<Detail> getDetail() {
	return detail;
}
public void setDetail(List<Detail> detail) {
	this.detail = detail;
}
public String getBillno() {
	return billno;
}
@Override
public String toString() {
	return "Bill [billno=" + billno + ", billdate=" + billdate + ", suppliername=" + suppliername + ", supplieraddress="
			+ supplieraddress + ", department=" + department + ", warehouse=" + warehouse + ", buyer=" + buyer
			+ ", executor=" + executor + "]";
}
public void setBillno(String billno) {
	this.billno = billno;
}
public Date getBilldate() {
	return billdate;
}
public void setBilldate(Date billdate) {
	this.billdate = billdate;
}
public String getSuppliername() {
	return suppliername;
}
public void setSuppliername(String suppliername) {
	this.suppliername = suppliername;
}
public String getSupplieraddress() {
	return supplieraddress;
}
public void setSupplieraddress(String supplieraddress) {
	this.supplieraddress = supplieraddress;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getWarehouse() {
	return warehouse;
}
public void setWarehouse(String warehouse) {
	this.warehouse = warehouse;
}
public String getBuyer() {
	return buyer;
}
public void setBuyer(String buyer) {
	this.buyer = buyer;
}
public String getExecutor() {
	return executor;
}
public void setExecutor(String executor) {
	this.executor = executor;
}
public Bill() {
	// TODO Auto-generated constructor stub
}
public Bill(String billno, Date billdate, String suppliername, String supplieraddress, String department,
		String warehouse, String buyer, String executor) {
	super();
	this.billno = billno;
	this.billdate = billdate;
	this.suppliername = suppliername;
	this.supplieraddress = supplieraddress;
	this.department = department;
	this.warehouse = warehouse;
	this.buyer = buyer;
	this.executor = executor;
}
}
