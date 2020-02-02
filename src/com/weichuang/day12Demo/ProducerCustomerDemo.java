package com.weichuang.day12Demo;

/**
 * 生产者与消费者案例
 * 1、两个线程协同工作先生产再消费的一个过程。
 * 2、面试题
 * sleep与wait方法的区别（逢多线程必问）
 * sleep: 会让线程进入休眠状态，让出CPU的时间片,但是不会让出监视器的所有权，不释放锁
 * wait: 会让线程进入等待状态，也会让出CPU的时间片，但是会让出监视器的所有权，就是释放锁
 *      ，等待调用notify或notifyAll将其唤醒
 */
public class ProducerCustomerDemo {
    public static void main(String[] args) {
        Food food = new Food();
        Producer p = new Producer(food);
        Customer1 c1 = new Customer1(food);
        Thread t2 = new Thread(c1);
        Thread t1 = new Thread(p);
        t1.start();
        t2.start();
    }
}

/**
 * 消费者 - 服务员
 */
class Customer1 implements Runnable{
    private Food food;
    public Customer1(Food food){
        this.food = food;
    }
    @Override
    public void run() {
        for(int i = 0 ; i < 20 ; i++){
            food.customerFood();
        }
    }
}
/**
 * 生产者 - 厨师
 */
class Producer implements Runnable{
    private Food food;
    public Producer(Food food){
        this.food = food;
    }
    @Override
    public void run() {
        for(int i = 0 ; i < 20 ; i++){  //生产者生成的过程
            if(i % 2 == 0){
                food.productFood("宫保鸡丁" , "酸甜口味，好吃");
            }else{
                food.productFood("麻婆豆腐" , "麻辣口味，爽口");
            }
        }
    }
}
/**
 * 生产者与消费者共享的数据
 */
class Food{
    private String name;
    private String desc;
    private boolean flag = true; //true可以生产，false可以消费
    public Food(){}
    public Food(String name , String desc){
        this.name = name;
        this.desc = desc;
    }
    //生成食物
    public synchronized void productFood(String name ,  String desc){
        if(!flag){//表示可以消费
            try {
                //等待有人调用notify或notifyAll来唤醒它
                // ，会释放监视器的所有权，释放锁。条件此对象已经获得了监视器，有锁
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(1000);//模拟一下做菜的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesc(desc);
        flag = false;//通知服务员进行消费
        this.notify();//随机唤醒一个线程
    }
    //消费食物
    public synchronized void customerFood(){
        if(flag){//表示生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);//取食物的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + "->" + this.desc);
        this.flag = true;
        this.notify();//表示唤醒一个处于wait状态的线程。notifyAll唤醒所有等待的线程

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}