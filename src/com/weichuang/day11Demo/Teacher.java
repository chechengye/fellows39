package com.weichuang.day11Demo;

import java.util.Arrays;

public class Teacher {
    private String name;
    private int age;
    private Student[] students;

    public Teacher(){}
    public Teacher(Student[] students){
        this.students = students;
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
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
