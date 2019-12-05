package com.accp.vote.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class SpringBeanUtil {
	private static ApplicationContext ac;
	private static final String DEFAULT_name="spring_txt.xml"; 
	private static Logger logger = Logger.getRootLogger();
	static {
		try {
			ac=new ClassPathXmlApplicationContext(DEFAULT_name);
		}catch(Exception e) {
			logger.error("spring异常："+e);
		}
			
	}
	public static <T>T getBeanByname(String name){
		return (T) ac.getBean(name);
	}
}
