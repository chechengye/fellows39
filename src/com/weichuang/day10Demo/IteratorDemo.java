package com.weichuang.day10Demo;

import com.weichuang.day09Demo.Cat;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class IteratorDemo {

    public static void main(String[] args) {
        //iterator();
        //enumeration();
        //foreach();
        /*String upperStr = function("function-test", str -> str.toUpperCase());
        System.out.println(upperStr);*/
        /*Function<String, String> fn = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        String str = function("shdhs", fn);*/
        List<Integer> list = supplier(10, () -> (int) (Math.random() * 100));
        list.forEach(System.out::println);
    }

    /**
     * Supplier<T>接口	代表结果供应商。
     */
    public static List<Integer> supplier(int num , Supplier<Integer> sp){
        List<Integer> list = new ArrayList<>(10);
        for(int i = 0 ; i < num ; i++){
            list.add(sp.get());
        }
        return list;
    }
    /**
     * Function<T,R> 接口	表示接受一个参数并产生结果的函数。
     */
    public static String function(String str , Function<String , String> fn){
        return fn.apply(str);
    }
    /**
     * foreach : jdk 1.5之后推荐使用的，更方便操作的，且支持1.8新特性
     * Consumer<T>接口	消费者接口
     */
    public static void foreach(){
        List<String> list = new ArrayList<>();
        list.add("tom");
        list.add("lucy");
        list.add("lily");
        list.add("jack");
        //list.forEach(name->System.out.println(name));
        list.forEach(System.out::println);//不推荐使用，可读性太差,且要求过多
    }

    public static void enumeration(){
        Vector<String> v = new Vector<>();
        v.add("tom");
        v.add("lucy");
        v.add("lily");
        v.add("jack");
        Enumeration<String> elements = v.elements();
        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }
    }

    /**
     * iterator 方法 jdk 1.5版本前经常使用
     */
    public static void iterator(){
        List<String> list = new ArrayList<>();
        list.add("tom");
        list.add("lucy");
        list.add("lily");
        list.add("jack");

        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
