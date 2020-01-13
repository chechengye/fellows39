package com.weichuang.day08Demo;

/**
 * 函数式编程
 */
public class LambdaDemo {

    public static void main(String[] args) {
       /* IPerson iPerson = new IPerson() {
            @Override
            public void run(String name) {
                System.out.println(name + "正在逃跑..");
            }
        };
        iPerson.run("张三");*/
        /**
         * ()->{} 就是lambda特有的语法格式
         * 1、若只有一个参数 ()都可以省略不写
         * 2、若代码块中只有一条代码{}都可以省略不写
         * 3、参数类型可以省略 ,若有两个参数，参数类型要写就都写，要删就全删
         * 4、带返回值的，若只有一行代码{}可以省略但return跟着省略。
         * 加上return时花括号一定不能省略
         * 5、若一个参数被final修饰了，可以省略final与修饰符。否则加入final一定也要加入修饰符
         */
        IPerson ip1 = (final String name ,int time)->  {return name;};
            //System.out.println(name + "正在逃跑...." + "跑了" + time + "这么久");


        System.out.println(ip1.run("李四", 20));
    }
}

/**
 * 想要使用lambda表达式，那么接口中一定只有一个抽象方法
 * 1.8之后加入的default或者static修饰的方法不计入
 *
 * 默认方法与静态方法并不影响函数式接口的契约
 * @FunctionalInterface 标记一个接口为函数式接口,
 * 约束接口中只允许有一个抽象方法
 */
@FunctionalInterface
interface IPerson{
    String run(final String name , int time);
    default void eat(){

    }
}