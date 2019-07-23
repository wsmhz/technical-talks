package com.wsmhz.dataStructure.queue;

import com.wsmhz.dataStructure.queue.impl.ArrayQueue;
import com.wsmhz.dataStructure.queue.impl.LinkedListQueue;
import com.wsmhz.dataStructure.queue.impl.LoopQueue;

/**
 * create by tangbj on 2018/10/23
 */
public class QueueTest {

    private static double testQueue(Queue<Integer> queue,int count){
        Long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }

        Long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("ArrayQueue time: " + testQueue(arrayQueue,count));

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("LoopQueue time: " + testQueue(loopQueue,count));

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("LinkedListQueue time: " + testQueue(linkedListQueue,count));
    }
}
