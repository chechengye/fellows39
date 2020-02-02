package com.weichuang.day12Demo.reflect;

public class Dog {
    private String name;
    private int age;
    public String color;

    public Dog() {
    }

    private void set(){
        System.out.println("私有的set方法");
    }
    protected void get(){
        System.out.println("受保护的get方法");
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
