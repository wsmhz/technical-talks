package com.wsmhz.questions.leetcode;

import com.wsmhz.dataStructure.queue.impl.PriorityQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * create by tangbj on 2018/11/19
 *
 * 347. 前K个高频元素
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class TopKFrequent {
    private class Fre implements Comparable<Fre>{
        int e;
        int fre;

        public Fre(int e, int fre) {
            this.e = e;
            this.fre = fre;
        }

        @Override
        public int compareTo(Fre fre) {
            if (this.fre < fre.fre){
                return 1;
            } else if(this.fre > fre.fre)
                return -1;
            else
                return 0;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if(treeMap.containsKey(num)){
                treeMap.put(num,treeMap.get(num) + 1);
            }else{
                treeMap.put(num,1);
            }
        }
        PriorityQueue<Fre> priorityQueue = new PriorityQueue<>();
        for (Integer key : treeMap.keySet()) {
            if(priorityQueue.getSize() < k){
                priorityQueue.enqueue(new Fre(key,treeMap.get(key)));
            }else{
                if(treeMap.get(key) > priorityQueue.getFront().fre){
                    priorityQueue.dequeue();
                    priorityQueue.enqueue(new Fre(key,treeMap.get(key)));
                }
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        while ( ! priorityQueue.isEmpty()){
            list.add(priorityQueue.dequeue().e);
        }
        return list;
    }
}
