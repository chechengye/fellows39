package com.weichuang.day11Demo.iteractor;

/**
 * 聚合角色的具体实现
 */
public class ConcreteAggregate implements IMyList{
    private Object[] list = null;
    private int index;
    private int size;
    public ConcreteAggregate(){
        list = new Object[50];
    }
    @Override
    public void add(Object o) {
        list[index++] = o;
        size++;
    }

    @Override
    public IIterator iterator() {
        return new ConcreteIterator(this);
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public int size() {
        return size;
    }
}
