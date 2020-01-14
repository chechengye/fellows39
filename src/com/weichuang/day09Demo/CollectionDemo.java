package com.weichuang.day09Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Collection
 * 直接子类
 * List 有序的、可存入重复值、可以放多个null
 * ArrayList 、 LinkedList 、 Vector
 *
 * set
 */
public class CollectionDemo {


    public static void main(String[] args) {
        arrayList();
    }

    /**
     * ArrayList
     * 实现原理: 结构（动态数组）
     * 1、使用无参的构造方法，实例化对象的时候，它帮我们分配了一个空间为0的数组
     * 2、当第一次加入元素时，容量大小扩容为10.
     * 3、扩容原理： 初始容量为10，但元素增加到10以上之后，扩充为 = 原来数组大小 + 原来数组大小 >> 1
     * 4、适合查询与更新操作 ,不合适插入与删除操作，即使有api可以直接操作索引，但ArrayList要保证存入顺序性
     *    就要做整体移动(特别耗时)。
     * 5、线程不安全，仅适合在单线程中使用
     * 6、建议使用时传入初始容量，为了减少动态扩容的次数
     */
    public static void arrayList(){
        //若不限制存入类型，就需要强制类型转换麻烦，所以引入泛型检查
        //jdk 1.7版本之后 主动加上子类的<>泛型符号,但类型已经可以由前面的确定了。
        // 所以可以省略不写
        List<String> list = new ArrayList<>();
        list.add("飞飞");
        list.add("备备");
        list.add("关关");
        list.add("亮亮");
        list.add("备备");

        list.set(2 , "测试");
        list.remove(2);
        System.out.println("-----------索引遍历---------");
        //1、根据索引遍历
        int size = list.size();
        for(int i = 0 ; i < size ; i ++){
            if(null != list.get(i)){
                System.out.println(list.get(i));
            }
        }
        System.out.println("-----------foreach遍历---------");
        //2、foreach遍历
        for(String s : list){
            System.out.println(s);
        }
        System.out.println("-----------方法遍历---------");
        //3、toArray()方法遍历
        String[] strs = list.toArray(new String[]{});
        System.out.println(Arrays.toString(strs));
        //4、ListIterator

    }
}
