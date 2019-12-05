package com.example.demo.cofig;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.demo.biz.CronBiz;
import com.example.demo.pojo.Student;

@Configuration
@EnableScheduling
public class Jobcofig {
	@Autowired
	private CronBiz biz;
	@Scheduled(cron="0/5 * 12,13,14,15,18,19,20 * * ?")
	public void doJob() {
		biz.show();
		/*biz.addStudent(new Student("曹娜",new Date(),"哈哈"));*/
	}
}
