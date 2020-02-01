package com.weichuang.day11Demo;

public class Student {
    private int sId;
    private String name;
    private int sno;
    //private Course[] courses;
    //public Student(){}


    public Student(int sId, String name, int sno) {
        this.sId = sId;
        this.name = name;
        this.sno = sno;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sno=" + sno +
                '}';
    }
}
