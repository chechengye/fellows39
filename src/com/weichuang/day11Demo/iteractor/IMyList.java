package com.weichuang.day11Demo.iteractor;

public interface IMyList {
    void add(Object o);
    IIterator iterator();
    Object get(int index);
    int size();
}
