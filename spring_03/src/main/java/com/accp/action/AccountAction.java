package com.accp.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runner.RunWith;

import com.accp.biz.AccountBiz;
import com.accp.pojo.Account;
import com.accp.pojo.Transaction_record;
import com.accp.util.SpringBeanUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

/**
 * Servlet implementation class AccountAction
 */
public class AccountAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
      private AccountBiz biz=SpringBeanUtil.getBeanbyName("biz");
  
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
		String cardno=req.getParameter("account");
		String password=req.getParameter("password");
		Account count=biz.Login(cardno);
		Map<String,String> map=new Hashtable<String,String>();
		if(count!=null) {
			if(count.getStatus()==1) {
				map.put("code", "500");
				map.put("msg", "登录失败，账号已冻结");
			}else if(count.getStatus()==0){
				if(!count.getPassword().equals(password)) {
					map.put("code", "500");
					map.put("msg", "登录失败，密码错误");
				}else {
					map.put("code", "200");
					map.put("msg", "登录成功");
					session.setAttribute("account", count);
				}
			}
		}else {
				map.put("code", "500");
				map.put("msg", "登录失败，你输入的卡号不存在");		
		}
		out.write(JSON.toJSONString(map));
		out.flush();
		out.close();
	}
	/**
	 * 获取session会话
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void getAccountSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		Account count=(Account)req.getSession().getAttribute("account");
		out.write(JSON.toJSONString(count));
		out.flush();
		out.close();
	}
	/**
	 * 退出会话对象
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void outAccountSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		req.getSession().invalidate();
	}
	/**
	 * 查询余额
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void queryBalance(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		String cardno=req.getParameter("cardno");
		Account re=biz.Login(cardno);
		out.write(JSON.toJSONString(re));		
		out.flush();
		out.close();
	}
	/**
	 * 转账前的查询
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	public void queryBringBegin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		String cardno=req.getParameter("cardno");
		int money=Integer.parseInt(req.getParameter("money"));
		Account count=biz.Login(cardno);
		Map<String,String> map=new Hashtable<String,String>();
		if(count!=null) {
			if(count.getStatus()==1) {
				out.print("<script>");
				out.print("alert('登录失败，账号已冻结');");
				out.print("</script>");
				return;
			}else if(count.getStatus()==0){
				if(count.getBalance()<money) {
					out.print("<script>");
					out.print("alert('账号余额不足');");
					out.print("</script>");
					return;
				}
			}
		}else {
			out.print("<script>");
			out.print("alert('账户目标不存在');");
			out.print("</script>");	
			return;
		}
		out.write(JSON.toJSONString(map));
		out.flush();
		out.close();
	}
	/**
	 * 新增记录表的转出
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void addRecord(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		queryBringBegin(req,resp);
		String strobj=req.getParameter("strobj");
		Transaction_record record=	JSON.parseObject(strobj,Transaction_record.class);
		int	txt=biz.addRecord(record);
		out.write(txt);
		out.flush();
		out.close();
	}
	/**
	 * 新增记录表的转入
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void addRecord2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		queryBringBegin(req,resp);
		String strobj2=req.getParameter("strobj2");
		Transaction_record record2=	JSON.parseObject(strobj2,Transaction_record.class);
		int txt2=biz.addRecord2(record2);
		out.write(txt2);
		out.flush();
		out.close();
	}
	/**
	 * 修改用户表的账户余额
	 */
	public void updateAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		queryBringBegin(req,resp);
		String xg1=req.getParameter("strxg1");
		Account acc=JSON.parseObject(xg1,Account.class);
		int tct=biz.updateAccount(acc);
		out.write(tct);
		out.flush();
		out.close();
	}
	
	/**
	 * 查询所有交易记录
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void queryDeal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	PrintWriter out=resp.getWriter();
	String currentPage=req.getParameter("currentPage");
	String pageSize=req.getParameter("pageSize");
	String datebegin=req.getParameter("begin");
	String dateend=req.getParameter("end");
	int cpage=1;
	int pages=2;
	if(currentPage!=null) {
		cpage=Integer.parseInt(currentPage);
	}
		PageInfo<Transaction_record> info= biz.queryDeal(cpage, pages, datebegin, dateend);
		out.write(JSON.toJSONString(info));
		out.flush();
		out.close();
	}
	
	/**
	 * 修改密码
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	public void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		String cardno=req.getParameter("cardno");
		String pwd=req.getParameter("pwd");
		int count=biz.updatePwd(pwd, cardno);
		out.write(count);
		out.flush();
		out.close();
	}
}
