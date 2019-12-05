package com.accp.t3.resolver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @ClassName ApiHandlerExceptionResolver
 * @description 自定义异常解析器
 * @author sye
 * @date 2017年2月1日
 * @version V1.0
 */
public class ApiHandlerExceptionResolver implements HandlerExceptionResolver {

	private Properties exceptionMappings;// key:className value:viewName

	private List<String> apiPaths;

	public List<String> getApiPaths() {
		return apiPaths;
	}

	public void setApiPaths(List<String> apiPaths) {
		this.apiPaths = apiPaths;
	}

	public Properties getExceptionMappings() {
		return exceptionMappings;
	}

	public void setExceptionMappings(Properties exceptionMappings) {
		this.exceptionMappings = exceptionMappings;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mav = null;
		boolean flag = false;
		for (String temp : apiPaths) {
			if (request.getRequestURI().startsWith(request.getContextPath() + temp)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				return null;
			}
			Map<String, String> message = new HashMap<String, String>();
			message.put("code", "500");
			message.put("msg", ex.getClass().getSimpleName() + ":"
					+ (ex.getMessage() == null || "".equals(ex.getMessage()) ? "null" : ex.getMessage()));
			out.write(JSON.toJSONString(message));
			out.flush();
			out.close();
		} else {
			if (exceptionMappings.getProperty("java.lang.Exception") == null) {
				return null;
			}
			mav = new ModelAndView(exceptionMappings.getProperty(ex.getClass().getName()) == null
					? exceptionMappings.getProperty("java.lang.Exception")
					: exceptionMappings.getProperty(ex.getClass().getName()));
			mav.addObject("exception", ex);
		}
		return mav;
	}

}
