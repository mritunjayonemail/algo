package com.mj.algo.sorting;

import java.util.Arrays;

/*
Insertion sort
Complexity is O(n**2)
 */
public class InsertionSort {

    public int[] insertionSort(int[] arr){
        for(int index=0; index<arr.length; index++){

            int i = 0;
            while(i<index){
                int currentItem = arr[index];
                if(arr[i]>currentItem){
                    arr[index] = arr[i];
                    arr[i] = currentItem;
                }
                i++;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {4, 2, 10, 2, 6};
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(insertionSort.insertionSort(arr)));
    }
}
