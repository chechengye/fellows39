package com.weichuang.day08Demo;

import java.util.Arrays;
import java.util.Date;

/**
 * System讲解
 */
public class SystemDemo {

    public static void main(String[] args) {
        System.out.println("普通打印输出语句");
        System.err.println("这是错误打印语句");//并不常用，笔记错误
        int[] a = {1,2,3,4,5};
        int[] b = new int[a.length];
        /**
         * Arrays.copyOf是System.arraycopy方法的实现
         * Arrays.copyOf ： 简洁明了
         * System.arraycopy ： 更加高效，且可以指定任意位置
         */
        System.arraycopy(a , 0 , b , 0 , 2);
        System.out.println(Arrays.toString(b));
        //System.currentTimeMillis() 1、初始化日期更快捷 2、计算代码耗时性 3、重新命名文件名称
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        //System.exit(0);

        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));


    }
}
