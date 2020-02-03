package com.weichuang.day13Demo;

public class Person implements IPerson {

    @Override
    public boolean shopping() {
        System.out.println("付款，买到心仪商品!!");
        return true;
    }

    @Override
    public void drink(String thing) {

    }
}
