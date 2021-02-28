package com.mj.algo.recursion;

import java.util.Arrays;

/*
Find Longest Increasing subsequence
arr [] = {0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15}
 */
public class LIS {

    public int findLIS(int [] nums){
        if(nums ==null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int dp[] = new int[nums.length];
        for(int i=0; i<n; i++){
            dp[i] =1;
        }
        int[] subSeq = new int[n];
        for(int i=0; i<n; i++){
            subSeq[i] =0;
        }
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j]<=nums[i]){
                    dp[i]= Math.max(dp[i], 1+dp[j]);
                    subSeq[i]=j;
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String args[]){
        int[] nums = {0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15};
        int maxSeq = new LIS().findLIS(nums);
        System.out.printf("Maximum sum is %1d", maxSeq);
    }
}
