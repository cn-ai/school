package com.accp.ssm_flight.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.ssm_flight.dao.IFlightDao;
import com.accp.ssm_flight.pojo.FlightInfo;

@Service
public class FlightBiz {
	@Autowired
	private IFlightDao dao;
	//查询航班
	public List<FlightInfo> querylist(String flightid){
		return dao.querylist(flightid);
	}
}
