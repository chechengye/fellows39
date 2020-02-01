package com.weichuang.day11Demo.iteractor;

public class IteratorTest {

    public static void main(String[] args) {
        IMyList myList = new ConcreteAggregate();
        myList.add("lucy");
        myList.add("lily");
        myList.add("tom");
        myList.add("jack");
        IIterator iterator = myList.iterator();
        System.out.println(myList.get(3));
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
