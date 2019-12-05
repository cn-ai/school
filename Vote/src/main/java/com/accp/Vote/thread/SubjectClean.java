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
		System.out.println("��ǰ�߳�ID��"+Thread.currentThread().getId());
		System.out.println("��ǰ�߳����ƣ�"+Thread.currentThread().getName());
		
	    Calendar calendar = Calendar.getInstance();
	    // ʱ
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    // ��
	    calendar.set(Calendar.MINUTE, 0);
	    // ��
	    calendar.set(Calendar.SECOND, 0);
	    // ����
	    calendar.set(Calendar.MILLISECOND, 0);
	    //��ȡ�趨ʱ��
	    Date time = calendar.getTime();
	    //��ǰʱ��
	    Date now = new Date();
	    //��ȡ�趨ʱ���뵱ǰʱ���ʱ���
	    long interval = time.getTime() - now.getTime();
	    //����Ǹ��������������Ѿ��������ʱ��
	    if(interval<0) {
	    	calendar.add(Calendar.DAY_OF_MONTH, 1);//��������1
	    	time = calendar.getTime();
	    	//��ȡ�趨��ʱ��͵�ǰ��ʱ����������
	    	interval = time.getTime() - now.getTime();
	    }
	    System.out.println("��������ʱ�仹�У�"+(interval/1000/60/60)+"Сʱ"+((interval/1000/60)-((interval/1000/60/60)*60))+"����");
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Integer Count = biz.modifyStoptype();
				if(Count>0) {
					System.out.println("ÿ�ս����ѵ�ʱ���ͶƱ:��⵽��"+Count+"����Ϣ���Ѿ������޸ġ�");
				}else {
					System.out.println("ÿ�ս����ѵ�ʱ���ͶƱ:δ��⵽..");
				}
			}
		},interval,24*60*60*1000);
	}

}
