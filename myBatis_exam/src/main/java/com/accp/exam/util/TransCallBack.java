package com.accp.exam.util;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TransCallBack implements MethodInterceptor {

	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy mp) throws Throwable {
		Object returnVal = null;
		try {
			returnVal = mp.invokeSuper(proxy, args);// 委托对象的方法
			if (!method.getName().startsWith("find")) {
				SqlSessionUtil.commit();
			}
		} catch (Exception ex) {
			LoggerUtil.error("事务提交失败", ex);
			SqlSessionUtil.rollback();
		} finally {
			SqlSessionUtil.closeSession();
		}
		return returnVal;
	}

}
