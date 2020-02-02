package com.weichuang.day12Demo.reflect;

import org.junit.Test;

import java.lang.reflect.*;

/**
 * 反射
 * 反射破坏了一切的封装性
 * 面试题：
 * 对象的多个实例，通过getClass()获取到的Class类是同一个吗？
 * 是，因为对象的字节码文件只有一个.(Dog.class)
 */
public class ReflectionDemo {
    public static void main(String[] args) {
        //三种获取Class类的方式
        //1、通过Object的getClass()方法获取
        Dog dog = new Dog("旺财" , 10);
        Dog dog2 = new Dog("来福" , 5);
        Class dogClass = dog.getClass();
        //2、类.class获取
        Class dogClass1 = Dog.class;
        Class aClass = dog2.getClass();
        System.out.println(dogClass == aClass);
        //3、Class.forName方法获取
        try {
            Class dogClass3 = Class.forName("com.weichuang.day12Demo.reflect.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过无参的构造方法实例化对象
     */
    @Test
    public void testFn(){
        Class<Dog> dogClass = Dog.class;
        try {
            //通过默认的无参构造方法，实例化对象。此时就不需要new关键字创建对象
            Dog dog = dogClass.newInstance();//反射实例化对象过程
            System.out.println(dog);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    /**
     * 通过有参的构造方法实例化对象
     */
    @Test
    public void testFn1(){
        Class<Dog> dogClass = Dog.class;
        try {
            //有9个预先定义好的Class对象，代表8大基本数据类型和void
            Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class);
            Dog dog = constructor.newInstance("球球", 3);
            System.out.println(dog);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Constructor<?>[] constructors = dogClass.getConstructors();
        for(int i = 0 ; i < constructors.length ; i++){
            System.out.println(constructors[i].getName() + "-" + constructors[i].getParameterCount());
        }
    }

    /**
     * 获取类的中包信息，方法信息
     */
    @Test
    public void testFn2(){
        Dog dog = new Dog("多多", 1);
        Class dogClass = dog.getClass();
        //获取类所在的包路径
        Package aPackage = dogClass.getPackage();
        System.out.println(aPackage.getName());
        //获取所有的公共方法，而且还包括父类中的公有方法
        Method[] methods = dogClass.getMethods();
        for(Method m : methods){
            System.out.println(m);
            if(m.getName().equals("toString")){
                try {
                    String dogInfo =  (String)m.invoke(dog);
                    System.out.println(dogInfo);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("--------------------------------");
        //获取类中的所有方法包括私有，但是不包括其父类中的任何方法
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
            if(m.getName().equals("set")){
                m.setAccessible(true);//将私有的修饰符修饰的方法变成对外可见，所以反射将一切封装变成浮云
                try {
                    m.invoke(dog);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取属性相关
     */
    @Test
    public void testFn3(){
        Class<Dog> dogClass = Dog.class;
        //只可以获取公有的属性
        Field[] fields = dogClass.getFields();
        //可以获取对象中的所有属性
        Field[] declaredFields = dogClass.getDeclaredFields();
        System.out.println(declaredFields.length);
        for(Field f : declaredFields){
            //System.out.println(f);
            System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getName() + " " + f.getName());

        }
    }

}
