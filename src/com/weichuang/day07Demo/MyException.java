package com.weichuang.day07Demo;

/**
 * 自定义异常类:
 * 1、可以继承Throwable
 * 2、可以继续Exception 变为受检异常
 * 3、可以继承RuntimeException 非受检异常
 */
public class MyException extends Exception{

    public MyException(){
        super();
    }

    public MyException(String s){
        super(s);
    }
}
