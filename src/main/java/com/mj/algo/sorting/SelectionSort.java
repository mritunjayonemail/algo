package com.mj.algo.sorting;

import java.util.Arrays;

/*
Insertion sort
Complexity is O(n**2)
 */
public class SelectionSort {

    public int[] selectionSort(int[] arr){
        for(int index=0; index<arr.length; index++){
            // get index of minimum element
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i= index; i<arr.length; i++){
                if(min>arr[i]){
                    min=arr[i];
                    minIndex = i;
                }
            }

            // swap minimum node index with current index
            int tmp = arr[index];
            arr[index] = arr[minIndex];
            arr[minIndex] = tmp;

        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {4, 2, 10, 2, 6};
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(selectionSort.selectionSort(arr)));
    }

}
