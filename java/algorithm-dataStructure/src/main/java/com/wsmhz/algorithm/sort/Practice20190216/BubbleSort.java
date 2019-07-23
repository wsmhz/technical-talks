package com.wsmhz.algorithm.sort.Practice20190216;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2019/2/16
 */
public class BubbleSort {

    public static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length - i; j++){
                if(arr[j - 1] > arr[j]){
                    Generater.swapIntArr(arr, j-1 , j);
                }
            }
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
