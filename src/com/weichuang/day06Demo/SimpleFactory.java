package com.weichuang.day06Demo;

/**
 * 简单工厂模式，帮我们管理对象实例应用
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Product phone = new Phone();
        //phone.work();
        Product computer = new Computer();
        computer.work();
        Product product = ProductFactory.getProductByName("computer");
        product.work();
    }
}
class ProductFactory {
    public static Product getProductByName(String name){
        if("phone".equals(name)){
            return new Phone();
        }else if("computer".equals(name)){
            return new Computer();
        }
        return null;
    }
}
abstract class Product{
    abstract void work();
}
class Phone extends Product{

    void work() {
        System.out.println("手机开始工作..");
    }
}
class Computer extends Product{
    void work(){
        System.out.println("电脑开始工作...");
    }
}