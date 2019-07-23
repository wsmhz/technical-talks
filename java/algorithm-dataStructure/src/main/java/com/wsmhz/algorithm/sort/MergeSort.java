package com.wsmhz.algorithm.sort;

import com.wsmhz.algorithm.common.Generater;

import java.util.Arrays;

/**
 * create by tangbj on 2018/11/29
 * 归并排序
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        sort (arr , 0 , arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right){ // 优化  可以当元素数据量小到一定值时（right - left <= x），进行另外的排序（如插入排序）
            return;
        }
        int mid = (right - left) / 2 + left;
        sort (arr , left , mid);
        sort (arr , mid + 1 , right);
        // 优化 不必每次都进入merge中
        if(arr[mid] > arr[mid + 1]){
            merge (arr , left , mid , right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] copyArr = Arrays.copyOfRange(arr , left , right + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++){
            if(i > mid){
                arr[k] = copyArr[j - left];
                j++;
            }else if(j > right){
                arr[k] = copyArr[i - left];
                i++;
            }else if (copyArr[i - left] < copyArr[j - left]){
                arr[k] = copyArr[i - left];
                i++;
            }else{
                arr[k] = copyArr[j - left];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = Generater.getIntArray();
        mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
