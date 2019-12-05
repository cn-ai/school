package com.example.demo.dao;

import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.pojo.Login;
import com.example.demo.pojo.Message_ws;

public interface IMessageDao {
//登录
	Login dl(@PathParam("uname")String uname,@PathParam("upwd") String upwd);
//添加消息
	int saveMessage(@PathParam("message") Message_ws message);
//显示消息
	List<Message_ws> queryMessage();
}
