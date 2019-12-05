package com.example.demo.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IMessageDao;
import com.example.demo.pojo.Login;
import com.example.demo.pojo.Message_ws;

@Service("MessageBiz")
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class MessageBiz {
	@Autowired
    private IMessageDao dao;
	//登录
	public	Login dl(String uname,String upwd) {
			return dao.dl(uname, upwd);
		}
	//添加消息
	public	int saveMessage(Message_ws message) {
		return dao.saveMessage(message);
	}
	//显示消息
	public	List<Message_ws> queryMessage(){
		return dao.queryMessage();
	}
	
}
