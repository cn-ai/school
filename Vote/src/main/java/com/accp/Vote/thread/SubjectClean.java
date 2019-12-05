package com.accp.Vote.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.mybatis.spring.SqlSessionUtils;

import com.accp.Vote.biz.VoteBiz;
import com.accp.Vote.util.SpringBeanUtil;

public class SubjectClean implements Runnable {
	private VoteBiz biz = SpringBeanUtil.getBeanByName("biz");
	@Override
	public void run() {
		System.out.println("当前线程ID："+Thread.currentThread().getId());
		System.out.println("当前线程名称："+Thread.currentThread().getName());
		
	    Calendar calendar = Calendar.getInstance();
	    // 时
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    // 分
	    calendar.set(Calendar.MINUTE, 0);
	    // 秒
	    calendar.set(Calendar.SECOND, 0);
	    // 毫秒
	    calendar.set(Calendar.MILLISECOND, 0);
	    //获取设定时间
	    Date time = calendar.getTime();
	    //当前时间
	    Date now = new Date();
	    //获取设定时间与当前时间的时间差
	    long interval = time.getTime() - now.getTime();
	    //如果是负数，负数今天已经过错这个时间
	    if(interval<0) {
	    	calendar.add(Calendar.DAY_OF_MONTH, 1);//将天数加1
	    	time = calendar.getTime();
	    	//获取设定的时间和当前的时间差（毫秒数）
	    	interval = time.getTime() - now.getTime();
	    }
	    System.out.println("距离启动时间还有："+(interval/1000/60/60)+"小时"+((interval/1000/60)-((interval/1000/60/60)*60))+"分钟");
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Integer Count = biz.modifyStoptype();
				if(Count>0) {
					System.out.println("每日结束已到时间的投票:检测到有"+Count+"个信息，已经进行修改。");
				}else {
					System.out.println("每日结束已到时间的投票:未检测到..");
				}
			}
		},interval,24*60*60*1000);
	}

}
