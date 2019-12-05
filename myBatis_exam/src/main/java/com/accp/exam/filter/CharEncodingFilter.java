package com.accp.exam.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharEncodingFilter
 */
public class CharEncodingFilter implements Filter {
	private String charset;
  
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//ת��
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		//���ø�ʽ
		resp.setCharacterEncoding(charset);
		resp.setContentType("text/html;charset="+charset);
		//������󷽷�
		String reqMethod=req.getMethod();
		if(reqMethod.equals("post")) {
			req.setCharacterEncoding(charset);
		}
		chain.doFilter(req, resp);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//��ó�ʼ�������ʽ
		charset=fConfig.getInitParameter("charset");
		
	}

}
