package com.mj.algo.misc;

/*
Given an unsorted array with both positive and negative elements.
Find the smallest positive number missing from the array in O(n) time using constant extra space.
It is allowed to modify the original array.

*/
public class SmallestPositiveNumber {

    static int find_smallest(int[] arr){
        int n = arr.length;
        for(int i=0; i< n; i++){

            if (arr[i] <= 0 || arr[i] > n)
                continue;

            int val = arr[i];

            while(arr[val-1] != arr[i]){
                int nextVal = arr[val-1];
                arr[val-1] = val;
                val = nextVal;
                if (val <= 0 || val > n)
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String args[]){
        int [] arr = new int [] {2, 1, 7, 6, 8, -1, -10, 15};

        int missing = find_smallest(arr);

        System.out.println( "The smallest positive" + " missing number is " + missing);
    }
}
