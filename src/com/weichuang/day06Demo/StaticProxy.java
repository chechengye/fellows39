package com.weichuang.day06Demo;

/**
 * 静态代理模式，在对象调用方法之前，代理先帮我们做一些事情
 */
public class StaticProxy {
    public static void main(String[] args) {
        Action action = new User();//action : 被代理对象
        ProxyUser proxyUser = new ProxyUser(action);//proxyUser: 代理后生成对象
        proxyUser.doAction();
    }
}

/**
 * 代理对象
 */
class ProxyUser implements Action{
    private Action action;
    //初始化action为一个真实的对象
    public ProxyUser(Action action){
        this.action = action;
    }
    @Override
    public void doAction() {
        System.out.println("我得先给你签约一下");
        long startTime = System.currentTimeMillis();
        action.doAction();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime) );
        System.out.println("我帮你拿酬劳");
    }
}
interface Action{
    void doAction();
}
class User implements Action{

    @Override
    public void doAction() {
        for (int i = 0 ; i < 10000 ; i++){
            System.out.print("*");
        }
        System.out.println("我要演戏...");
    }
}