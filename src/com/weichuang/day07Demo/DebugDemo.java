package com.weichuang.day07Demo;

public class DebugDemo {
    public static void main(String[] args) {
        int a = 10;
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(i);
            if(5 == i){
                testFn(i , a);
            }
        }
    }

    private static void testFn(int  i ,int a) {
        a++;
        System.out.println(++i + "a = " + a);
    }
}
