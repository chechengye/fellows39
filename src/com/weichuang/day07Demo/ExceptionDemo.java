package com.weichuang.day07Demo;

/**
 * 异常讲解
 * 1、受检异常
 * 2、非受检异常
 * ArithmeticException : 算数异常 ,出现异常阻断程序继续执行
 * try: 尝试，可能存在异常的代码语句
 * catch : 捕获异常，只要做了异常处理，就不会终端作用域继续执行,可以有多个。
 * 通常最后放一个最大的Exception异常，防止有没有完全想到的异常出现
 * finally: 一定会被执行的代码块
 * 面试题 : finally 与 return 谁先执行  finally一定比return语句先执行
 * finally里面的return语句要优于catch里面的return语句
 *
 * 原因： catch语句被执行到的时候，只要发现里面有return语句。立马会去看finally代码块.
 * 若有先执行finally代码块里的内容,执行之后会回来继续执行catch里的return语句
 *
 * throws  : 关键字主要在方法的声明上使用，表示方法中不处理异常，
 * 而交给调用处处理。实际上对于Java程序来讲，
 * 如果没有加入任何的异常处理，默认由JVM进行异常的处理操作
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        //System.out.println(div(10, 0));
        try {
            testMethod();
        } catch (ClassNotFoundException e) {
            System.out.println("类没有找到异常");
        }
        try{
            testFn2();
        }catch (NullPointerException e){
            System.out.println("除数为1没有意义");
        }



    }

    public static void testFn2(){
        int a = 10 ,b = 1;
        int c = a / b;
        if(b == 1){
            throw new NullPointerException("除数为1没有意义");
        }
    }
    public static void testMethod() throws ClassNotFoundException{
        //int c = 10 / 0;
        //System.out.println(c);
        int i = 20;
        try{
            int i2 = 10;
            Class.forName("com.weichuang.day06Demo.package01.PowerDemo2222");
        }finally {
            System.out.println(i);
        }
    }
    public static int div(int a , int b){

        try{
            int[] arr = {1,2,3,4};
            arr = null;
            System.out.println(arr.length);
            int c = a / b;
            System.out.println(c);
        }catch (ArithmeticException e){
            System.out.println("除数不能为0");
        }catch (NullPointerException e){
            System.out.println("空指针异常处理");
            e.printStackTrace();
            System.out.println("空指针异常处理111");
            return 3;
        }/*catch (Exception e){
            System.out.println("所有异常我都能捕获!");
        }*/finally {
            System.out.println("我是一定会被执行的代码块");
            //return 10;
        }
        //System.out.println(10);
       /*
       */
        return -1;
    }
}
