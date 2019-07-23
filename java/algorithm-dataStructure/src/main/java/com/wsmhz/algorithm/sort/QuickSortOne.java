package com.wsmhz.algorithm.sort;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2018/11/29
 */
public class QuickSortOne {

    private static void quickSort(int[] arr){
        sort(arr , 0 , arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int p = partition(arr , left , right);
        sort(arr , left , p);
        sort(arr , p + 1 , right);
    }

    private static int partition(int[] arr, int left, int right) {
//      优化 尽可能的让e是随机数，防止近乎顺序的数组退化后的运行复杂度为O（n^2）
//		随机取后，期望的复杂度是O（NlogN）,为O（n^2）的概率几乎为零
        Generater.swapIntArr(arr , left , (int) (Math.random() * (right - left + 1) + left));
        int e = arr[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if(arr[i] < e){
                Generater.swapIntArr(arr , i , j + 1);
                j ++;
            }
        }
        Generater.swapIntArr(arr , left , j);
        return j;
    }

    public static void main(String[] args) {
        int[] arr = Generater.getIntArray();
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
