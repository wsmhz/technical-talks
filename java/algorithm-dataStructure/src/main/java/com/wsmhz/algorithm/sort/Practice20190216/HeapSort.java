package com.wsmhz.algorithm.sort.Practice20190216;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2019/2/16
 */
public class HeapSort {

    public static void sort(int[] arr){
        for (int i = (arr.length - 1 - 1) / 2;i >= 0; i --){
            shiftDown(arr,arr.length, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            Generater.swapIntArr(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    private static void shiftDown(int[] arr,int n, int index) {
        while (2 * index + 1 < n ){
            int left = 2 * index + 1;
            if(left + 1 < n && arr[left] < arr[left + 1]){
                left ++;
            }
            if(arr[index] > arr[left]){
                break;
            }
            Generater.swapIntArr(arr, index, left);
            index = left;
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
