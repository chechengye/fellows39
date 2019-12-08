import org.junit.Test;

import java.util.Scanner;

public class ProgramExample {
    /**
     *
     * 1、通过键盘输入声明初始化一个圆柱体的高和底面半径,pai值是3.14,
     * 求圆柱体的体积,  并显示输出圆柱体的体积; π(r^2)h
     *
     * {
     *     Scanner sc = new Scanner(System.in);
     System.out.print("请输入半径r=:");
     int r = sc.nextInt();
     System.out.print("请输入高h=:");
     int h = sc.nextInt();
     double pai = 3.14;
     System.out.println("圆柱体的体积为: " + pai * (r*r) *h);
     * }
     */
    /**
     * 3、根据天数（46）计算周数和剩余的天数，天数是通过键盘输入
     *
     {
     Scanner sc = new Scanner(System.in);
     System.out.print("请输入天数d=:");
     int d = sc.nextInt();
     int z = d / 7;
     int t = d % 7;
     System.out.println("周数为: " + z + "，天数为:" + t);

     }
     * @param args
     */

    /**
     * 通过键盘输入，初始化两个数将这两个数据交换位置后，输出显示交换后的数据。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数:");
        int d = sc.nextInt();
        System.out.print("请输入第二个数:");
        int r = sc.nextInt();
        int temp;
        temp = d;
        d = r;
        r = temp;
        System.out.println("第一个数:" + d + "第二个数:" + r);

    }

    /**
     * 定义一个五位整数，求各个位上的数的和
     */
    @Test
    public void testFn() {
        int l = 54321;
        int w = l / 10000;
        int q = l / 1000 % 10;
        int b = l / 100 % 10;
        int s = l / 10 % 10;
        int g = l % 10;
        System.out.println("五位数之和为: " + (w + q + b + s + g));//此处注意字符串拼接问题
    }

    /**
     * 面试题：&和&&的区别
     */
    @Test
    public void testFn1() {
        int a = 4;
        int b = 6;
        if (a < 7 || b++ > 6) {
            System.out.println(a + b);
        } else {
            System.out.println(a * b);
        }

        if (a < 6 && b++ > 6) {
            System.out.println(a - b);
        } else {
            System.out.println(a / b);
        }
    }

    /**
     * 三目运算符
     * 从键盘输入一个成绩，判断该分数是否及格。
     */
    @Test
    public void testFn2() {
        int a = 75;
        System.out.println(a > 11 ? 4 : a < 15 ? 3 : 2);
        System.out.println(a > 60 ? "及格" : "不及格");
    }

    @Test
    public void testFn3() {
        int i = 4;
        boolean b = false;
        if (!(i > 5)) {
            System.out.println(!b);
        }
        if ((i++ < 3)) {

        }
        i += 1;
        i = i + 1;
        System.out.println(i);
    }

    /**
     * 分支语句
     */
    @Test
    public void testFn4() {
        int x = 30;
        if (--x > 29) {
            System.out.println(x);
        } else if (x++ < 31) {
            System.out.println(x);
        } else {
            System.out.println(x);
        }
    }

    /**
     * 输入一个字符，判断是大写字母还是小写字母，输出提示信息。
     */
    @Test
    public void testFn5() {
        char a = '中'; //(char)System.in.read()
        if (a >= 'a' && a <= 'z') {//ASC码顺序。utf-8
            System.out.println("小写字母");
        } else if (a >= 'A' && a <= 'Z') {
            System.out.println("大写字母");
        } else {
            System.out.println("其它字符");
        }
    }

    /**
     * 写一个程序，判断某一年是否为闰年
     * （被4整除但不能被100整除或者能被400整除)是闰年否则是平年
     */
    @Test
    public void testFn6() {
        int y = 2000;
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
            System.out.println("是闰年");
        } else {
            System.out.println("是平年");
        }
    }

    /**
     * switch case分支学习
     */
    @Test
    public void testFn7() {
        final int a = 1;//因为final修饰的为不可变量

        switch (4) {
            case a:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 4:
                if(a > 2){
                    System.out.println(a);
                }else{
                    System.out.println(a);
                }
                System.out.println(3);
                break;

            default:
                System.out.println("default");
                break;
        }
    }
    /**
     * 输入一个月数，然后输出对应月份有多少天（不考虑闰年），将天数输出。
     */
    @Test
    public void testFn8(){
        int d = 1;
        switch (d){
            case 1:
            case 3:
            case 5:
                System.out.println("31天");
                break;
            case 2:
                System.out.println("28天");
                break;
            default:
                System.out.println("30天");
                break;
        }
        if((d == 1 || d == 3)){
            System.out.println("31天");
        }else if(d == 2){
            System.out.println("28天");
        }else{
            System.out.println("30天");
        }
        int a = 10 , b = 12;
        String ysf = "+";
        switch (ysf){
            case "+":
                System.out.println(a + b);
                break;
        }
    }
    /**
     * while循环
     */
    @Test
    public void testFn9(){
        int i = 10;
        while (true){
            if(--i < 4){
                System.out.println(i);
                break;
            }
            System.out.println(i);
        }
    }
    /**
     * 计算1-100之间所有整数之和。5050
     */
    @Test
    public void testFn10(){
        int i = 1;
        int sum = 0;
        while (i<=100){
            sum += i++;
        }
        System.out.println(sum);
    }
    /**
     * 计算10的阶乘 1*2*3*...10
     */
    @Test
    public void testFn11(){
        int i = 1;
        int mul = 1;
        while (i<=10){
            mul *= i++;
        }
        System.out.println(mul);
    }

    /**
     * 逆序输出10~0
     */
    @Test
    public void testFn12(){
        int i = 10;
        do{
            System.out.println(i);
            i--;
        }while (i>=0);
    }
    /**
     * Java阶乘求和 1!+2!+...+10!
     */
    @Test
    public void testFn13(){
        int i = 1;
        int sum = 0;
        do{
            int num = 1;
            int j = 1;
            do {
                num*=j;
                j++;
            }while (j <= i);
            sum+=num;
            i++;
        }while (i<=10);
        System.out.println(sum);
    }
}
