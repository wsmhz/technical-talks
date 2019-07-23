package com.wsmhz.algorithm.sort.Practice20190216;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2019/02/24
 */
public class QuickSortThree {


    public static void quickSort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int e = arr[left];
        int lt = left;
        int gt = right + 1;
        int i = left + 1;
        while( i < gt){
            if(arr[i] < e){
                Generater.swapIntArr(arr, i , lt + 1);
                i++;
                lt ++;
            }else if(arr[i] > e){
                Generater.swapIntArr(arr, i , gt - 1);
                gt --;
            }else {
                i++;
            }
        }
        Generater.swapIntArr(arr, left, lt);
        sort(arr, left, lt - 1);
        sort(arr, gt , right);
    }

    public static void main(String[] args) {
//        int[] arr = Generater.getIntArray();
        int[] arr = {2,0,2,1,1,0};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
