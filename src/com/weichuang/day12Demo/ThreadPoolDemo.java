package com.weichuang.day12Demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的使用
 * jdk 1.5之后java提供了线程池相关对象Executor 、Executors操作工具类，可以创建4种线程池
 * 线程池存在的意思: 每次创建一个新的线程并进入就绪状态的话，会消耗一定的性能。
 * 会事先帮我们创建好一些线程，放入线程池中，想用的时候直接取。使用后，自动收回。
 * 推荐使用前两种，不推荐使用后两种.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //ExecutorService es = Executors.newSingleThreadExecutor();//单线程池，其中只存放一个线程,若多个线程运行，只能串行操作
        //ExecutorService es = Executors.newFixedThreadPool(2);//可设定固定大小的线程池,若大小设定为1与单线程池一致
        ExecutorService es = Executors.newCachedThreadPool();//获取一个可缓存的线程池，但只能缓存60s。不建议使用
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);//可延迟操作的线程池，而且可以自己设置时间单位
        ses.schedule(new MyRunnable4() , 3000 , TimeUnit.MILLISECONDS);
        ses.shutdown();
        es.execute(new MyRunnable4());
        es.execute(new MyRunnable4());
        es.shutdown();//关闭线程，有序关闭

    }
}
class MyRunnable4 implements Runnable{
    @Override
    public void run() {
        for (int i = 0 ; i < 10 ; i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}
