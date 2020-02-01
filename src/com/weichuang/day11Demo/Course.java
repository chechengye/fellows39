package com.weichuang.day11Demo;

public class Course {
    private int cId;
    private String name;
    //private Student[] students;


    public Course(int cId, String name) {
        this.cId = cId;
        this.name = name;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cId=" + cId +
                ", name='" + name + '\'' +
                '}';
    }
}
