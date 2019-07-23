package com.wsmhz.algorithm.sort;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2018/12/5
 * 堆排序(索引从0开始)
 */
public class HeapSort {

    public static void sort(int[] arr){
        for (int i = (arr.length -1 -1) / 2; i >= 0; i--){
            shiftDown(arr , arr.length , i);
        }
        for (int i = arr.length -1 ; i >= 0; i --){
            Generater.swapIntArr(arr, 0, i);
            shiftDown(arr , i , 0);
        }
    }

    private static void shiftDown(int[] arr, int n , int k){
        while (2 * k + 1 < n){
            int j = 2 * k + 1;
            if(j + 1 < n && arr[j] < arr[ j + 1]){
                j ++;
            }
            if(arr[k] > arr[j]){
                break;
            }
            Generater.swapIntArr(arr , k , j);
            k = j;
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
