package com.accp.exam.util;

import net.sf.cglib.proxy.Enhancer;

@SuppressWarnings("all")
public class CgLibTransProxyUtil {

	public static <T> T getTransProxyObject(Class superClass) {
		// 利用字节码技术动态创建代理对象
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(superClass);
		// 设置回调函数【规则】
		enhancer.setCallback(new TransCallBack());
		// 创建对象
		return (T) enhancer.create();
	}
}
