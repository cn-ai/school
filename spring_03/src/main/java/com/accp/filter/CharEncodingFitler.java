/**
 * 
 */
package com.accp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author��С�ȱ�
 *@Title:CharEncodingFitler
 *@Description:
 *@date:2018��10��7��
 */
public class CharEncodingFitler implements Filter{
	private String charset;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response= (HttpServletResponse) resp;
		response.setContentType("text/html;charset="+charset);
		response.setCharacterEncoding(charset);
		String method=request.getMethod();
		if(method.equalsIgnoreCase("post")) {
			req.setCharacterEncoding(charset);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		charset=config.getInitParameter("charset");
	}

}
