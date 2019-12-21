package com.weichuang.day04Demo;


import org.junit.Test;

import java.util.Arrays;

public class ProgramExample {

    static int i = 10;

    public static void main(String[] args) {
      /*  System.out.println(i);
        STest.eat();
        STest sTest = new STest();
        STest sTest1 = new STest();
        STest sTest2 = new STest();
        STest sTest3= new STest();
        System.out.println(sTest1.count);
        sTest.say();*/
        //String[] args1 = {"22","22"};//new String[3]
        System.out.println(args.length);
        for(String x : args){
            System.out.println(x);
        }
    }


    @Test
    public void testFn(){
       // Person p = new Person("lisi");
        System.out.println(Person.class);
        //Person.eat(20);
        try {
            Class.forName("com.weichuang.day04Demo.Person" , false , ClassLoader.getSystemClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /*p.eat(10);
        Person p1 = new Person("zhangsan");*/
    }

    /**
     * 测试单例模式方法
     */
    @Test
    public void testFn1(){
        SingleTon1 s = SingleTon1.getInstanceSingleton();
        SingleTon1 s1 = SingleTon1.getInstanceSingleton();
        System.out.println(s == s1);
    }

    /**
     * 鸡舍测试方法
     */
    @Test
    public void testFn2(){
        ChickenManager cm = new ChickenManager();
        cm.add(new Chicken(1, "咕咕鸡" , 2 , "黄色"));
        cm.add(new Chicken(2 ,"尖椒鸡" , 1 , "红色"));
        cm.add(new Chicken(3,"小鸡" , 3 , "白色"));
        cm.add(new Chicken(4,"家养鸡" , 2 , "黑色"));
        cm.add(new Chicken(5,"家养鸡1" , 2 , "黑色"));
        cm.printAll();
        System.out.println("-------------------");
        /*cm.update(new Chicken(2 ,"修改鸡" , 7 , "蓝色"));
        cm.printAll();
        System.out.println("-------------------");
        System.out.println(cm.getChickenById(5));*/
        cm.delete(2);
        cm.printAll();
    }
}

/**
 * 静态static关键字使用
 */
class STest{
    static int i = 20;
    int a = 20;

    public int count = 0;
    public STest(){
        count ++;
    }
    public static void eat(){

        System.out.println("eat..." + i);
        //say();
    }
    public void say(){

        System.out.println("say..." + this.a);
    }
}

/**
 * 代码块
 */
class Person{

    static {
        System.out.println("静态代码块");
    }

    public Person(){
        System.out.println("构造方法!");
    }

    public Person(String name){
        System.out.println("带参构造方法!" +name);
    }

    //在类里直接定义的代码块叫构造代码块
    {
        System.out.println("构造代码块!");
    }
    public static void eat(int a){
        System.out.println("eat...." + a);
        //普通代码块
        {
            int i = 1;
            System.out.println("普通代码块!" + a);
        }
    }
}
/**
 * 单例设计模式(懒汉式)
 * 1、必须让构造方法私有化
 * 2、提供一个实例化属性
 * 3、对外暴露获取对象接口
 * (饿汉式)
 * 1、必须让构造方法私有化
 * 2、开始置为null的对象
 * 3、对外暴露获取对象接口，并判空实例化
 * */
class SingleTon{
    private SingleTon(){}
    private static SingleTon singleTon = new SingleTon();
    public static  SingleTon getInstanceSingleton(){
        return singleTon;
    }
}
class SingleTon1{
    private SingleTon1(){}
    private static SingleTon1 singleTon = null;
    public static  SingleTon1 getInstanceSingleton(){
        if(singleTon == null){
            singleTon = new SingleTon1();
        }
        return singleTon;
    }
}

/**
 * Chicken鸡舍管理相关
 */
class Chicken{
    private int id;
    private String name;
    private int month;
    private String color;

    public Chicken() {}

    public Chicken(int id , String name, int month, String color) {
        this.name = name;
        this.month = month;
        this.color = color;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void print(){
        System.out.println("name = " + this.name + ",month = " + this.month + ",color = " + this.color);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "name='" + name + '\'' +
                ", month=" + month +
                ", color='" + color + '\'' +
                '}';
    }
}
/**
 * 小鸡的管理类
 */
class ChickenManager{
    private Chicken[] chickens = new Chicken[5];
    private int count = 0;
    /**
     * 添加方法
     */
    public void add(Chicken c){
        if(count == chickens.length){
            chickens = Arrays.copyOf(chickens , chickens.length * 2);
        }
        chickens[count ++] = c;
    }
    /**
     * 修改一只鸡
     */
    public void update(Chicken c){
       /* for(int i = 0 ; i < count ; i++){
            if(c.getId() == chickens[i].getId()){
                chickens[i] = c;
            }
        }*/
        for(Chicken cc : chickens){
            if(cc.getId() == c.getId()){
                //cc = c;
                cc.setName(c.getName());
                cc.setColor(c.getColor());
                cc.setMonth(c.getMonth());
                cc.setId(c.getId());
            }
        }
    }
    /**
     * 查询一只鸡
     */
    public Chicken getChickenById(int id){
        for(Chicken cc : chickens){
            if(null != cc){
                if(cc.getId() == id){
                    return cc;
                }
            }
        }
        return null;
    }

    /**
     * 删除一只鸡
     */
    public void delete(int id){
        for(int i = 0 ; i < count ; i++){
            if(id == chickens[i].getId()){
                //chickens[i] = null;
                for(int j = i + 1 ; j < count ; j ++){
                    chickens[j-1] = chickens[j];
                }
            }
        }
        //System.out.println("count = " + count);
        chickens[--count] = null;//置空最后一个位置的鸡，并鸡舍减少一只
    }

    /**
     * 打印所有鸡
     */
    public void printAll(){
        for(Chicken c : chickens){
            System.out.println(c);
            /*if(null != c){
                c.print();
            }*/
        }
    }
}
