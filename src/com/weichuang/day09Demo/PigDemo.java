package com.weichuang.day09Demo;

import java.util.ArrayList;
import java.util.List;

public class PigDemo {

    public static void main(String[] args) {
        PigManage pm = new PigManage();
        pm.addPig(new Pig(1 , "哼哼"));
        pm.addPig(new Pig(5 , "猪猪"));
        pm.addPig(new Pig(2 , "佩奇"));
        pm.showAllPigs();
        pm.delPigByIndex(2);
        System.out.println("-------------------");
        pm.showAllPigs();
        System.out.println("-------------------");
        pm.updatePigByIndex(1 , new Pig(11 , "乔治"));
        pm.showAllPigs();
    }
}

/**
 * 不是内部类，文件内部编写的类
 */
class Pig{
    private int age;
    private String name;

    public Pig() { }

    public Pig(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class PigManage{
    private List<Pig> pigList;

    public PigManage(){
        this.pigList = new ArrayList<>(20);
    }

    /**
     * 添加猪的方法
     */
    public void addPig(Pig p){
        this.pigList.add(p);
    }
    /**
     * 显示所有猪
     */
    public void showAllPigs(){
        for(Pig p : pigList){
            System.out.println(p);
        }
    }

    /**
     * 删除一只猪根据索引位置
     * @param index : 标记索引位置
     */
    public void delPigByIndex(int index) {
        pigList.remove(index);
    }

    /**
     * 根据索引更新一只猪
     * @param index
     */
    public void updatePigByIndex(int index , Pig pig) {
        pigList.set(index , pig);
    }
}
