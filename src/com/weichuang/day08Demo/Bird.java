package com.weichuang.day08Demo;

public class Bird /*implements Comparable<Bird>*/{

    private String name;
    private int age;

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

    public Bird() {
        super();
    }

    public Bird(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

   /* @Override
    public int compareTo(Bird b) {
       *//* int intValue = this.age - b.age;
        if(intValue < 0) return -1;
        else if (intValue == 0) return 0;
        else return 1;*//*
       return this.age - b.age;
    }*/
}
