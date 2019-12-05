package com.accp.Vote.biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.accp.Vote.dao.ISubjectDao;
import com.accp.Vote.dao.IUserDao;
import com.accp.Vote.pojo.item;
import com.accp.Vote.pojo.option;
import com.accp.Vote.pojo.subject;
import com.accp.Vote.pojo.user;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class VoteBiz {
	@Autowired
	private IUserDao udao;
	@Autowired
	private ISubjectDao sdao;
	/*
	 * add remove modify
	 */

	// 登陆
	public user queryUser(Object user) {
		user u = (com.accp.Vote.pojo.user) user;
		if (udao.queryUser(user) == null) {
			throw new RuntimeException("未找到用户名");
		} else if (udao.queryUser(user).getUpwd().equals(u.getUpwd()) == false) {
			throw new RuntimeException("密码错误！");
		}
		return udao.queryUser(user);
	}

	// 注册用户
	public void addUser(Object user) {
		udao.saveUser(user);
	}

	// 分页查询所有投票信息（标题和选项）
	public PageInfo<subject> querySubject(Object subject, Integer PageNum, String type) {
		PageHelper.startPage(PageNum, 3);
		return new PageInfo<subject>(sdao.querySubject(subject, type));
	}

	// 查询所有投票信息（标题和选项）
	public List<subject> querySubject(Object subject, String type) {
		return sdao.querySubject(subject, type);
	}

	// 停用投票
	public void modifySubjectType(Object subject) {
		sdao.updateSubjectType(subject);
	};

	// 新增投票
	public void addSubject(Object subject, List<option> options) {
		subject s = (com.accp.Vote.pojo.subject) subject;
		sdao.saveSubject(s);
		sdao.saveOptions(options, s.getId());
	}

	//修改投票信息
	public void modifySubject(Object subject, List<option> options) {
		subject s = (com.accp.Vote.pojo.subject) subject;
		sdao.updateSubject(s);
		sdao.deleteOptions(s.getId());
		sdao.saveOptions(options, s.getId());
	}

	// 用户参与投票
	public void addItems(List<item> Items, String way) {
		item s = new item();
		s.setSid(Items.get(0).getSid());
		s.setUid(Items.get(0).getUid());
		if (way.equals("0")) {
			if (sdao.queryWay(way, s) > 0) {
				throw new RuntimeException("只允许参与一次投票");
			}
		} else if (way.equals("1")) {
			if (sdao.queryWay(way, s) == 0) {
				throw new RuntimeException("一天只能投一次");
			}
		}
		sdao.saveItems(Items);
		sdao.updateJoin(Items.get(0).getSid());
	}

	// 每日定时结束时间已到期的投票
	public int modifyStoptype() {
		return sdao.updateStoptype();
	}
	//选项票数
	public List<option> queryItems(String sid) {
		Integer id = Integer.parseInt(sid);
		return sdao.queryItems(id);
	}
}
