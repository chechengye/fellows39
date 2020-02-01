package com.weichuang.day11Demo.iteractor;

public class ConcreteIterator implements IIterator {

    private IMyList myList;
    private int index;
    public ConcreteIterator(IMyList myList){
        this.myList = myList;
    }
    @Override
    public boolean hasNext() {
        if(index >= this.myList.size()){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        return this.myList.get(index++);
    }
}
