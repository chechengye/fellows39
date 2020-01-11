package com.weichuang.day06Demo;

/**
 *  内部类创建方式
 *   1、成员内部类，直接写在类中
 *   2、方法内部类，直接写在方法中
 *   3、静态内部类，直接写在类中，但必须由static关键字修饰
 *   4、匿名内部类: (1) 继承式的匿名内部类 (2)接口式匿名内部类 (3) 参数式匿名内部类
 */
public class InnerDemo {
    public static void main(String[] args) {
        Outer o = new Outer();
        /*Outer.Inner inner = o.new Inner();//外部类对象.new的方法创建内部类
        inner.eat();*/
        o.innerPrint();
        System.out.println("---------------------");
        o.print();
        System.out.println("---------------------");
        Outer.Inner2 inner2 = new Outer.Inner2();
        inner2.eat();
        Outer.print1();
        System.out.println("---------------------");
        o.print3();
        System.out.println("---------------------");
        o.print4();
        System.out.println("--------------------");
        o.print5("xx", new ISpeak() {
            @Override
            public void speak() {
                System.out.println("我是参数式匿名内部类");
            }
        }, new ISay() {
            @Override
            public void say() {
                System.out.println("say....");
            }
        });

        Dog dog = new Dog();
        dog.speak();
    }
}

/**
 * 内部类讲解
 */
class Outer{
    private String name = "zhangsan";

    static void print1(){
        System.out.println("我是普通的静态方法");
    }

    /**
     * 静态内部类，由static关键字修饰的类
     */
    static class Inner2{
        public void eat(){
            System.out.println("静态内部类");
        }
    }
    /**
     * 成员内部类
     */
    private class Inner{
        void eat(){
            System.out.println("成员内部类");
        }
    }
    public void print(){
        int i = 10;
        //方法内部类中访问局部变量时，此局部变量一定为final修饰的常量 jdk 1.8版本之后默认可以不带final，
        // 但是方法内部类调用了，就会帮我们主动加上final
        class Inner1{
            void eat(){
                System.out.println("方法内部类");
                System.out.println(i);
            }
        }
        //i++;
        System.out.println(i);
        Inner1 inner1 = new Inner1();
        inner1.eat();
    }
    public void innerPrint(){
        Inner inner = new Inner();
        inner.eat();
    }

    public void print3(){
        Animal cat = new Animal(){
            @Override
            void say() {
                System.out.println("继承式匿名内部类 ， 我是猫可以喵喵叫!");
            }
        };
        cat.say();
    }

    public void print4(){
        ISpeak iSpeak = new ISpeak() {

            @Override
            public void speak() {
                System.out.println("我是接口式的匿名内部类");
            }
        };
        iSpeak.speak();
    }

    public void print5(String name , ISpeak iSpeak , ISay iSay){
        System.out.println(name);
       /* iSpeak.speak();
        iSay.say();*/

    }

}
abstract class Animal{
    abstract void say();
}
interface ISpeak{
    void speak();
}

interface ISay{
    void say();
}
class Dog implements ISpeak{

    @Override
    public void speak() {
        System.out.println("汪汪叫...");
    }
}