package com.accp.exam.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accp.exam.biz.InvitationBiz;
import com.accp.exam.pojo.Detail;
import com.accp.exam.util.CgLibTransProxyUtil;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class InvitationAction
 */
public class InvitationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InvitationBiz ubiz=CgLibTransProxyUtil.getTransProxyObject(InvitationBiz.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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

	public void queryAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer pageNum = Integer.parseInt(req.getParameter("p"));
		Integer pageSize = Integer.parseInt(req.getParameter("s"));
		String title=req.getParameter("title");
		PrintWriter out = resp.getWriter();
		out.write(JSON.toJSONString(ubiz.queryAll(title, pageNum, pageSize)));
		out.flush();
		out.close();
	}
	
	public void querydetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		List<Detail> list= ubiz.queryDetail(Integer.parseInt(id));
		req.setAttribute("list", list);
		req.getRequestDispatcher("../queryDetail.jsp").forward(req, resp);
	}
}
