package com.example.demo.ws;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

//1.配置站点
@ServerEndpoint("/ws/test/{name}")
@Component
public class MyWebSocketHandler {
	
	private final static Set<Session> userset=new CopyOnWriteArraySet<Session>();//线程安全
	private final static Map<String, Session> userMap=new ConcurrentHashMap<>();
	private String userName;
	
	@OnOpen
	public void onopen(Session session,@PathParam("name") String name) {
		System.out.println("服务器端接收客户端长连接构建成功");
		userset.add(session);//保存
		userMap.put(name, session);
		System.out.println("userMap="+userMap);
		userName=name;
		//启动心跳程序
		new Thread() {
			public void run() {
				while(true) {
					try {
						sleep(3000);
					} catch (InterruptedException e) {
						break;
					}
				}
			};
		}.start();
	}
	@OnClose
	public void onclose(Session session) {
		System.out.println("客户端关闭");
		userset.remove(session);
		userMap.remove(userName);
	}
	@OnError
	public void onerror(Session session,Throwable e) {
		System.out.println("连接异常");	
		userset.remove(session);
		userMap.remove(userName);
	}
	//这个方法的参数位置不能更改
	@OnMessage
	public void onmessage(String msg,Session session) {
		System.out.println("服务器端和客户端["+session.getId()+"]通讯,接收消息"+msg);
		//发消息
		try {
			if("熙熙".equals(msg)) {
				session.getBasicRemote().sendText("熙熙每天要开心");	
			}else if("娜比".equals(msg)) {
				session.getBasicRemote().sendText("娜比每天要开心");
			}else if("all".equals(msg)) {
				this.setAllUser("群发消息");
			}else if(msg.contains("@")) {
				String [] temp=msg.split("@");	
				setUser(temp[1], userName+":"+temp[0]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//发送单个人消息
	private void setUser(String name,String msg) {
		try {
			userMap.get(name).getBasicRemote().sendText(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//接收群推消息
	private void setAllUser(String msg) {
		for (Session session : userset) {
			try {
				session.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
