package com.wsmhz.algorithm.sort;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2018/11/29
 */
public class QuickSortThree {

    public static void quickSort(int[] arr){
        sort(arr , 0 , arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int lt = left;
        int gt = right + 1;
        int i = left + 1;
//      优化 尽可能的让e是随机数，防止近乎顺序的数组退化后的运行复杂度为O（n^2）
//		随机取后，期望的复杂度是O（NlogN）,为O（n^2）的概率几乎为零
        Generater.swapIntArr(arr , left , (int) (Math.random() * (right - left + 1) + left));
        int e = arr[left];
        while (i < gt){
            if(arr[i] < e){
                Generater.swapIntArr(arr , i , lt + 1);
                lt ++;
                i ++;
            }else if(arr[i] == e){
                i ++;
            }else{
                Generater.swapIntArr(arr , i , gt - 1);
                gt --;
            }
        }
        Generater.swapIntArr(arr , left , lt);
        sort(arr , left , lt - 1);
        sort(arr , gt , right);
    }

    public static void main(String[] args) {
        int[] arr = Generater.getIntArray();
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
