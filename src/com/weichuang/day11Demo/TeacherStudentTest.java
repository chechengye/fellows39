package com.weichuang.day11Demo;

import java.util.ArrayList;
import java.util.List;

public class TeacherStudentTest {
    public static void main(String[] args) {
        Student s1 = new Student(1,"张三" , 100878);
        Student s2 = new Student(2,"李四" , 100879);
        Course c1 = new Course(1 ,"英语课");
        Course c2 = new Course(2 , "语文课");
        List<StudentCourse> scList = new ArrayList<>();
        scList.add(new StudentCourse(1 , s1.getsId() , c1.getcId()));
        scList.add(new StudentCourse(2 , s1.getsId() , c2.getcId()));
        System.out.println("----------打印学生一学的所有课----------");
        for(StudentCourse sc : scList){
           if(1 == sc.getsId()){
               System.out.println(sc.getcId());
           }
        }
        Student[] students = {s1 , s2};
        Teacher t = new Teacher(students);
        t.setName("小吴老师");
        t.setAge(29);
        System.out.println(t);
    }
}
