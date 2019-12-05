package com.accp.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SuppressWarnings("all")
public class SpringBeanUtil {
	private static ApplicationContext ac;
	private static final  Logger logger=Logger.getRootLogger();
	private static final  String defalut_config="xxx.xml";
	static {
		try {
		ac=new ClassPathXmlApplicationContext(defalut_config);
		}catch (Exception e) {
			logger.error("加载异常："+e);
		}	
	}
	public static <T>T getBeanbyName(String name) {
		return (T)ac.getBean(name);
	}
}
