package com.accp.Vote.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.accp.Vote.biz.VoteBiz;
import com.accp.Vote.pojo.item;
import com.accp.Vote.pojo.option;
import com.accp.Vote.pojo.subject;
import com.accp.Vote.pojo.user;
import com.accp.Vote.util.SpringBeanUtil;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class VoteAction
 */
public class VoteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoteBiz biz = SpringBeanUtil.getBeanByName("biz");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoteAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String m = request.getParameter("m");
		try {
			Method mdo = this.getClass().getDeclaredMethod(m, HttpServletRequest.class, HttpServletResponse.class);
			mdo.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 登录
	protected void Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String u = request.getParameter("user");
		user pojo = JSON.parseObject(u, user.class);
		if(pojo.getUpwd()!=null) {
			pojo.setUpwd(DigestUtils.md5Hex(pojo.getUpwd()));
		}
		HashMap<String, String> hash = new HashMap<String, String>();
		try {
			System.out.println(pojo.getUpwd());
			user ojo = biz.queryUser(pojo);
			HttpSession sess = request.getSession();
			sess.setAttribute("uid", ojo.getUid());
			sess.setAttribute("user", ojo.getUname());
			hash.put("code", "200");
			hash.put("uid", ojo.getUid().toString());
			hash.put("uname", ojo.getUname());
		} catch (Exception e) {
			hash.put("code", "500");
			hash.put("meg", e.getMessage());
		}
		out.write(JSON.toJSONString(hash));
		out.flush();
		out.close();
	}

	//退出
	protected void outUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession();
		sess.removeAttribute("uid");
		sess.removeAttribute("user");
	}

	// 注册
	protected void AddUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String u = request.getParameter("user");
		user pojo = JSON.parseObject(u, user.class);
		pojo.setUpwd(DigestUtils.md5Hex(pojo.getUpwd()));
		HashMap<String, String> hash = new HashMap<String, String>();
		biz.addUser(pojo);
		hash.put("code", "200");
		hash.put("meg", "注册成功");
		out.write(JSON.toJSONString(hash));
		out.flush();
		out.close();
	}

	//显示所有投票信息
	protected void querySubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String u = request.getParameter("user");
		String type = request.getParameter("type");
		subject pojo = new subject();
		if (u != null) {
			pojo = JSON.parseObject(u, subject.class);
		}
		Integer PageNum = Integer.parseInt(request.getParameter("PageNum"));
		out.write(JSON.toJSONString(biz.querySubject(pojo, PageNum, type)));
		out.flush();
		out.close();
	}

	// 显示投票选项
	protected void queryOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String u = request.getParameter("user");
		subject pojo = new subject();
		if (u != null) {
			pojo = JSON.parseObject(u, subject.class);
		}
		out.write(JSON.toJSONString(biz.querySubject(pojo, null)));
		out.flush();
		out.close();
	}

	// 修改状态
	protected void updateSubjectType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String u = request.getParameter("user");
		subject pojo = JSON.parseObject(u, subject.class);
		HashMap<String, String> hash = new HashMap<String, String>();
		try {
			biz.modifySubjectType(pojo);
			hash.put("code", "200");
			hash.put("meg", "修改成功");
		} catch (Exception e) {
			hash.put("code", "500");
			hash.put("meg", e.getMessage());
		}
		out.write(JSON.toJSONString(hash));
		out.flush();
		out.close();
	}

	//新增投票
	protected void addSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String s = request.getParameter("sub");
		String o = request.getParameter("option");
		subject sub = JSON.parseObject(s, subject.class);
		String[] optionString = o.split(",");
		List<option> option = new ArrayList<option>();
		for (String ss : optionString) {
			option pojo = new option();
			pojo.setOption(ss);
			option.add(pojo);
		}
		HashMap<String, String> hash = new HashMap<String, String>();
		try {
			biz.addSubject(sub, option);
			hash.put("code", "200");
			hash.put("meg", "投票成功");
		} catch (Exception e) {
			hash.put("code", "500");
			hash.put("meg", e.getMessage());
		}
		out.write(JSON.toJSONString(hash));
		out.flush();
		out.close();
	}

	// 修改投票信息
	protected void updateSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String s = request.getParameter("sub");
		String o = request.getParameter("option");
		subject sub = JSON.parseObject(s, subject.class);
		String[] optionString = o.split(",");
		List<option> option = new ArrayList<option>();
		for (String ss : optionString) {
			option pojo = new option();
			pojo.setOption(ss);
			option.add(pojo);
		}
		HashMap<String, String> hash = new HashMap<String, String>();
		try {
			biz.modifySubject(sub, option);
			hash.put("code", "200");
			hash.put("meg", "修改成功");
		} catch (Exception e) {
			hash.put("code", "500");
			hash.put("meg", e.getMessage());
		}
		out.write(JSON.toJSONString(hash));
		out.flush();
		out.close();
	}

	// 用户投票
	protected void addItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String Item = request.getParameter("item");
		String Items = request.getParameter("items");
		String way = request.getParameter("way");
		String[] ItemsString = Items.split(",");
		List<item> items = new ArrayList<item>();
		for (int i = 0; i < ItemsString.length; i++) {
			item pojo = JSON.parseObject(Item, item.class);
			pojo.setOid(Integer.parseInt(ItemsString[i]));
			items.add(pojo);
		}
		HashMap<String, String> hash = new HashMap<String, String>();
		try {
			biz.addItems(items, way);
			hash.put("code", "200");
			hash.put("meg", "投票成功");
		} catch (Exception e) {
			hash.put("code", "500");
			hash.put("meg", e.getMessage());
		}
		out.write(JSON.toJSONString(hash));
		out.flush();
		out.close();
	}

	// 查看投票数量
	protected void queryItems(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("sid");
		out.write(JSON.toJSONString(biz.queryItems(sid)));
		out.flush();
		out.close();
	}
}
