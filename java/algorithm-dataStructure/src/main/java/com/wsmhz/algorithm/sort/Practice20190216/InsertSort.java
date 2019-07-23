package com.wsmhz.algorithm.sort.Practice20190216;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2019/2/16
 */
public class InsertSort {

    public static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for (int j = i; j > 0; j --){
                if (arr[j] < arr[j-1]){
                    Generater.swapIntArr(arr, j , j-1);
                }else {
                    break;
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
