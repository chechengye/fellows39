package com.weichuang.day07Demo;

/**
 * SpringBuffer讲解
 * 相当于字符串缓冲区对象。可以进行拼接操作
 * 线程安全的，可以保证同步。多线程使用时考虑
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = s1 + s2 + "1"; //生成多个对象
        String s4 = "a" + "b" + 1; //"ab1"//生成的一个对象

        StringBuffer sb = new StringBuffer("a"); //只有一个对象sb
        sb.append(s2).append("1");
        System.out.println(sb.toString());
        System.out.println("---------------------------");
        System.out.println(sb.reverse());
        //判断一个串是否为回文数
        StringBuffer sb1 = new StringBuffer("12321");
        if(sb1.equals(sb1.reverse())){
            System.out.println("回文数");
        }
    }
}
