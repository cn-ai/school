package com.accp.aspect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Clock {
public Object takeTime(ProceedingJoinPoint pjp) {
	Object val=null;
    long startTime=System.currentTimeMillis();
    System.out.println("开始时间:"+startTime);
	
	try {
	val=pjp.proceed();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  long endTime=System.currentTimeMillis();
	  System.out.println("结束时间："+endTime);
	  float excTime=(float)(endTime-startTime)/1000;
	System.out.println("耗时为:"+excTime);
	return val;
}
}
