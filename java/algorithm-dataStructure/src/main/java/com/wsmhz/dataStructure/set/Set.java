package com.wsmhz.dataStructure.set;

/**
 * create by tangbj on 2018/11/10
 */
public interface Set<E> {

    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();
}
