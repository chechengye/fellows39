package com.weichuang.day02Demo;

import org.junit.Test;

public class ProgramExample {

    private int a;
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

    /**
     * 数组的定义
     */
    @Test
    public void testFn1(){
        int s1 = 20180206;
        int s2 = 20180305;
        //int s1 = 20193213;
        int[] students = new int[50];
        //1、面的初始化方式为动态初始化数组,索引从0开始
        students[0] = 20180206;
        students[1] = 20180305;
        int len = students.length;
        System.out.println(len);
        int[] students2;
        students2 = new int[50];
        //2、先定义，后分配空间
        int[] students3 = new int[]{1,2,3,4,5};
        //3、静态初始化、直接赋值决定空间大小
        System.out.println(students3.length);
        int[] students4 = {1,2,3,4};
        //4、静态初始化，上面第三种的简单写法。比较常用
        System.out.println(students4.length);
        //java抛出异常，数组越界异常(java.lang.ArrayIndexOutOfBoundsException: 4) ,0,1,2,3
        System.out.println(students4[students4.length - 1]);

        for(int i = 0 ; i < len ; i ++){
            students[i] = s1 + i;
            int s = students[i];
            System.out.println(s);
        }

    }

    /**
     * foreach循环
     */
    @Test
    public void testFn2(){
        int[] array = {43,22,11,33,22};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        //foreach语法 int x:x的类型必须是你数组封装类型。场景，你不需要应用数组的索引做操作的时候即可使用此方式
        for (int x : array) {
            System.out.println(x);
        }

    }

    /**
     * 可变参数
     * 可变参数位置，必须放在方法里面的最后一个参数位置
     */
    @Test
    public void testFn3(){
        sortArray(10 , 11, 22, 12);
    }

    public void sortArray(int b , int... a){
        System.out.println(b);
        for(int x : a){
            System.out.println(x);
        }
    }

    /**
     *
     * 空指针异常（NullPointerException）
     * 数组越界异常（ArrayIndexOutOfBoundsException ）
     */
    @Test
    public void testFn4(){
        int[] array = {43,22,11,33,22};
        for(int i = 0 ; i < array.length ; i++){
            System.out.println(array[i]);
        }
        int[] arrays = getStudentsNo();
        System.out.println(arrays[1]);
    }
    public int[] getStudentsNo(){
        int[] arrays = null;

        return arrays;
    }
}
