package com.weichuang.day09Demo;

import java.util.*;

/**
 * Collection
 * 直接子类
 * List 有序的、可存入重复值、可以放多个null
 * ArrayList 、 LinkedList 、 Vector
 * List的子类在实际开发中什么时候使用呢?
 *
 * ArrayList : 有序的集合做过多的查询操作
 * LinkedList ： 有序的集合做过多的插入与删除操作
 * Vector : 多线程的时候建议使用
 *
 * set
 * HashSet 、TreeSet 、 LinkedHashSet
 * Set在实际开发中怎么使用的？
 * 需要有序的话 LinkedHashSet
 * 自然排序 TreeSet
 * 排序以上两种需求后使用HashSet
 */
public class CollectionDemo {


    public static void main(String[] args) {
        //arrayList();
        //vector();
        //linkedList();
        //hashSet();
        //treeSet();
        linkedHashSet();
    }

    /**
     * LinkedHashSet实现原理
     * 1、HashSet的子类，采用哈希表（链表+数组） 与 双重链表的数据结构
     * 2、可以保证有序的
     */
    public static void linkedHashSet(){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("tom");
        linkedHashSet.add("aom");
        linkedHashSet.add("lucy");
        linkedHashSet.add("lily");
        for(String n : linkedHashSet){
            System.out.println(n);
        }
    }
    /**
     * TreeSet实现原理
     * 1、采用二叉树的数据结构，基于TreeMap的实现
     * 2、可以帮我们按自然顺序排序，树形结构可以进行排序
     * 3、自定义类，按照自定义规则排序的时候，若比较器返回的值为0的情况下
     *    ，直接认为两个对象是相同的对象。
     * 4、储存值的时候，使用的是map，值为map的key而value为Object对象站位
     * 5、允许重复，但会自动去重
     */
    public static void treeSet(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(100);
        treeSet.add(50);
        treeSet.add(66);
        treeSet.add(50);
        System.out.println(treeSet.size());
        for(Integer i : treeSet){
            System.out.println(i);
        }

        TreeSet<Dog> dogTreeSet = new TreeSet<>(new DogComparator());
        dogTreeSet.add(new Dog(10 , 1 , "大黄"));
        dogTreeSet.add(new Dog(30 , 2 , "小白"));
        dogTreeSet.add(new Dog(20 , 3 , "小黑"));
        dogTreeSet.add(new Dog(10 , 4 , "泰迪"));
        for(Dog dog : dogTreeSet){
            System.out.println(dog);
        }
    }

    /**
     * HashSet实现原理
     * 1、采用的哈希表（散列队列）真正实现是基于HashMap
     * 2、储存值的时候，使用的是map，值为map的key而value为Object对象站位
     * 3、它是无序的，但并不能保证顺序恒久不变
     * 4、确定前后两个元素是否一致的条件 : hashcode()与equals()方法都相等
     * 5、不允许重复
     */
    public static void hashSet(){

        /*
        Set<String> set = new HashSet<>();
        set.add("tom");
        set.add("lucy");
        set.add("lily");
        set.add("jack");
        set.add("lucy");
        for(String s : set){
            System.out.println(s);
        }*/
        Set<Cat> catSet = new HashSet<>();
        Cat c1 = new Cat();
        c1.setAge(1);
        c1.setName("喵喵");
        Cat c2 = new Cat(5 , "花花");
        Cat c3 = new Cat(2 , "无话");
        Cat c4 = new Cat(5 , "花花");
        catSet.add(c1);
        catSet.add(c2);
        catSet.add(c3);
        catSet.add(c4);
        System.out.println(catSet.size());
        for(Cat c : catSet){
            System.out.println(c);
            System.out.println(c.hashCode());
        }

        //System.out.println(set.size());
    }

    /**
     * LinkedList实现原理
     * 1、采用双向链表的数据结构
     * 2、调用只添加一个元素的add方法的时候默认使用尾插法添加元素
     * 3、做频繁的插入与删除的时候推荐使用
     * 4、线程不安全的，建议单线程时使用
     */
    public static void linkedList(){
        List<String> list = new LinkedList<>();
        list.add("飞飞");
        list.add("备备");
        list.add("关关");
        list.add("亮亮");
        for(String s : list){
            System.out.println(s);
        }
    }
    /**
     * Vector实现原理
     * 1、调用默认的无参构造方法，直接初始化10个容量大小的数组
     * 2、扩容原理：若增量为0时，扩展到原来数组大小的2倍，否则原来数组容量加上增量
     * 3、采用的动态数组
     * 4、不适合做频繁的插入与删除
     * 5、线程安全的，适合多线程时使用。
     */
    public static void vector(){
        List<String> v = new Vector<>(20 , 10);
        v.add("飞飞");
        v.add("备备");
        v.add("关关");
        v.add("亮亮");
        for (String n : v ) {
            System.out.println(n);
        }

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
