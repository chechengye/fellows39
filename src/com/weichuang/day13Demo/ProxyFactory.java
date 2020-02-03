package com.weichuang.day13Demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler{
    private Object target;//目标对象，被代理对象
    public Object productProxyObj(Object target){
        this.target = target;
        Object proxyObj = Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);//被代理之后的对象
        return proxyObj;
    }

    /**
     * 代理对象(被代理之后的对象)要执行的方法--代购
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理去海外淘货，供你选择心仪商品");
        Object o = method.invoke(target, args);
        if((boolean)o){
            System.out.println("发快递，邮寄上门");
        }else{
            System.out.println("付款失败");
        }
        return o;
    }
}
