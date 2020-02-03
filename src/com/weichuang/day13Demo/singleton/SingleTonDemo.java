package com.weichuang.day13Demo.singleton;

import java.io.Serializable;

public class SingleTonDemo {
    public static void main(String[] args) {
        SingleTon s1 = SingleTon.getInstance();
        SingleTon s2 = SingleTon.getInstance();
        System.out.println(s1 == s2);
    }
}

/**
 * 懒汉式
 * 1、synchronized多线程同步代码块的方式
 * 2、volatile 每次都需要从地址中读取数据，不从寄存器中获取（缓存）
 * 3、私有化的构造方法可能会通过反射机制调用，所以实例化过对象之后，再进入抛出异常通知
 * 4、序列化操作，了解（面试不一定会问到）
 */
class SingleTon implements Serializable{
    private volatile static SingleTon singleTon = null;//多线程共享对象
    private SingleTon(){//构造方法私有化不允许外部引用
        if(null != singleTon){
            throw new RuntimeException("本类为单例模式，不允许外部实例化");
        }
    }
    public static SingleTon getInstance(){
        if(null == singleTon){//单线程时，防止每次都会进入同步代码块
            //A B
            synchronized (SingleTon.class){
                if(null == singleTon){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

}
