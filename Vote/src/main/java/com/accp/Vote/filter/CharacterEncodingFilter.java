package com.accp.Vote.filter;

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
 * Servlet Filter implementation class CharacterEncodingFilter
 */
public class CharacterEncodingFilter implements Filter {
	private String charset = "UTF-8";
    /**
     * Default constructor. 
     */
    public CharacterEncodingFilter() {
        // TODO Auto-generated constructor stub
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
		htresponse.setCharacterEncoding(charset);
		htresponse.setContentType("text/html;charset="+charset);
		String MethodType = htrequest.getMethod();//获取请求方式
		if("post".equalsIgnoreCase(MethodType)) {
			htrequest.setCharacterEncoding(charset);
		}
		chain.doFilter(htrequest, htresponse);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		charset= fConfig.getInitParameter("encoding");//获取配置参数
	}

}
