package com.example.demo.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IOutBoxDao;
import com.example.demo.pojo.Outbox;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class OutboxBiz {
	@Autowired
	private IOutBoxDao outboxdao;
	
	//查询收件箱
	public List<Outbox> queryOutbix(int state,int inuid){
		return outboxdao.queryOutbix(state, inuid);
	}
}
