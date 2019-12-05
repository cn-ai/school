package com.example.demo.ws;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.biz.MessageBiz;
import com.example.demo.pojo.Login;
import com.example.demo.ws.config.UpdateHttpSession;


@ServerEndpoint(value = "/ws/sys", configurator = UpdateHttpSession.class)
@Component
public class SysMessageScoketHlader {
	private static final Map<String, Session> userMap=new ConcurrentHashMap<String,Session>();
	public static ApplicationContext ac;//非常重要
	private String userName;
	@OnOpen
	public void onopen(Session session,EndpointConfig config) {
			MessageBiz biz=(MessageBiz)ac.getBean("MessageBiz");
			HttpSession httpsession=(HttpSession) config.getUserProperties().get(HttpSession.class.getName());
			final String _userName= ((Login) httpsession.getAttribute("user")).getUname();//获取会话中存在的用户名
			this.userName=_userName;
			
			
	}
	@OnClose
	public void onclose(Session session) {
		
	}
	@OnMessage
	public void onmessage(String msg,Session session) {
		
	}
	@OnError
	public void Onerror(Session session,Throwable ex) {
		
	}
}
