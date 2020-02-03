package com.weichuang.day13Demo.generic;

/**
 * 参数化类型： T E K V 中的代表
 * @param <T>
 */
public class Node<T> {
    private T data;
    private int age;
    public Node(T data , int age){
        this.data = data;
        this.age = age;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
