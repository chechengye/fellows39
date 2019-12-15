package com.weichuang.day03Demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class ProgramExample {

    @Test
    public void testFn(){
        int[] arrs = {7,5,6,3,10 };
        int[] arrs2 = {7,5,6,3,10};
        //注意：只能对已经排好序的数组
        int index = Arrays.binarySearch(arrs, 5);
        System.out.println(index);
        //Arrays.toString 转成数组字符串
        System.out.println(Arrays.toString(arrs));
        //帮我们讲数组排好序，并赋值回该数组
        //Arrays.sort(arrs);
        System.out.println(Arrays.toString(arrs));
        //扩容,扩容的大小，就是原数组的长度的2倍 & 原数组长度的 1/2 + 1
        arrs = Arrays.copyOf(arrs, arrs.length * 2);
        for(int x : arrs){
            System.out.print(x + " ");
        }
        System.out.println(Arrays.equals(arrs, arrs2));
        Arrays.fill(arrs2 , 0 , 2 , 3);
        System.out.println(Arrays.toString(arrs2));

    }

    /**
     * 双色球模拟综合案例
     */
    @Test
    public void testFn1(){
        String[] pool = getPool();
        System.out.println(Arrays.toString(pool));
        //机器抽取6红球-随机操作
        String[] sysRedBalls = getRedBalls(pool);
        System.out.println(Arrays.toString(sysRedBalls));
        //机器随机抽取1个篮球
        Random r = new Random();
        final int blueBound = 16;
        String sysBlueBall = pool[r.nextInt(blueBound)];
        System.out.println(sysBlueBall);
        //用户来了，让你机器随机抽取号码
        String[] userRedBalls = getRedBalls(pool);
        String userBlueBall = pool[r.nextInt(blueBound)];
        System.out.println(Arrays.toString(userRedBalls));
        System.out.println(userBlueBall);
        System.out.println(getReward(sysRedBalls, sysBlueBall, userRedBalls, userBlueBall));
    }

    /**
     * 初始化双色球池子
     */
    private String[] getPool(){
        String[] pool = new String[33];
        int len =  pool.length;
        for(int i = 1 ; i <= len ; i++){
            if(i < 10) pool[i - 1] = "0" + i;
            else pool[i - 1] = i + "";
        }
        return pool;
    }

    /**
     * 随机获取6个红球
     */
    private String[] getRedBalls(String[] pool){
        String[] redBalls = new String[6];
        //获取随机数的对象
        Random r = new Random();
        int count = 0 ;
        boolean[] isUsed = new boolean[pool.length];
        while (true){
            int index = r.nextInt(pool.length);//此方法随机获取bound -1 ~ 0
            if(isUsed[index]) continue; //判断是否已经取过红球
            isUsed[index] = true; //讲取过的索引，加标志位
            redBalls[count ++] = pool[index];
            if(count == redBalls.length) break;
        }
        return redBalls;
    }

    /**
     * 获得了几等奖
     */
    private String getReward(String[] sysRedBalls , String sysBlueBall , String[] userRedBalls , String userBlueBall){
        int redCount = 0;
        for(String sysRed : sysRedBalls){
            for(String userRed : userRedBalls){
                if(sysRed == userRed) redCount ++;
            }
        }
        int blueCount = 0;
        if(sysBlueBall == userBlueBall) blueCount ++;
        if(blueCount == 1 && redCount < 3)
            return "六等奖";
        else if((blueCount + redCount) == 4)
            return "五等奖";
        else if((blueCount + redCount) == 5)
            return "四等奖";
        else if(redCount == 5 && blueCount == 1)
            return "三等奖";
        else if(redCount == 6 && blueCount == 0)
            return "二等奖";
        else if((redCount + blueCount) == 7)
            return "一等奖";
        else return "未中奖";
    }

    @Test
    public void testFn2(){
        Dog hsq = new Dog();//对象
        hsq.name = "哈士奇";
        hsq.color = "黄色";
        hsq.eat();
        Dog td = new Dog();//对象
        td.name = "泰迪";
        td.color = "黑色";
        td.eat();
        new Dog().move();//实例化了一个对象，匿名对象
        //Dog dog2 = null;//java.lang.NullPointerException
        //dog2.eat();
        //td = null;//会立即回收
        //不主动释放，那么闲置的内存也会被GC垃圾回收机制自动回收(不会立即回收，时间片轮询)
        td = hsq;
        td.name = "嘿嘿";
        System.out.println(hsq.name);
        method(hsq);
        System.out.println(hsq.name);
        Horse horse = new Horse();
        //td = horse;//类型不符
        horse.setName("小白马");
        //System.out.println(horse.getName());
        System.out.println(horse);
    }

    private static void method(Dog dog){
        dog.name = "白白";
    }

    /**
     * 构造方法举例
     */
    @Test
    public void testFn3(){
        Horse horse = new Horse();
        //td = horse;//类型不符
        horse.setName("小白马");
        //System.out.println(horse.getName());
        System.out.println(horse);
        Horse horse1 = new Horse("小黑马" , "黑色");
        System.out.println(horse1);
    }

    /**
     * 值传递&引用传递
     */
    @Test
    public void testFn4(){
        int x = 10;
        method(x);
        System.out.println(x);
        Horse horse = new Horse();
        method(horse);
        System.out.println(horse.age);
        String name = "小飞";
        method(name);
        System.out.println(name);
    }

    public void method(String name){
        name = "小贝";
    }
    public void method(Horse horse){
        horse.age = 20;
    }

    public void method(int x){
        x = 20;
    }

    @Test
    public void testFn5(){
        Hero hero = new Hero();
        hero.setName("关羽");
        Weapon weapon = new Weapon("青龙偃月刀");
        weapon.setName("青龙偃月刀");
        //hero.setWeapon(weapon);//new Weapon("青龙偃月刀")
        weapon.setHero(hero);
        System.out.println(weapon);
    }

}



class Horse{
    //封装过程
    private String name;
    public int age = 5;
    private String color;

    //默认构造方法或无参构造方法

    /**
     * 构造方法:
     * 1、方法名称与类名称一致
     * 2、无返回类型，连void都不允许写
     * 3、可以有参数
     * 4、若你写了带参数的构造方法，那么 会自动替换调默认的构造方法，除非你主动补上
     */
    public Horse(){
        this("","");
        System.out.println("无参构造方法!!!");
    }

    /**
     * 可以初始化，破坏了封装性
     * 两个构造方法直接互相称为构造方法重载
     * @param name
     * @param color
     */
    public Horse(String name , String color){
        this.name = name;
        this.color = color;
        this.method();
    }

    public void method(){
        System.out.println("这是一个普通方法!!!");
    }

    public void setName(String name){
        this.name = name;//就近原则
    }
    public String getName(){
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
//内部类
class Dog{
    String name;
    int age;
    String color;

    public void eat(){
        System.out.println(color + "的" + name + "在吃...");
    }

    void move(){
        eat();
    }
}

/**
 * 对象的一对一关系
 * 关系：谁到谁，谁与谁
 */
class Hero{
    private String name;
    private Weapon weapon;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", weapon=" + weapon +
                '}';
    }
}
class Weapon{
    private String name;
    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Weapon(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", hero=" + hero +
                '}';
    }
}

