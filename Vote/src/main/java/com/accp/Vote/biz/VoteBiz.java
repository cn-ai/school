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

	// ��½
	public user queryUser(Object user) {
		user u = (com.accp.Vote.pojo.user) user;
		if (udao.queryUser(user) == null) {
			throw new RuntimeException("δ�ҵ��û���");
		} else if (udao.queryUser(user).getUpwd().equals(u.getUpwd()) == false) {
			throw new RuntimeException("�������");
		}
		return udao.queryUser(user);
	}

	// ע���û�
	public void addUser(Object user) {
		udao.saveUser(user);
	}

	// ��ҳ��ѯ����ͶƱ��Ϣ�������ѡ�
	public PageInfo<subject> querySubject(Object subject, Integer PageNum, String type) {
		PageHelper.startPage(PageNum, 3);
		return new PageInfo<subject>(sdao.querySubject(subject, type));
	}

	// ��ѯ����ͶƱ��Ϣ�������ѡ�
	public List<subject> querySubject(Object subject, String type) {
		return sdao.querySubject(subject, type);
	}

	// ͣ��ͶƱ
	public void modifySubjectType(Object subject) {
		sdao.updateSubjectType(subject);
	};

	// ����ͶƱ
	public void addSubject(Object subject, List<option> options) {
		subject s = (com.accp.Vote.pojo.subject) subject;
		sdao.saveSubject(s);
		sdao.saveOptions(options, s.getId());
	}

	//�޸�ͶƱ��Ϣ
	public void modifySubject(Object subject, List<option> options) {
		subject s = (com.accp.Vote.pojo.subject) subject;
		sdao.updateSubject(s);
		sdao.deleteOptions(s.getId());
		sdao.saveOptions(options, s.getId());
	}

	// �û�����ͶƱ
	public void addItems(List<item> Items, String way) {
		item s = new item();
		s.setSid(Items.get(0).getSid());
		s.setUid(Items.get(0).getUid());
		if (way.equals("0")) {
			if (sdao.queryWay(way, s) > 0) {
				throw new RuntimeException("ֻ�������һ��ͶƱ");
			}
		} else if (way.equals("1")) {
			if (sdao.queryWay(way, s) == 0) {
				throw new RuntimeException("һ��ֻ��Ͷһ��");
			}
		}
		sdao.saveItems(Items);
		sdao.updateJoin(Items.get(0).getSid());
	}

	// ÿ�ն�ʱ����ʱ���ѵ��ڵ�ͶƱ
	public int modifyStoptype() {
		return sdao.updateStoptype();
	}
	//ѡ��Ʊ��
	public List<option> queryItems(String sid) {
		Integer id = Integer.parseInt(sid);
		return sdao.queryItems(id);
	}
}
