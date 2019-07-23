package com.wsmhz.algorithm.sort.Practice20190216;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2019/02/24
 */
public class QuickSortTwo {


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
       int j = left + 1;
       int k = right;
       while(true){
           while(j <= k && arr[j] < e){
               j++;
           }
           while(j <= k && arr[k] > e){
               k--;
           }
           if(j >= k){
               break;
           }
           Generater.swapIntArr(arr, j , k);
           j++;
           k--;
       }
       Generater.swapIntArr(arr, left , j - 1);
       return j - 1;
    }

    public static void main(String[] args) {
        int[] arr = Generater.getIntArray();
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
