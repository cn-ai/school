package web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Send {

	public static void main(String[] args) throws Exception{
		new Thread() {
			public void run() {
				BufferedReader br;
				try {
					// TODO Auto-generated method stub
					//1.创建资源定位
					URL url=new URL("http://www.baidu.com");
					//2.打开连接
					HttpURLConnection httpconn=(HttpURLConnection) url.openConnection();
					//设置请求方法
					httpconn.setRequestMethod("GET");
					//设置超时时间【非常重要】同时存在
					httpconn.setConnectTimeout(6*1000);//运算表达式,便于运算。连接超时		
					httpconn.setReadTimeout(6*1000);//数据读取超时
					//设置是否可以写入消息体信息（post,put请求必须打开）
					httpconn.setDoOutput(true);
					//3.连接
					httpconn.connect();
					//4.获得响应信息
					int rscode=httpconn.getResponseCode();//返回的响应码
					switch (rscode) {
					case HttpURLConnection.HTTP_OK:
						System.out.println("成功");
						//5.io读写数据（相对于内存读input写out）
						//把低级流装换成高级流
						//httpconn.getInputStream();字节流
						//把低级字节流转成高级缓存字符流		
					br=	new BufferedReader(	new InputStreamReader(httpconn.getInputStream(),"utf-8"));
						//整行读取
					for(String str=null;(str=br.readLine())!=null;) {
						System.out.println(str);
					}
					br.close();
					break;
					case HttpURLConnection.HTTP_NOT_FOUND:
						System.out.println("未找到");
					break;
					case HttpURLConnection.HTTP_INTERNAL_ERROR:
						System.out.println("错误");
					break;

					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("异常"+e);
				}finally {
					
				}
			};
		}.start();
	
		
	}

}
