package cn.mldn.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.mldn.util.dbc.DatabaseConnection;

public class ServiceProxy implements InvocationHandler {
	private Object target;
	public Object bind(Object target){
		this.target=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object retData=null;
		String methodName=method.getName();
		boolean flag=methodName.startsWith("add")||methodName.startsWith("edit")||methodName.startsWith("delete");
		try{
			if(flag){
				DatabaseConnection.getConnection().setAutoCommit(false);
			}
			retData=method.invoke(this.target, args);
			if(flag){
				DatabaseConnection.getConnection().commit();
			}
		}catch (Exception e) {
			if(flag){
				DatabaseConnection.getConnection().rollback();
			}
			throw e;
		}finally {
			DatabaseConnection.close();
		}
		return retData;
	}
}

