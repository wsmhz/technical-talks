package com.wsmhz.algorithm.sort.Practice20190216;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2019/2/16
 */
public class SelectionSort {

    public static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
           int minIndex = i;
           for (int j = i; j < arr.length; j++){
               if(arr[j] < arr[minIndex]){
                   minIndex = j;
               }
           }
           Generater.swapIntArr(arr, minIndex, i);
        }
    }

    public static void main(String[] args) {
        int[] array = Generater.getIntArray();
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
