package com.weichuang.day07Demo;

/**
 * StringBuilder ：
 * 是StringBuffer的兄弟。方法相同
 * 区别: 不同步的，线程不安全的。单线程时建议使用
 * 建议优先采用该类,比StringBuffer快
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("a");
        sb.append("b").append("sss");
        sb.append("123");
        System.out.println(sb.toString());
    }
}
