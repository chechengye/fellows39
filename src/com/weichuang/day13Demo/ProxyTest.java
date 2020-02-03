package com.weichuang.day13Demo;

/**
 * 动态代理又称为JVM动态代理
 * 他的条件，被代理对象一定要实现接口，至少一个接口，允许多个
 */
public class ProxyTest {

    public static void main(String[] args) {
        IPerson p = new Person();
        ProxyFactory pf = new ProxyFactory();
        IPerson pProxy = (IPerson) pf.productProxyObj(p);//被代理后的对象
        System.out.println(pProxy.shopping());
    }
}
