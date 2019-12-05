package com.accp.ssm_flight.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.ssm_flight.pojo.FlightInfo;

public interface IFlightDao {
//查询航班
	List<FlightInfo> querylist(@Param("flightid")String flightid);
}
