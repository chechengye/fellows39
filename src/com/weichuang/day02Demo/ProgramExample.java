package com.weichuang.day02Demo;

import org.junit.Test;

public class ProgramExample {

    /**
     * 方法定义
     */
    @Test
    public void testFn(){
        /*int menuSize = getMenu();
        System.out.println(menuSize);*/
        long s = 1;
        String order = getOrder((int)s);
        //String order1 = getOrder(2);
        //System.out.println(order);
        printAn("8");
    }

    /**
     * void:空返回
     * 8种基本数据类型
     * 引用类型
     *
     * public : 方法体权限访问修饰符
     * private: 私有的,只有本类中的方法才可以调用
     * static : 其它修饰符，静态的
     * int : 方法的返回值
     * getMenu: 方法名，驼峰命名法
     * int a: 形参  10：实参
     *
     * 实参和形参的类型要相互兼容，
     * 且：实参的取值范围要小于或者等于形参类型的取值范围。
     */
    public static void getMenu(){
        System.out.println("1.锅包肉");
        System.out.println("2.鱼香肉丝");
        return;
        //System.out.println("3.剁椒鱼头");
    }

    public String getOrder(int a){
        String str = "";
        switch (a){
            case 1:
                str += "1.锅包肉";
               return str;
            case 2:
                str += "2.鱼香肉丝";
                break;
            case 3:
                str += "3.剁椒鱼头";
                break;
        }
        return str + "dsdsds";
    }

    /**
     * 根据传入的参数打印直角三角形
     * 重载:1、方法名称必须相同
     * 2、参数类型与参数数量的不同才能决定重载条件成立
     * 3、返回值类型不同不可以作为方法重载条件
     */
    public void printAn(int num){
        for(int i = 1 ; i <= num ; i++){
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

   /* public String printAn(int num){
        for(int i = 1 ; i <= num ; i++){
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        return "";
    }*/
    public void printAn(int num , int sum){
        for(int i = 1 ; i <= num ; i++){
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printAn(String num){
        for(int i = 1 ; i <= Integer.valueOf(num) ; i++){
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
