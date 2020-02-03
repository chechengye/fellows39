package com.weichuang.day13Demo.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

    public static void main(String[] args) {
        String s = "5201314";
        char[] chars = s.toCharArray();
        boolean flag = true;
        for(char c : chars){
            if(c > '9' || c < '0'){//ASCII判断
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("全是数字组成");
        else System.out.println("包含了非数字的字符");
    }
    @Test
    public void testFn(){
        String str = "aaaaaaaaab";
        Pattern p = Pattern.compile("a*b");//匹配到0个或多个a + b
        Matcher matcher = p.matcher(str);
        System.out.println(matcher.matches());
    }

    @Test
    public void testFn1(){
        String s = "5201314";
        System.out.println(s.matches("\\d+"));
        System.out.println(s.matches("[0-9]+"));
    }

    @Test
    public void testFn2(){
        //1、验证电话号码
        String s1 = "010-36437431";
        System.out.println(s1.matches("^\\d{3,4}[-]\\d{8,9}$"));
        System.out.println("--------------------");
        //2、验证手机号码
        String s2 = "13845153789";
        System.out.println(s2.matches("^[1][3-9]\\d{9}$"));
        System.out.println("--------------------");
        //3、验证用户名，只能是字母开头的，数字、字母或下划线的组合 最大长度为13小于13
        String s3 = "abc_12345";
        System.out.println(s3.matches("^[a-zA-Z][\\w]{1,13}$"));
        System.out.println("--------------------");
        //4、验证邮箱(如:zhangsan_wc@163.com)
        String s4 = "zhangsan_wc@163.com";
        System.out.println(s4.matches("^[a-zA-Z0-9]+[\\w]*[@][a-zA-Z0-9]{2,3}[.][a-zA-Z]{2,6}$"));
        System.out.println("--------------------");
        //5、验证年龄（100以内）
        String s5 = "11";
        System.out.println(s5.matches("^[\\d]{1,2}"));
        
    }
}
