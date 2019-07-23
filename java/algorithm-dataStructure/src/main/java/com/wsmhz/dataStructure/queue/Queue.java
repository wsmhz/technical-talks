package com.wsmhz.dataStructure.queue;

/**
 * create by tangbj on 2018/10/22
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
