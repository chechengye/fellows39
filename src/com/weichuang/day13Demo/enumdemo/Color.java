package com.weichuang.day13Demo.enumdemo;

/**
 * 颜色的枚举类型
 */
public enum Color {
    //显示的调用带参数的构造方法
    RED(10,"红色") , GREEN , BLUE;
    //public Color(){} 不允许: 枚举被设计成了单例模式，当JVM加载的时候，实例化枚举对象、
    //JVM为了保证每一个枚举元素的唯一实例。不允许new实例化操作。防止用户自己生成实例，破坏唯一性。
    //JVM默认调用无参的构造方法
    private int val;
    private String name;
    Color(){}
    Color(int val , String name){
        this.name = name;
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
