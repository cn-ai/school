package com.accp.airinInfo.pojo;


public class AirinInfo {
public AirinInfo(int id, int flight_number, String destination, String flight_date) {
		super();
		this.id = id;
		this.flight_number = flight_number;
		this.destination = destination;
		this.flight_date = flight_date;
	}
private int id;
private int flight_number;
private String destination;
private String flight_date;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getFlight_number() {
	return flight_number;
}
public void setFlight_number(int flight_number) {
	this.flight_number = flight_number;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public String getFlight_date() {
	return flight_date;
}
public void setFlight_date(String flight_date) {
	this.flight_date = flight_date;
}
public AirinInfo() {
	// TODO Auto-generated constructor stub
}

}
