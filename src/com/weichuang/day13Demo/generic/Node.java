package com.weichuang.day13Demo.generic;

/**
 * 参数化类型： T E K V 中的代表
 * @param <T>
 */
public class Node<T> {
    private T data;
    public Node(T data){
        this.data = data;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
