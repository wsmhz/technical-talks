package com.wsmhz.dataStructure.stack;

import com.wsmhz.dataStructure.queue.Queue;
import com.wsmhz.dataStructure.queue.impl.ArrayQueue;
import com.wsmhz.dataStructure.queue.impl.LoopQueue;
import com.wsmhz.dataStructure.stack.impl.ArrayStack;
import com.wsmhz.dataStructure.stack.impl.LinkedListStack;

/**
 * create by tangbj on 2018/10/23
 */
public class StackTest {

    private static double testStack(Stack<Integer> stack,int count){
        Long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            stack.push(i);
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }

        Long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("ArrayStack time: " + testStack(arrayStack,count));

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("LinkedListStack time: " + testStack(linkedListStack,count));
    }
}
