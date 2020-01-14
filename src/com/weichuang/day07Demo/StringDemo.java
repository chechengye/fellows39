package com.weichuang.day07Demo;

import org.junit.Test;

import java.util.Arrays;

/**
 * String ： 讲解
 *
 * 面试题:
 *  String s2 = new String("小吴");
 *  首先它会去常量池中查找有没有此字符串存在，若存在，不会在常量池中新创建对象
 *  但是它会在堆中新申请内存空间，并指向此常量池中的对象。若不存在，它会先在常量池中
 *  创建此字符串对象，之后它还会在堆中新申请内存空间，并指向此常量池中的对象
 */
public class StringDemo {

    public static void main(String[] args) {
        String s1 = "小吴";
        String s2 = new String("小吴");
        String s3 = "小吴";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        //如果编译期可确定的值，会直接计算、但是运行期才可以确定的值，就不会直接计算
        String a = "1";
        String a1 = "a" + a;
        String a2 = "a1";
        System.out.println(a1 == a2);

        //常量编译器即可确定，参与运算
        final String b = "1";
        String b1 = "b" + b;
        String b2 = "b1";
        System.out.println(b1 == b2);

        String c = getC();//只要是方法必须运行时才会参与运算
        String c1 = "c" + c ;
        String c2 = "c1";
        System.out.println(c1 == c2);

        final int i; //final赋值方式可以后赋值，有两种情况，
        // 1、直接等于一个方法的方式 2、构造方法赋值
        final String d  = getD();
        String d1 = "d" +d;
        String d2 = "d1";
        System.out.println(d1 == d2);
    }

    /**
     * String常用的api
     */
    @Test
    public void testFn(){
        String str = " 273362-jdhs  jdh-jfdbfndfd ";
        char c = str.charAt(6); //根据索引取字符
        System.out.println(c);
        char[] chars = str.toCharArray();
        System.out.println("------------------------");
        System.out.println(Arrays.toString(chars));
        System.out.println("------------------------");
        char[] char1 = {'a' , 'f' , 'g' , 'h'};
        String str2 = new String(char1 , 0 , 3);
        System.out.println(str2);
        System.out.println("------------------------");
        System.out.println(str.startsWith("273" , 3));
        System.out.println("------------------------");
        System.out.println(str.replace('3','*'));
        System.out.println("------------------------");
        System.out.println(str.replaceAll("\\d", ""));
        System.out.println("------------------------");
        System.out.println(str.replaceFirst("\\d", ""));
        System.out.println("------------------------");
        System.out.println(str.substring(4));
        System.out.println("------------------------");
        System.out.println(str.substring(4, 8));//不包含结束索引位置.
        System.out.println("------------------------");
        System.out.println(Arrays.toString(str.split("-")));//拆分成数组，但不包含拆分字符
        System.out.println("------------------------");
        System.out.println(str.contains("-"));
        System.out.println("------------------------");
        System.out.println(str.indexOf("-", 10));
        System.out.println("------------------------");
        System.out.println(str.lastIndexOf(6));
        System.out.println("------------------------");
        System.out.println(str.toUpperCase());//全部转成大写
        System.out.println("------------------------");
        System.out.println(str.toLowerCase());
        System.out.println("------------------------");
        System.out.println(str.trim());
    }

    public static String getC() {
        return "1";
    }

    public static String getD() {
        return "1";
    }
}
