package com.wsmhz.algorithm.sort;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2018/11/28
 * 冒泡排序
 */
public class BubbleSort {
    /**
     * 原：[6 54] 7 4 9 2 11
     * 过程：6 [54 7] 4 9 2 11
     * 		6 7 [54 4] 9 2 11
     * 		6 7 4 [54 9] 2 11
     * 		6 7 4 9 [54 2] 11
     * 		6 7 4 9 2 [54 11]
     * 一次后：6 7 4 9 2 11 54
     *
     * 0开始处，前一个跟后一个比较，如果前大于后，交换位置，直到数组最后,i++。
     * 继续0开始，相比...比到数组长度减去比过的次数（a.length-i），交换过的不需要相比。
     */
    private static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 1;j < arr.length - i; j ++){
                if(arr[j-1] > arr[j]){
                    Generater.swapIntArr(arr , j-1 , j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Generater.getIntArray();
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
