package com.weichuang.day12Demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程共享数据
 * 1、多线程共享同一个数据时，会发生线程不安全的情况
 *   （数据没有安全我们的预期进行执行）
 * 2、多线程在共享数据时，我们应用使用同步
 * 3、实现同步有三种方式：
 *    1）可以使用同步代码块
 *    2) 同步方法
 *    3) lock方式，更加灵活，推荐
 *  4、多线程共享数据，会产生安全问题，使用同步可以解决安全问题，但要牺牲一定的性能
 */
public class ThreadSyncDemo {

    public static void main(String[] args) {
       Runnable mr = new MyRunnable2();
       Thread t1 = new Thread(mr);
       Thread t2 = new Thread(mr);
       t1.start();
       t2.start();
    }
}
class MyRunnable2 implements Runnable{
    private int ticket = 10;//售票，作为共享的数据
    //private Integer a = 1;
    private Object obj = new Object();
    @Override
    public void run() {
        for(int i = 0 ; i < 300 ; i++){
            //A B
            //此时B只能在此等候
            /*synchronized (obj){//A先进入同步代码块，进行上锁。同步代码块中的代码执行完毕之后，才会让出监视器的所有权（释放锁）
                if(ticket > 0){
                    ticket--;
                    try {
                        Thread.sleep(1000);//模拟售票员操作时间，让出CPU的时间片、没有释放监视器的所有权（锁）
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("剩余的票数为:" + ticket + "张");
                }
            }*/
            //method();
            method2();
        }
    }

    /**
     * 使用同步方法实现上锁，默认的同步对象就是this
     */
    private synchronized void method(){
        if(ticket > 0){
            ticket--;
            try {
                Thread.sleep(1000);//模拟售票员操作时间，让出CPU的时间片、没有释放监视器的所有权（锁）
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("剩余的票数为: " + ticket + "张");
        }
    }
    /**
     * lock方式上锁
     * ReentrantLock : 可重入锁，互斥锁
     */
    ReentrantLock rLock = new ReentrantLock();
    private void method2(){
        rLock.lock();//进行上锁
        try{
            if(ticket > 0){
                ticket--;
                try {
                    Thread.sleep(1000);//模拟售票员操作时间，让出CPU的时间片、没有释放监视器的所有权（锁）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("剩余的票数为:" + ticket + "张");
            }
        }finally {
            rLock.unlock();//释放锁，放置于finally块中保证不会死锁，阻塞。保证一定会被执行
        }
    }
}