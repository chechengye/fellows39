package com.weichuang.day10Demo;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        hashMap();
    }

    /**
     * hashMap
     * 实现原理:
     * 1、默认的加载因子为0.75f ，默认的容量大小为16
     * 2、采用哈希表（散列队列 数组+链表 + 红黑树  jdk 1.8之后 二叉树结构（红黑树:所有的节点除了红就是黑）平衡二叉树节点比较统一
     *    ; jdk 1.8版本之前就是数组+链表）的结构
     * 3、当容量达到75%的开始扩容
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
