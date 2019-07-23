package com.wsmhz.algorithm.sort;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2018/11/28
 * 选择排序
 */
public class SelectionSort {
    /**
     * 原：6 54 7 4 9 2 11
     * 过程：找到最小的
     *	↓ ↓
     *	6 54 7 4 9 2 11
     * 	↓	 ↓
     *	6 54 7 4 9 2 11
     *  ↓	   ↓
     *	6 54 7 4 9 2 11
     * 	  	   ↓ ↓
     *	6 54 7 4 9 2 11
     *	  	   ↓   ↓
     *	6 54 7 4 9 2 11
     *	  		   ↓ ↓
     *	6 54 7 4 9 2 11
     *	把本轮最小的数与索引为i的交换位置，即（第一小，第二小，第三小...）以此类推
     *
     *	一次后：2 54 7 4 9 6 11
     */
    private static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int j = i + 1 ; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            Generater.swapIntArr(arr , i ,minIndex);
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
