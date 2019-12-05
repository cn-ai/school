package com.example.demo.quartz.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.biz.CronBiz;
import com.example.demo.pojo.Student;

public class MyJob implements Job{
	@Autowired
	private CronBiz biz;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("当前统计会员数量2222222XXX"+context.getJobDetail().getKey());
		
		List<Student> list=biz.queryStudent();
		for (Student student : list) {
			System.out.println(student.getUname());
		}
		if(list.size()==0) {
			System.out.println("暂无数据");
		}
	}

}
