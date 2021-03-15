package com.mj.algo.dynamic;


/*
The maximum subarray problem is the task of finding the largest possible sum of a contiguous subarray, within a given one-dimensional array A[1…n] of numbers.
Image for post
Maximum Sum Subarray (In Yellow)
arry [] = {-2, 1, -3, 4, -1, 2, 1, -5, 4}
For example, for the array given above, the contiguous subarray with the largest sum is [4, -1, 2, 1], with sum 6.
 */
public class MaximumSubArray {
    public int getMaximumSubArray(int[] nums){
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        for(int i=0;i <nums.length; i++){
            localMax = Math.max(nums[i], localMax+nums[i]);
            if(globalMax<localMax)
                globalMax = localMax;
        }
        return globalMax;
    }

    public static void main(String args[]){
        int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum sum of contiguous array is " + new MaximumSubArray().getMaximumSubArray(nums));
    }
}
