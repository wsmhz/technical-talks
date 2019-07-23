package com.wsmhz.algorithm.common;

import java.util.Random;

/**
 * create by tangbj on 2018/11/28
 */
public class Generater {

    public static int[] getIntArray(){
        int arr[] = new int[]{6,54,7,4,9,2,11};
        System.out.print("原：  ");
        for (int i = 0;i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }
    public static int[] getRandomIntArray(int n){
        int arr[] = new int[n];
        System.out.print("原：  ");
        Random random = new Random();
        for (int i = 0;i < arr.length;i++) {
            arr[i] = random.nextInt(n * 10);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }
    public static int[] getOrderedArray(int n){
        int[] arr = new int[n];
        System.out.print("原：  ");
        for(int i = 0;i < n;i++){
            arr[i] = i+1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }
    public static void swapIntArr(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
