package com.weichuang.day05Demo;

import org.junit.Test;

import java.util.Arrays;

public class ProgramExample {

    @Test
    public void testFn(){
        Chicken ck = new Chicken();
        ck.sing("黄色");
        //System.out.println(ck.name);
        HomeChicken hc = new HomeChicken();
        //hc.eat();
        hc.sing("灰色");
        YjChicken yjChicken = new YjChicken();
        yjChicken.sing("五颜六色");
    }
    /**
     * 化妆品管理测试
     */
    @Test
    public void testFn1(){
        /*CosmeticManager cm = new CosmeticManager();
        cm.add(new Cosmetic("雅诗兰黛" , 88 , "进口"));
        cm.add(new Cosmetic("大宝" , 3 , "国产"));
        cm.add(new Cosmetic("曼秀雷敦" , 33 , "进口"));
        cm.printAll();*/
        SortCosmeticManager cm = new SortCosmeticManager();
        cm.add(new Cosmetic("雅诗兰黛" , 88 , "进口"));
        cm.add(new Cosmetic("大宝" , 3 , "国产"));
        cm.add(new Cosmetic("曼秀雷敦" , 33 , "进口"));
        cm.add(new Cosmetic("测试" , 11 , "进口"));
        cm.printAll();
    }
}

/**
 * 继承相关
 * 1、子类不可以继承多个类，只能单继承
 * 2、但可以多层继承
 */
class Animal{
    protected int age;
    protected String name;
    public Animal(){}
    public Animal(String name){
        System.out.println(name + "Animal的构造方法");
    }

    public void eat(){
        System.out.println("吃东西...");
    }
}
class Person{

}

/**
 * 子类
 */
class Chicken extends Animal{
    public Chicken(){
        super("小鸡");
    }
    public Chicken(String name){
        super(name);
        //显示调用构造方法，和this必须放在第一行&都可以调用构造方法。
        // 但是this代表调用者对象、而super引用的是调用者的父类的对象
        //this调用本类对象的构造方法，而super调用的是父类的构造方法

        System.out.println(name + "吃东西..." + super.age);
    }
    public  void sing(String color){
        System.out.println("勾勾叫..." + color);
        super.eat();
    }
}
/**
 * 多层继承
 */
class HomeChicken extends Chicken{
    public HomeChicken(){
        super("家鸡");
        System.out.println("HomeChicken的构造方法");
    }

    /**
     * 方法重写
     * 1、子类重写的方法的修饰符权限要高于父类方法的修饰符
     * 2、返回值一模一样
     * 3、方法名称相同
     * 4、参数个数与类型必须同一致
     */
    /*public void sing(String color){
        System.out.println("唱歌..." + color);
    }*/
}
class YjChicken extends Chicken{

    public void sing(String color){
        System.out.println("动人的声音..." + color);
    }
}


/**
 * 化妆品管理实例
 * 使用继承操作
 */
class Cosmetic{
    private String name;
    private int price;
    private String type;

    public Cosmetic(String name, int price, String type) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cosmetic{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
/**
 * 使用继承实现一个可按单价排序输出所有化妆品的功能
 */
class SortCosmeticManager extends CosmeticManager{
    /**
     * 重新打印方法
     */
    public void printAll(){
        //选择排序  minIndex
        for(int i = 0 ; i < count ; i++){
            int minIndex = i;
            for(int j = i + 1 ; j < count ; j++){
                if(cosmetics[minIndex].getPrice() > cosmetics[j].getPrice()) minIndex = j;
            }
            if(minIndex != i){
                Cosmetic cosmetic = cosmetics[minIndex];
                cosmetics[minIndex] = cosmetics[i];
                cosmetics[i] = cosmetic;
            }
        }
        for(Cosmetic c : cosmetics){
            System.out.println(c);
        }
    }
}

/**
 *化妆品管理类
 */
class CosmeticManager{
    Cosmetic[] cosmetics = new Cosmetic[5];
    protected int count;
    public void add(Cosmetic cosmetic){
        if(count == cosmetics.length) cosmetics = Arrays.copyOf(cosmetics , cosmetics.length * 2);
        cosmetics[count++] = cosmetic;
    }

    /**
     * 打印输出
     */
    public void printAll() {
        for(Cosmetic c : cosmetics){
            System.out.println(c);
        }
    }
}