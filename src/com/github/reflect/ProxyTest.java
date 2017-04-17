package com.github.reflect;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		PersonDao pd=new PersonDaoImpl();
		pd.delete();
		pd.insert();
		
		System.out.println("--------------------");
		MyInvocationHandler handler=new MyInvocationHandler(pd);
		PersonDao pdProxy=(PersonDao)Proxy.newProxyInstance(pd.getClass().getClassLoader(), pd.getClass().getInterfaces(), handler);
		pdProxy.insert();
		pdProxy.delete();
	}
}
