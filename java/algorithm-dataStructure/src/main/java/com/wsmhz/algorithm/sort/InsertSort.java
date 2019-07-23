package com.wsmhz.algorithm.sort;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2018/11/28
 * 插入排序
 */
public class InsertSort {
    /**
     * 原：6 54 7 4 9 2 11
     * 过程：
     *  ↓ ↓
     * 	6 54 7 4 9 2 11
     * 	  ↓  ↓
     * 	6 54 7 4 9 2 11
     * 		↓  ↓
     * 	6 7 54 4 9 2 11 （1轮结束）
     * 	    ↓ ↓
     * 	6 7 4 54 9 2 11
     *    ↓ ↓
     * 	6 4 7 54 9 2 11
     *  ↓ ↓
     * 	4 6 7 54 9 2 11	（1轮结束）
     *
     * 寻找自己合适的插入点，从当前位置向前扫描，若小则交换位置，（若大，终止）
     */
    // 时间复杂度最大O(n^2),接近排好序的最小O(n)，因为内循环可以提前终止
    // 第一种
    private static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    Generater.swapIntArr(arr , j , j-1);
                }
            }
        }
    }

    // 优化：判断大小,若大，前一个覆盖后一个的值，最后只需得到第一个小于自己的前一个数的索引，并覆盖该值
    // 优化了每次交换的次数
    // 第二种
    private static void sort2(int[] arr){
        // TODO
    }

    public static void main(String[] args) {
        int[] arr = Generater.getIntArray();
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
