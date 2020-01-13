package com.weichuang.day08Demo;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 大数操作对象
 */
public class BigIntegerDemo {

    public static void main(String[] args) {
        //int a = 2376736278367286327;已超过整型的最大范围
        BigInteger bi1 = new BigInteger("12376736278367286327");
        BigInteger bi2 = new BigInteger("8374374873847387483");
        //大整数操作对象
        BigInteger bi3 = bi1.add(bi2);
        System.out.println("--------加法操作-------");
        System.out.println(bi3);
        System.out.println("--------除法操作-------");
        System.out.println(bi1.divide(bi2));
        //float d = 0.3483748378436746376443673646377843784738;
        BigDecimal bd1 = new BigDecimal("84.44643647364736743674637");
        BigDecimal bd2 = new BigDecimal("1.2545647657465746754675647");
        System.out.println("-----------大数浮点型的除法操作------------");
        //可能存在算数异常，因为除不尽损失精度
        try{
            System.out.println(bd1.divide(bd2));
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        System.out.println("-----------大数浮点型乘法操作");
        System.out.println(bd1.multiply(bd2));
    }
}
