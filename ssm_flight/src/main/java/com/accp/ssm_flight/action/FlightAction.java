package com.accp.ssm_flight.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.ssm_flight.biz.FlightBiz;
import com.accp.ssm_flight.pojo.FlightInfo;

@Controller
@RequestMapping("/flight")
public class FlightAction {
	@Autowired
	private FlightBiz biz;

	// 查询
	@RequestMapping("list")
	public String querylist(Model mo, String flightid) {
		List<FlightInfo> list = biz.querylist(flightid);
		if (list.size() <= 0) {
			mo.addAttribute("msg", "没有找到该航班信息");
			return "index";
		} else {
			mo.addAttribute("flightid", flightid);
			mo.addAttribute("list", list);
			return "index";
		}
	}

	@RequestMapping("to")
	public String totest() {
		return "test";
	}
}
