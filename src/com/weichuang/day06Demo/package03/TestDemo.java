package com.weichuang.day06Demo.package03;

import com.weichuang.day06Demo.package02.PowerDemo;

public class TestDemo {
    public static void main(String[] args) {
        PowerDemo pd = new PowerDemo();
        pd.testMethod();
        com.weichuang.day06Demo.package01.PowerDemo pd2 = new com.weichuang.day06Demo.package01.PowerDemo();
        pd2.drink();
    }
}
