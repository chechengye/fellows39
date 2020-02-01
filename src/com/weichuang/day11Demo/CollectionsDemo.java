package com.weichuang.day11Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections工具类使用
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");
        list.add("4");
        list.add("2");

        //排序相关
        //反转
        //Collections.reverse(list);
        //洗牌
        //Collections.shuffle(list);
        //交换
        //Collections.swap(list , 0 , 2);
        //循环移动一定的位数，若移动位数为集合大小，那结果保持不变
        Collections.rotate(list , 4);
        System.out.println(list);
        System.out.println("----------------------------");
        //查找与替换相关
        System.out.println(Collections.binarySearch(list, "3"));
        System.out.println(Collections.max(list));
        //集合中某个元素出现的次数
        System.out.println(Collections.frequency(list , "2"));
        //将老值全部替换为新值
        Collections.replaceAll(list , "2" ,"8");
        System.out.println(list);
        System.out.println("--------------同步控制---------------");
        //将原list加锁变为线程安全了,上锁的原理就是将原来所有的方法添加synchronized代码块加锁
        List<String> syncList = Collections.synchronizedList(list);
        System.out.println("-----------------设置不可变集合-------------------");
        List<Object> emptyList = Collections.emptyList();
        emptyList.add("test");
        System.out.println(emptyList);
    }
    public List<String> getData(){
        List<String> list = null;
        return null;
    }
}
