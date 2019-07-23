package com.wsmhz.algorithm.sort.Practice20190216;

import com.wsmhz.algorithm.common.Generater;

import java.util.Arrays;

/**
 * create by tangbj on 2019/2/16
 */
public class MergeSort {

    public static void sort(int[] arr){
        _sort(arr, 0, arr.length - 1);
    }

    private static void _sort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        _sort(arr, left, mid);
        _sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left,int mid, int right) {
        int[] copyArr = Arrays.copyOfRange(arr, left, right + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if(i > mid){
                arr[k] = copyArr[j - left];
                j ++;
            }else if (j > right){
                arr[k] = copyArr[i - left];
                i ++;
            }else if(copyArr[i - left] < copyArr[j - left]){
                arr[k] = copyArr[i - left];
                i ++;
            }else {
                arr[k] = copyArr[j - left];
                j ++;
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
