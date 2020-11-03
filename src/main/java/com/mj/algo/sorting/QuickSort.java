package com.mj.algo.sorting;


import java.util.Arrays;

//  Quick sort
/*
Quick sort
Complexity best case - O(nlogn), worst case - o(n**2)
 */
public class QuickSort {

    public int quick(int[] arr, int start, int end ){
        int pivot = start;
        int left = start;
        int right= end;

        // traverse from right to left
        while(left<right){
           if(arr[pivot]<arr[right]){
               right--;
           }
           else {
               int tmp = arr[right];
               arr[right] = arr[pivot];
               arr[pivot] = tmp;
               pivot = right;
               break;
           }
        }

        // traverse from left to right
        while(left<right){
            if(arr[pivot]>arr[left]){
                left++;
            }
            else {
                int tmp = arr[left];
                arr[left] = arr[pivot];
                arr[pivot] = tmp;
                pivot = left;
                break;
            }
        }
        return pivot;

    }

    public void sort(int[] arr, int start, int end){
        if (start==end){
            return;
        }
        int pivot = quick(arr, start, end);
        if(start<pivot-1) {
            sort(arr, start, pivot - 1);
        }
        if(pivot+1<end) {
            sort(arr, pivot + 1, end);
        }
    }



    public static void main(String args[]){
        int[] arr = {8, 1, 4, 9, 12, 10};
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
