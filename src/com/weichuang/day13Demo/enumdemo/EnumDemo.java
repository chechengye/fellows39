package com.weichuang.day13Demo.enumdemo;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * 枚举相关在JDK 1.5
 */
public class EnumDemo {
    public static final int RED = 0x1;
    public static final int GREEN = 0x2;
    public static final int BLUE = 0x3;
    private static int color;

    public static void main(String[] args) {
        color = RED;
        color = 4; //普通的常量的方式，限制不了值的取值范围所以引入枚举的概念
    }
    private Color enumColor;
    @Test
    public void testFn(){
        enumColor = Color.GREEN;
        //enumColor = Color.GREEN;
        System.out.println(enumColor);
        System.out.println(enumColor.name());//枚举的名称
        System.out.println(enumColor.ordinal());//序列号
        Color[] colors = Color.values();
        System.out.println(Arrays.toString(colors));
        switch (enumColor){
            case RED: //枚举中的元素,枚举对象
                System.out.println("是红色");
                break;
            case GREEN:
                System.out.println("是绿色");
                break;
        }
    }

    @Test
    public void testFn1(){
        //操作枚举相关比hashmap更高效
        EnumMap<Color , Integer> enumMap = new EnumMap<>(Color.class);
        enumMap.put(Color.RED , 0x1);
        enumMap.put(Color.GREEN , 0x2);
        enumMap.put(Color.BLUE , 12);
        enumMap.forEach((k,v)-> System.out.println(k+"->" + v));


        EnumSet<Color> enumSet = EnumSet.allOf(Color.class);
        enumSet.forEach(System.out::println);
    }

    @Test
    public void testFn2(){
        System.out.println(Color.RED.getName() + "--" + Color.RED.getVal());
    }
}
