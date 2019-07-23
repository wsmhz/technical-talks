package com.wsmhz.algorithm.sort.Practice20190216;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2019/02/24
 */
public class QuickSortOne {


    public static void quickSort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int p = partition(arr, left , right);
        sort(arr, left , p);
        sort(arr , p+1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int e = arr[left];
        int k = left;
        for (int i = left + 1;i <= right; i++){
            if(arr[i] < e){
                Generater.swapIntArr(arr, i , k + 1);
                k++;
            }
        }
        Generater.swapIntArr(arr, left, k);
        return k;
    }

    public static void main(String[] args) {
        int[] arr = Generater.getIntArray();
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
