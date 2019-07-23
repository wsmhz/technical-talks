package com.wsmhz.algorithm.search;

import com.wsmhz.algorithm.common.Generater;

/**
 * create by tangbj on 2018/11/29
 * 二分搜索（前提：有序）
 */
public class BinarySearch {

    public static int deepSearch(int[] arr , int target){
        return deep(arr , 0 , arr.length - 1 , target);
    }

    public static int loopSearch(int[] arr , int target){
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right){
            mid =  (right - left) / 2 + left;
            if(arr[mid] > target){
                right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    private static int deep(int[] arr, int left, int right, int target) {
        if(left > right){
            return -1;
        }
        int mid = (right - left) / 2 + left;
        if(arr[mid] > target){
            return deep(arr , left ,mid - 1 , target);
        }else if(arr[mid] < target){
            return deep(arr , mid + 1, right , target);
        }else{
            return mid;
        }
    }

    public static void main(String[] args) {
       int[] arr = Generater.getOrderedArray(8);
       System.out.println(deepSearch(arr , 5));
       System.out.println(loopSearch(arr , 5));
       Generater.getIntArray();
    }
}
