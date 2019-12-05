package com.accp.jboa.pojo;

import java.sql.Timestamp;

public class Tb_message {
private int	message_id;
private int	addresser_id;//发件用户id
private String addresserName;//发件人名称

private int	addressees_id;//收件人id
private String addresseesName;//收件人名称
private int	message_sta;//0未处理 1已处理 2未阅读 3已阅读',
private int type_id;//消息类别 ：1.请假 2.报销 
private Timestamp createDate;//发送请求的时间
private String context;//消息内容
private int biz_id;//业务编号
public int getMessage_id() {
	return message_id;
}
public void setMessage_id(int message_id) {
	this.message_id = message_id;
}
public int getAddresser_id() {
	return addresser_id;
}
public void setAddresser_id(int addresser_id) {
	this.addresser_id = addresser_id;
}
public int getAddressees_id() {
	return addressees_id;
}
public void setAddressees_id(int addressees_id) {
	this.addressees_id = addressees_id;
}
public String getAddresseesName() {
	return addresseesName;
}
public void setAddresseesName(String addresseesName) {
	this.addresseesName = addresseesName;
}
public int getMessage_sta() {
	return message_sta;
}
public void setMessage_sta(int message_sta) {
	this.message_sta = message_sta;
}
public Timestamp getCreateDate() {
	return createDate;
}
public void setCreateDate(Timestamp createDate) {
	this.createDate = createDate;
}
public String getContext() {
	return context;
}
public void setContext(String context) {
	this.context = context;
}
public int getBiz_id() {
	return biz_id;
}
public void setBiz_id(int biz_id) {
	this.biz_id = biz_id;
}
public void setAddresserName(String addresserName) {
	this.addresserName = addresserName;
}
public String getAddresserName() {
	return addresserName;
}
public int getType_id() {
	return type_id;
}
public void setType_id(int type_id) {
	this.type_id = type_id;
}


}
