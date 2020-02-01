package com.weichuang.day11Demo;

import java.util.HashMap;
import java.util.Map;

/**
 * jdk1.8之后map中加入的新方法
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer , String> map = new HashMap<>();
        map.put(1 , "tom");
        map.put(2 , "lucy");
        map.put(3 , "lily");
        //System.out.println(map.get(2));
        //根据key获取值，取不到给一个默认值
        System.out.println(map.getOrDefault(5, "no val"));
        //若key值不存在值则放入
        map.putIfAbsent(4 , "jack");
        //键与值必须同时满足时，才进行删除
        map.remove(2 , "zhangsan");
        //根据键与值同时匹配之后替换原来的值
        map.replace(3 , "lily1" , "wangwu");
        //将原来的值进行计算返回赋值
        String val = map.compute(1, (k, v) -> v + 1);
        System.out.println(val);
        map.computeIfAbsent(5 , oldVal ->oldVal+"test");
        //将一个新值与老的值进行操作之后赋值给老值
        map.merge(2 , "888" , (oldVal , newVal)->oldVal + newVal);
        map.forEach((k,v)-> System.out.println(k + "->" + v));

    }
}
