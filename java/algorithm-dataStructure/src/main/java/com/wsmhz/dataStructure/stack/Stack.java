package com.wsmhz.dataStructure.stack;

/**
 * create by tangbj on 2018/10/22
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();


}
