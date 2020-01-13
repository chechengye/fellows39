package com.weichuang.day08Demo;
import java.util.Random;

import static java.lang.Math.sqrt;//静态导入

/**
 * 数学运算工具类
 */
public class MathDemo {

    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println(Math.abs(-10));
        System.out.println("-----------------");
        System.out.println(Math.round(Math.random()*100) / 100.0);
        System.out.println(sqrt(2));
        System.out.println(Math.ceil(1.2));//天花板 ,场景：分页的时候使用较多
        Random r = new Random();
        System.out.println(r.nextBoolean());
        System.out.println(r.nextInt());
        System.out.println(r.nextInt(20));//0~19
    }
}
