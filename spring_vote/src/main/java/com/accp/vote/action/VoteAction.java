package com.accp.vote.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accp.vote.biz.Votebiz;
import com.accp.vote.pojo.Option;
import com.accp.vote.pojo.Subject;
import com.accp.vote.pojo.User;
import com.accp.vote.util.SpringBeanUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

/**
 * Servlet implementation class VoteAction
 */
public class VoteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Votebiz vbiz=SpringBeanUtil.getBeanByname("biz");
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=req.getParameter("method");
		Class clazz=this.getClass();
		try {
			Method m=clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
/**
 * 登录
 * @param req
 * @param resp
 * @throws IOException
 */
	public void Login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		Map<String,String> map=new Hashtable<String,String>();		
			User user=vbiz.Login(uname, upwd);
			if(user!=null) {
			session.setAttribute("user", user);
			map.put("code", "200");
			map.put("msg", "登录成功");
			}else {
			map.put("code", "500");
			map.put("msg", "登录失败");		
		}
		out.print(JSON.toJSONString(map));
	}
	/**
	 * 注册
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void saveReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		int count=vbiz.saveReg(uname, upwd);
		if(count>0) {
			out.write("yes");
		}else {
			out.write("no");
		}
		out.flush();
		out.close();
	}
	/**
	 * 退出会话对象
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void outSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session=req.getSession();
		session.invalidate();
		PrintWriter out=resp.getWriter();
		out.write("yes");
		out.flush();
		out.close();
	}
	/**
	 *  查询登录后的主页
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void querySub(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		String sub1=req.getParameter("sub1");
		String pageNum=req.getParameter("pageNum");
		String pageSize=req.getParameter("pageSize");
		PageInfo<Subject> info=vbiz.querySub(sub1,Integer.parseInt(pageNum), 1);
		out.write(JSON.toJSONString(info));
		out.flush();
		out.close();
	}
	/**
	 * 维护前的查询
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadSub(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sid=Integer.parseInt(req.getParameter("sid"));
		Subject sub=vbiz.loadSub(sid);
		req.setAttribute("sub", sub);		
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
	}
	/**
	 * 维护功能
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void updateSub(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		String obj=req.getParameter("obj");
		String name=req.getParameter("name");
		Subject sub= JSON.parseObject(obj,Subject.class);
		String[] option=name.split(",");
		List<Option> list=new ArrayList<Option>();
		for (String string : option) {
			Option o=new Option();
			o.setOption(string);			
			list.add(o);
		}
		sub.setOption(list);
		int count=vbiz.updateSub(sub);
		if(count>0) {
			out.write("yes");
		}else {
			out.write("no");
		}
		out.flush();
		out.close();
	}
}
