package com.weichuang.day05Demo;

import org.junit.Test;

import java.util.Arrays;

public class ProgramExample {

    @Test
    public void testFn(){
        Chicken ck = new Chicken();
        ck.sing("黄色");
        //System.out.println(ck.name);
        HomeChicken hc = new HomeChicken();
        //hc.eat();
        hc.sing("灰色");
        YjChicken yjChicken = new YjChicken();
        yjChicken.sing("五颜六色");
    }
    /**
     * 化妆品管理测试
     */
    @Test
    public void testFn1(){
        /*CosmeticManager cm = new CosmeticManager();
        cm.add(new Cosmetic("雅诗兰黛" , 88 , "进口"));
        cm.add(new Cosmetic("大宝" , 3 , "国产"));
        cm.add(new Cosmetic("曼秀雷敦" , 33 , "进口"));
        cm.printAll();*/
        SortCosmeticManager cm = new SortCosmeticManager();
        cm.add(new Cosmetic("雅诗兰黛" , 88 , "进口"));
        cm.add(new Cosmetic("大宝" , 3 , "国产"));
        cm.add(new Cosmetic("曼秀雷敦" , 33 , "进口"));
        cm.add(new Cosmetic("测试" , 11 , "进口"));
        cm.printAll();
    }

    /**
     * final测试
     */
    @Test
    public void testFn2(){
        HuskyDog huskyDog = new HuskyDog();
        huskyDog.drink();
    }

    /**
     * 抽象类测试
     */
    @Test
    public void testFn3(){
        AbsPerson man = new Man();//多态的向上自动转型
        AbsPerson women = new Women();
        method(women);
    }
    public void method(AbsPerson absPerson){
        //类型判断instanceof 前者是否属于后者,若不使用instanceof判断可能会出现类转换异常
        //Man man1 = (Man)absPerson;

        if(absPerson instanceof Man){
           Man man = (Man) absPerson ;//向下转型。必须强制类型转换，且需要先确定好类型
           man.eat();
        }else if(absPerson instanceof Women){
            Women women = (Women) absPerson ;
            women.eat();
        }
    }
    /**
     * 测试多态
     */
    @Test
    public void testFn4(){
        A a1 = new A();
        A a2 = new B(); //向上自动转型
        B b = new B();
        C c = new C();
        D d = new D();
        a1.show(b);
        System.out.println("------------");
        a1.show(c);
        System.out.println("------------");
        a1.show(d);
        System.out.println("------------");
        a2.show(b);
        System.out.println("------------");
        a2.show(c);
        System.out.println("------------");
        a2.show(d);
        System.out.println("------------");
        b.show(b);
        System.out.println("------------");
        b.show(c);
        System.out.println("------------");
        b.show(d);
    }
    /**
     * 摸版方法模式测试
     */
    @Test
    public void testFn5(){
        UserManager um = new UserManager();
        um.checkUser("ssss" , "add");
        TeacherManager tm = new TeacherManager();
        tm.checkUser("admin" , "check");
    }

    /**
     * 测试Object相关
     */
    @Test
    public void testFn6(){
        String s1 = "abc";
        String s2 = "abc";
        int i1 = 10;
        int i2 = 10;
        Student stu1 = new Student(23, "zhangsan" , "20010909");
        System.out.println(stu1.getClass());
        System.out.println(stu1.toString());
        Student stu2 = new Student(22, "zhangsan" , "20010909");
        System.out.println(s1.equals(s1));
       // System.out.println(stu1.equals(stu2));
    }
}

/**
 * 继承相关
 * 1、子类不可以继承多个类，只能单继承
 * 2、但可以多层继承
 */
class Animal{
    protected int age;
    protected String name;
    public Animal(){}
    public Animal(String name){
        System.out.println(name + "Animal的构造方法");
    }

    public void eat(){
        System.out.println("吃东西...");
    }
}
class Person{

}

/**
 * 子类
 */
class Chicken extends Animal{
    public Chicken(){
        super("小鸡");
    }
    public Chicken(String name){
        super(name);
        //显示调用构造方法，和this必须放在第一行&都可以调用构造方法。
        // 但是this代表调用者对象、而super引用的是调用者的父类的对象
        //this调用本类对象的构造方法，而super调用的是父类的构造方法

        System.out.println(name + "吃东西..." + super.age);
    }
    public  void sing(String color){
        System.out.println("勾勾叫..." + color);
        super.eat();
    }
}
/**
 * 多层继承
 */
class HomeChicken extends Chicken{
    public HomeChicken(){
        super("家鸡");
        System.out.println("HomeChicken的构造方法");
    }

    /**
     * 方法重写
     * 1、子类重写的方法的修饰符权限要高于父类方法的修饰符
     * 2、返回值一模一样
     * 3、方法名称相同
     * 4、参数个数与类型必须同一致
     */
    /*public void sing(String color){
        System.out.println("唱歌..." + color);
    }*/
}
class YjChicken extends Chicken{

    public void sing(String color){
        System.out.println("动人的声音..." + color);
    }
}


/**
 * 化妆品管理实例
 * 使用继承操作
 */
class Cosmetic{
    private String name;
    private int price;
    private String type;

    public Cosmetic(String name, int price, String type) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cosmetic{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
/**
 * 使用继承实现一个可按单价排序输出所有化妆品的功能
 */
class SortCosmeticManager extends CosmeticManager{
    /**
     * 重新打印方法
     */
    public void printAll(){
        //选择排序  minIndex
        for(int i = 0 ; i < count ; i++){
            int minIndex = i;
            for(int j = i + 1 ; j < count ; j++){
                if(cosmetics[minIndex].getPrice() > cosmetics[j].getPrice()) minIndex = j;
            }
            if(minIndex != i){
                Cosmetic cosmetic = cosmetics[minIndex];
                cosmetics[minIndex] = cosmetics[i];
                cosmetics[i] = cosmetic;
            }
        }
        for(Cosmetic c : cosmetics){
            System.out.println(c);
        }
    }
}

/**
 *化妆品管理类
 */
class CosmeticManager{
    Cosmetic[] cosmetics = new Cosmetic[5];
    protected int count;
    public void add(Cosmetic cosmetic){
        if(count == cosmetics.length) cosmetics = Arrays.copyOf(cosmetics , cosmetics.length * 2);
        cosmetics[count++] = cosmetic;
    }

    /**
     * 打印输出
     */
    public void printAll() {
        for(Cosmetic c : cosmetics){
            System.out.println(c);
        }
    }
}

/**
 * 储存常量的类
 */
class Constants{
    public static final int DOG_NUM = 3;
    public static final String ADD_SUCCESS = "添加成功";
    public static final int MSG_CODE = 101;
}
/**
 * final关键字讲解
 * 1、final 修饰类不能被继承
 * 2、final修饰方法不能被重写
 * 3、final修饰属性，不能被修改
 */
class Dog{
    public static final int DOG_NUM = 3;

    public final void drink(){
        System.out.println("喝....");
    }
    public void eat(){
        final int i = 10;
        System.out.println(i);
    }
}
class HuskyDog extends Dog{
}

/**
 * 抽象类讲解
 * 1、若该类中，已经存在一个或多个抽象方法，那么该类一定定义为抽象类
 * 2、若该类为抽象类，那它里面可以没有抽象方法
 * 3、抽象类可以继承抽象类，且不需要事先父类里面的抽象方法
 */
abstract class AbsPerson implements IBird{
    public AbsPerson(){
        System.out.println("AbsPerson的构造方法...");
    }
    public void run(){
        System.out.println("走路...");
    }
    //抽象方法不允许写方法体
    abstract public void eat();

    abstract public String foot();
}
abstract class AbsCat extends AbsPerson{

   //abstract public void zhualaoshu();
}
class Man extends AbsPerson{

    public void eat() {
        System.out.println("男人喜欢吃肉...");
    }

    @Override
    public String foot() {
        return null;
    }

    @Override
    public void fly() {

    }

    @Override
    public int eat(String foot) {
        return 0;
    }

    @Override
    public void planeFly() {

    }
}
class Women extends AbsPerson{

    @Override
    public void eat() {
        System.out.println("女人喜欢吃蔬菜...");
    }

    @Override
    public String foot() {
        return "蔬菜";
    }

    @Override
    public void fly() {

    }

    @Override
    public int eat(String foot) {
        return 0;
    }

    @Override
    public void planeFly() {

    }
}

/**
 * 接口定义
 * 1、里面的属性，全是公共静态常量
 * 2、内部的方法都是公有抽象方法
 * 3、接口可以多继承，类不行
 * 4、而且子接口可以不重写父接口的抽象方法
 */
interface IAnimal{
    public static final int FOOT_NUM = 10;
    public abstract void fly();
    int eat(String foot);
}
interface IPlane{
    void planeFly();
    default void zaike(){ //不常用
        System.out.println("载客...");
    }
}
interface IBird extends IAnimal , IPlane{
}

/**
 * 类实现接口,必须重写所有的接口中的抽象方法
 * 类可以多实现接口
 */
class Bird implements IAnimal , IPlane{

    @Override
    public void fly() {

    }

    @Override
    public int eat(String foot) {
        return 0;
    }

    @Override
    public void planeFly() {

    }
}

/**
 * 多态实例(this , super指的都是调用者)
 * 1、this.show(O)
 * 2、super.show(O)
 * 3、this.show(super..(0))
 * 4、super.show(super..(O))
 * 调用过程
 */
class A{
    public void show(D d){
        System.out.println("A AND D");
    }
    public void show(A a){
        System.out.println("A AND A");
    }

    public void show(C c){
        System.out.println("A AND C");
    }
}
class B extends A{
    public void show(B b){
        System.out.println("B AND B");
    }
    public void show(A a){
        System.out.println("B AND A");
    }
}
class C extends B{}
class D extends B{}
/**
 * 抽象类应用—模板方法模式
 */
abstract class BaseManager{
    public void checkUser(String username , String method){
        if("admin".equals(username)){
            execute(method);
        }else{
            System.out.println("没有权限执行操作");
        }
    }
    //摸版方法
    abstract public void execute(String method);
}
class UserManager extends BaseManager{

    @Override
    public void execute(String method) {
        if("add".equals(method)){
            System.out.println("添加用户操作");
        }else if("find".equals(method)){
            System.out.println("查询用户操作");
        }
    }
}
class TeacherManager extends BaseManager{

    @Override
    public void execute(String method) {
        if("check".equals(method)){
            System.out.println("检查操作");
        }
    }
}

/**
 * Object讲解
 * finalize() 垃圾回收机制GC调用
 * final 表示最终，常量的修饰符
 * finally{} 异常相关，最终 try{}catch{}finally{}
 */
class Student{
    private int age;
    private String name;
    private String sno;

    public Student() {}

    public Student(int age, String name, String sno) {
        this.age = age;
        this.name = name;
        this.sno = sno;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    /**
     * 重写Object类的equals()方法
     * @param obj
     * @return
     */
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Student){
            Student s = (Student) obj;
            if(this.age != s.age) return false;
            if(!this.name.equals(s.name)) return false;
            if(this.sno != s.sno) return false;
            return true;
        }
        return false;
    }
    /*@Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sno='" + sno + '\'' +
                '}';
    }*/
}
