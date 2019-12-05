package com.accp.aspect;

import java.util.Date;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;

public class Logger {
	public void loggerBegin(JoinPoint jp) {
		System.out.println(new Date().toLocaleString() + "开始"+jp.getSignature().getName()+"记录日志");
	}
	
	public void loggerEnd(JoinPoint jp) {
		System.out.println(new Date().toLocaleString() + "结束"+jp.getSignature().getName()+"结束日志");
	}
}
