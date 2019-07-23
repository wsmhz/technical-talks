package com.wsmhz.dataStructure.queue.impl;

import com.wsmhz.dataStructure.heap.MaxHeap;
import com.wsmhz.dataStructure.queue.Queue;

/**
 * create by tangbj on 2018/11/14
 *
 * 优先队列，采用最大堆方式
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize(){
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront(){
        return maxHeap.findMax();
    }

    @Override
    public void enqueue(E e){
        maxHeap.add(e);
    }

    @Override
    public E dequeue(){
        return maxHeap.extractMax();
    }
}

