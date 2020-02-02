package com.weichuang.day12Demo;

/**
 * 守护线程
 * 1、若程序中不存在用户线程了，jvm将退出，不再继续执行守护线程
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        Runnable r1 = new MyRunnable1();
        Thread t = new Thread(r);
        Thread t1 = new Thread(r1);
        t.setDaemon(true);//将用户线程设置为守护线程
        System.out.println(t.isAlive());
        t.setName("MyRunnable");
        t1.setName("MyRunnable1");
        t.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t.start();//就绪状态,可以进行抢占cpu资源了
        t1.start();
        System.out.println(t.isAlive());//处于活动状态，线程处于就绪状态
        //System.out.println(t.isDaemon());
        for(int i = 0 ; i < 50 ; i++){
            if(i == 10){
                Thread.yield();//让出本次执行，只让一次，下次继续抢占资源
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}
class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " --" + i);
        }
    }
}