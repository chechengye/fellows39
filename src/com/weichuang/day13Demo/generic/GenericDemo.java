package com.weichuang.day13Demo.generic;

import org.junit.Test;

import java.util.*;

public class GenericDemo {

    public static void main(String[] args) {
        //<String> ： 称为参数化类型
        List<String> list = new ArrayList<>();//... = new ArrayList<>(); //... = new ArrayList();
        list.add("vince");//"vince"  : 类型实参
        list.add("bin");
        //list.add(100);   // 提示编译错误
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i); // 2
            System.out.println("name:" + name);
        }
        //可变参数方法调用
        printMsg(10 , "zhangsan" , 0.1f);
    }

    @Test
    public void testFn(){
        //T被参数化类型决定
        Node<Number> n1 = new Node<>(10,3);
        Node<Integer> n2 = new Node<>(10,5);
        Node<String> n6 = new Node<>("20",8);
        Number n3 = 10;
        Integer n4 = 10;
        //n4 = n3;
        n3 = n4;
        //n1 = n2;不支持，类型不匹配
        //method1(n1);
        //method2(n2);//Integer 是Number的子类
        method3(n2);
        method3(n1);
        //method3(n6); String 不是 Integer的父类不允许此操作
        method1(n6);
        System.out.println(n1.getData());
        System.out.println("--------------------------");
        String[] arr = {"tom","jack","lily","lucy"};
        Integer[] arr1 = {10 , 20 , 30 ,50};
        System.out.println(Arrays.toString(func(arr1, 0, 2)));

    }

    /**
     * node : 形参
     * @param node
     */
    private void method(Node<Number> node){
        System.out.println(node.getData());
    }

    /**
     * ？ 通配符
     * @param node
     */
    private void method1(Node<?> node){
        //node.setData("28sd");通配符？的方式不允许对跟参数有关的修改操作
        System.out.println(node.getData());//可以调用与参数无关的方法
    }
    //设置了一个上线 Number及其子类就可以
    private void method2(Node<? extends Number> node){
        //node.setData(new Integer(10));
        System.out.println(node.getData());
    }
    //设置一个下限 Integer及其父类
    private void method3(Node<? super Integer> node){
        System.out.println(node.getData());
    }
    //可变参数的泛型方法
    public static <T> void printMsg(T... args){
        for(T s : args){
            System.out.println(s);
        }
    }
    //任意类型的数组，交换其中的两个数
    public static <T> T[] func(T[] arr , int i , int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
    @Test
    public void testFn1(){
        //自定义循环嵌套
        School<Student> s = new School<>(new Student<>("98"));
        System.out.println(s.getStu().getCore());
        Map<Integer , String> map = new HashMap<>();
        map.put(1 , "飞飞");
        map.put(2 , "备备");
        map.put(3 , "关关");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        entries.forEach(e-> System.out.println(e.getKey() + "->" + e.getValue()));
    }
}
