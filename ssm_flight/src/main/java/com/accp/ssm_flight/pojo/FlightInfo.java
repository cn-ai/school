package com.accp.ssm_flight.pojo;

import java.util.Date;

public class FlightInfo {

	private int id;
	private String flightid;
	private String company;
	private String leaveAirport;
	private String arriveAirport;
	private Date leavetime;
	private Date arrivetime;
	private String airplane;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightid() {
		return flightid;
	}

	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLeaveAirport() {
		return leaveAirport;
	}

	public void setLeaveAirport(String leaveAirport) {
		this.leaveAirport = leaveAirport;
	}

	public String getArriveAirport() {
		return arriveAirport;
	}

	public void setArriveAirport(String arriveAirport) {
		this.arriveAirport = arriveAirport;
	}

	public Date getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(Date leavetime) {
		this.leavetime = leavetime;
	}

	public Date getArrivetime() {
		return arrivetime;
	}

	public void setArrivetime(Date arrivetime) {
		this.arrivetime = arrivetime;
	}

	public String getAirplane() {
		return airplane;
	}

	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}

	@Override
	public String toString() {
		return "FlightInfo [id=" + id + ", flightid=" + flightid + ", company=" + company + ", leaveAirport="
				+ leaveAirport + ", arriveAirport=" + arriveAirport + ", leavetime=" + leavetime + ", arrivetime="
				+ arrivetime + ", airplane=" + airplane + "]";
	}
}
