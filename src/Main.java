import java.util.Scanner;

public class Main {
    //所有单引号或双引号在java语言中全都是英文输入法下的
    private static int age = 10;

    String str = "abc";//str引用数据类型变量
    boolean b = true; //布尔型  boolean 不定值  默认值 ： false
    byte bb = 1;  //字节型  byte    1   默认值： 0
    short s = 2;  //短整型  short    2   默认值 ： 0
    int i = 10;  //整型   int   4       ..
    //类中不允许直接写表达式，需要在我们的方法体中编写
    long l = 100; //长整型   long  8    ..
    float f = 10.4F; //单精度浮点型   float 4  默认值为 0.0f
    double d = 10.8D; //双精度浮点型  double 8  默认值为 0.0d
    char c = 'c';//字符型   char   2   默认值: /u0000
    char zhong = '中';
    static int ii; //不设定初始化参数


    //以上三个都可以称为成员变量,而且成员变量都有默认值
    public static void main(String[] args) {
        int no = 20170265;//no局部变量
        String 威武 = "123";
        int ii;//java里一重要原则就近原则，好几个同名的变量或方法，它去调用的是离它域最近的,局部变量没有默认值
        age = 20;
        //......去数据库或文件中查询值等等，再把取回来的值赋给之前定义好的变量
        ii = 11;
        System.out.println("zhangsan年龄是" + age + "学号:" + no + "威武 = " +威武 +"ii = " +ii);
        short s = 11;
        int i = 22;
        //i = i + 1;
        //i = ++i;//先计算右边的表达式，再赋值给左边的变量
        i+=1;//i = i+1;
        if(23 != i++){ //先右后左
            System.out.println(i);
        }
        //此位置i值已为 23
        i++;//24
        System.out.println(i);
        s = (short) i;//强制类型转换，损失精度
        boolean b = false;
       //boolean类型不能与其他数据类型进行转换操作 i = (int)b;
        /*String str = "aaa\rbbb" ;
        System.out.println(str);
        String str1 = "aaa\tbbb" ;
        System.out.println(str1);*/
        //String str2 = "aaa\\bbb" ;//转义，去掉原来的意义
        //System.out.println(str2);
        //String str3 = "aaa\"bbb" ;//转义，去掉原来的意义
        //System.out.println(str3);
        //Scanner键盘输入
        //System.out.print("请输入:");
        //Scanner sc = new Scanner(System.in);//system.in输入流 ,new 实例化一个对象
        //int i1 = sc.nextInt();
        //System.out.println(i1);
        int a = 14;
        int d = 22;
     /*   if(a < d){ //if语句，接收的就是布尔型
            System.out.println(a-=d);
        }*/

        if(a<10 & d++>22){//前面表达式为false  &&：短路与 后面不在执行  &:不管你前面的表达式是否成立，后面的都会执行
            System.out.println(d%=a);
        }else{
            System.out.println(a*=d);
        }

    }

    /*
     * 此功能是获取年龄与工号的
     */
    public void myAgeAndNo(){
        System.out.println(str);
    }
}
