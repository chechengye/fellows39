package com.weichuang.day10Demo;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        //hashMap();
        //hashtable();
        //linkedHashMap();
        treeMap();
    }

    /**
     * treeMap实现原理
     * 1、有序的，可以按照自然顺序排序，若自定义的对象必须实现比较器接口
     *      ，告诉它排序规则
     * 2、自定义比较器可通过构造方法传入，但定义原则相同时，即为key值相同仅替换value
     * 3、采用二叉树（红黑树）
     */
    public static void treeMap(){
       /* Map<Integer , String> map = new TreeMap<>();
        map.put(3 , "飞飞");
        map.put(1 , "备备");
        map.put(5 , "贝贝");
        map.put(7 , "关关");
        map.forEach((k,v)-> System.out.println(k+"->"+v));*/
        Map<Dog , String> map = new TreeMap<>(new DogComparator());
        Dog d2 = new Dog(5 , "毛毛" , 2);
        Dog d3 = new Dog(16 , "发财" , 3);
        Dog d1 = new Dog(11 , "球球" , 1);
        Dog d4 = new Dog(5 , "多多" , 4);
        map.put(d1 , "dog1");
        map.put(d2 , "dog2");
        map.put(d3 , "dog3");
        map.put(d4 , "dog4");
        map.forEach((k , v)-> System.out.println(k + "->" + v));
    }
    /**
     * linkedHashMap
     * 1、有序的，存储的顺序排列
     * 2、哈希表（数组+链表）双重链表
     * 3、线程不安全的
     */
    public static void linkedHashMap(){
        Map<String , String> map = new LinkedHashMap<>();
        map.put("one" ,"tom");
        map.put("two" , "lucy");
        map.put("three" , "lily");
        map.forEach((k,v)-> System.out.println(k + "->" +v));
    }
    /**
     * hashtable无序的
     * 1、默认的初始容量为11，加载因子为0.75
     * 2、采用哈希表（数组+链表）
     * 3、当容量达到75%时扩容为原来的2倍+1
     * 4、线程安全的，适合多线程下使用
     */
    public static void hashtable(){
        Map<String , String> map = new Hashtable<>();
        map.put("one" ,"tom");
        map.put("two" , "lucy");
        map.put("three" , "lily");
        //map.put("one" ,"jack");
        map.forEach((k,v)-> System.out.println(k + "->" +v));
    }

    /**
     * hashMap
     * 实现原理:
     * 1、默认的加载因子为0.75f ，默认的容量大小为16
     * 2、采用哈希表（散列队列 数组+链表 + 红黑树  jdk 1.8之后 二叉树结构（红黑树:所有的节点除了红就是黑）平衡二叉树节点比较统一
     *    ; jdk 1.8版本之前就是数组+链表）的结构
     * 3、当容量达到75%的开始扩容,当数组中节点的个数超过8的时候引入的红黑树。扩容方式为原来的2倍
     * 4、线程不安全的适合单线程中使用
     */
    public static void hashMap(){
        Map<Integer , String> map = new HashMap<>();
        map.put(1 , "飞飞");
        map.put(2 , "备备");
        map.put(3 , "关关");
        //map.put(1 , "亮亮");
        System.out.println(map.size());
        //1、entrySet方式
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

        System.out.println(entrySet.size());
        /*Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        entrySet.forEach(entry->System.out.println(entry.getKey() + "->" + entry.getValue()));
        System.out.println("--------------------------------");
        //2、keySet() 方式
        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet){
            System.out.println(key + "->" + map.get(key));
        }
        System.out.println("--------------------------------");
        //3、values() 方式
        Collection<String> values = map.values();
        values.forEach(System.out::println);
        System.out.println("--------------------------------");
        //4、直接调用默认的foreach方法
        map.forEach((k , v)-> System.out.println(k + "->" +v));
        int code = 54554;
        System.out.println(code ^ 0);
        System.out.println(code & 15);
    }
}
