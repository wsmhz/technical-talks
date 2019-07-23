package com.wsmhz.dataStructure.set.impl;

import com.wsmhz.dataStructure.linked.LinkedList;
import com.wsmhz.dataStructure.set.Set;

/**
 * create by tangbj on 2018/11/10
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if( ! linkedList.contains(e)){
            linkedList.addFrist(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
