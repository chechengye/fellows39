package com.weichuang.day13Demo.generic;

public class School<T> {
    private T stu;
    public School(T stu){
        this.stu = stu;
    }

    public T getStu() {
        return stu;
    }

    public void setStu(T stu) {
        this.stu = stu;
    }
}
