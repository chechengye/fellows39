package com.weichuang.day11Demo.thread;

/**
 * 线程讲解
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread mt = new MyThread();
        mt.setName("MyThread");
        Runnable mr = new MyRunnable();
        Thread mrt = new Thread(mr);
        mrt.setName("MyRunnable");
        mt.start();//启动线程。会默认调用run()方法
        mrt.start();
    }
}
/**
 * 通过实现Runnable接口的方式定义一个线程
*/
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ; i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}
/**
 * 通过继承Thread类来定义一个线程
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ; i++){
            try {
                Thread.sleep(300);//睡眠300ms，释放CPU，但不会让出监视器的所有权
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}