package com.weichuang.day08Demo;

import java.util.Comparator;

/**
 * Comparator bird单独的比较器对象
 *
 * 面试题：
 * 1、自定义对象可不可以进行排序
 * Comparable 或 单独创建自定义对象的比较器
 * 2、Comparator 与 Comparable的优缺点
 * OO原则 ： 对修改关闭，对扩展开发
 */
public class BirdComparator implements Comparator<Bird> {

    @Override
    public int compare(Bird b1, Bird b2) {
        return b1.getAge() - b2.getAge();
    }
}
