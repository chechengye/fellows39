package com.weichuang.day11Demo.thread;

/**
 * 线程讲解
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread mt = new MyThread();
        mt.setName("MyThread");
        Runnable mr = new MyRunnable();
        MyRunnable1 mr1 = new MyRunnable1();
        Thread mr1t = new Thread(mr1);
        Thread mrt = new Thread(mr);
        mrt.setName("MyRunnable");
        //mt.start();//启动线程。会默认调用run()方法
        //mrt.start();
        mr1t.start();
        System.out.println(Thread.activeCount());
        for(int i = 0 ; i < 50 ;i ++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 20){
                /*try {
                    mrt.join();//加入线程，且先终止原来线程。当加入的线程执行完毕后，再从新执行原线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                //mrt.interrupt(); 调用中断标记方法中断
                mr1.setFlag(false);//自定义中断标记，推荐
            }
        }
    }
}
/**
 * 通过实现Runnable接口的方式定义一个线程
*/
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 0 ; i < 50 ; i++){
            if(Thread.interrupted()){//获取中断状态标记
                System.out.println("线程被中断");
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();//重新打回中断标记
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +  " --" + i);
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

/**
 * 推荐此种方式创建一个线程
 */
class MyRunnable1 implements Runnable{
    private boolean flag; //自定义中断标记 true表示不中断，false表示中断
    public MyRunnable1(){
        flag = true;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" + (i++));
        }
    }
}