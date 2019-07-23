package com.wsmhz.dataStructure.stack.impl;

import com.wsmhz.dataStructure.linked.LinkedList;
import com.wsmhz.dataStructure.stack.Stack;

/**
 * create by tangbj on 2018/10/28
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFrist(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListStack top: ");
        res.append(list);
        return res.toString();
    }
}
