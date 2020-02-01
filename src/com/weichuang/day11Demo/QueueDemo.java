package com.weichuang.day11Demo;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("张飞");
        queue.add("刘备");
        queue.add("诸葛亮");
        //拿到队头，不删除
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
