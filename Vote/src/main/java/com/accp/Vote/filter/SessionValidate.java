package com.accp.Vote.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionValidate
 */
public class SessionValidate implements Filter {
	final static List<String> PathList =new ArrayList<String>();
	static {
		PathList.add("/login.jsp");
		PathList.add("/index.jsp");
		PathList.add("/reg_success.jsp");
		PathList.add("/register.jsp");
		PathList.add("/out.html");
		PathList.add("/view.jsp");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest htrequest = (HttpServletRequest)request;
		HttpServletResponse htresponse = (HttpServletResponse)response;
		// ��ȡ����uri(/WebFilter/c/user?f=login)
		String url = htrequest.getRequestURI();//��ȡ����URl��Ϣ
		String itemName = htrequest.getContextPath();//��ȡ��Ŀ��
		for (String string : PathList) {
			if(url.equals(itemName+string)) {
				chain.doFilter(htrequest, htresponse);
				return;
			}
		}
		//�û�����
		HttpSession sess = htrequest.getSession();
		if(sess.getAttribute("user")==null) {
			htresponse.sendRedirect("out.html");
		}else {
			chain.doFilter(htrequest, htresponse);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
