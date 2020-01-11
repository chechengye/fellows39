package com.weichuang.day06Demo;

public class IntegerDemo {

    public static void main(String[] args) {
        int a = 10;
        Integer integer = new Integer(a);//装箱
        System.out.println(integer);
        Integer i1 = new Integer(123);
        int i = i1.intValue(); //拆箱
        System.out.println(i);
        Double d = new Double(0.23);
        double d1 = d.doubleValue();

        int i2 = Integer.parseInt("45678"); //面试会问: 将一个字符串怎么转为int类型
        String str = i2 + ""; //将整型转换为字符串
        System.out.println(str);
        //基本常量值
        Integer i3 = 10;
        Integer i4 = 10;
        System.out.println(i3 == i4);
        //引用类型值
        Integer i5 = new Integer(10);
        Integer i6 = new Integer(10);
        System.out.println(i5 == i6);
        //享元模式 共享一位的堆中的内存空间
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);
        Integer i9 = new Integer(128);
        Integer i10 = new Integer(128);
        System.out.println(i9 == i10);
    }
}
