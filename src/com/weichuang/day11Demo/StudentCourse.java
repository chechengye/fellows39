package com.weichuang.day11Demo;

public class StudentCourse {
    private int id;// 1 , 2 , 3 ,4 ,5
    private int sId; // 1 , 2
    private int cId;//1 , 2 ,3

    public StudentCourse(int id, int sId, int cId) {
        this.id = id;
        this.sId = sId;
        this.cId = cId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", sId=" + sId +
                ", cId=" + cId +
                '}';
    }
}
