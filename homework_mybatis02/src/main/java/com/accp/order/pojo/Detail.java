package com.accp.order.pojo;

public class Detail {
@Override
	public String toString() {
		return "Detail [billno=" + billno + ", lineid=" + lineid + ", goodsname=" + goodsname + ", goodsnum=" + goodsnum
				+ ", goodsprice=" + goodsprice + ", goodsmoneyamt=" + goodsmoneyamt + ", ispresent=" + ispresent + "]";
	}

private String billno;
private int lineid;
private String goodsname;
private int goodsnum;
private float goodsprice;
private float goodsmoneyamt;
private int ispresent;
private Bill bill;

public Bill getBill() {
	return bill;
}
public void setBill(Bill bill) {
	this.bill = bill;
}
public String getBillno() {
	return billno;
}
public void setBillno(String billno) {
	this.billno = billno;
}
public int getLineid() {
	return lineid;
}
public void setLineid(int lineid) {
	this.lineid = lineid;
}
public String getGoodsname() {
	return goodsname;
}
public void setGoodsname(String goodsname) {
	this.goodsname = goodsname;
}
public int getGoodsnum() {
	return goodsnum;
}
public void setGoodsnum(int goodsnum) {
	this.goodsnum = goodsnum;
}
public float getGoodsprice() {
	return goodsprice;
}
public void setGoodsprice(float goodsprice) {
	this.goodsprice = goodsprice;
}
public float getGoodsmoneyamt() {
	return goodsmoneyamt;
}
public void setGoodsmoneyamt(float goodsmoneyamt) {
	this.goodsmoneyamt = goodsmoneyamt;
}
public int getIspresent() {
	return ispresent;
}
public void setIspresent(int ispresent) {
	this.ispresent = ispresent;
}
public Detail( String goodsname, int goodsnum, float goodsprice, float goodsmoneyamt, int ispresent) {
	super();
	
	this.goodsname = goodsname;
	this.goodsnum = goodsnum;
	this.goodsprice = goodsprice;
	this.goodsmoneyamt = goodsmoneyamt;
	this.ispresent = ispresent;
}

public Detail() {
	// TODO Auto-generated constructor stub
}
}
