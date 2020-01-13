package com.weichuang.day08Demo;

import java.util.Arrays;

/**
 * 对象比较器
 */
public class ComparableDemo {

    public static void main(String[] args) {
        int[] a = {1,5,2,11,8};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("--------字符串数组-------");
        String[] strs = {"tom","jack","lucy","lily"}; //纯英文字符串按字母的自然顺序排序
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        String[] strsZH = {"贝贝","喵喵","花花"};//纯中文安装自己的特定排序算法计算（ASCII）
        Arrays.sort(strsZH);
        System.out.println(Arrays.toString(strsZH));
        System.out.println("------------自定义对象数组可不可以进行sort直接排序--------------");
        Bird[] birds = {new Bird("黄鹂" , 3) , new Bird("麻雀" , 1) , new Bird("鹦鹉",5)};
        Arrays.sort(birds , new BirdComparator());
        System.out.println(Arrays.toString(birds));

    }
}
