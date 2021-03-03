package com.mj.algo.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */
public class Subset {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsetRec(subsets, nums, 0, new ArrayList<Integer>());
        return subsets;
    }

    public void subsetRec(List<List<Integer>> subsets, int[] nums, int index, List<Integer> current){
        subsets.add(new ArrayList<Integer>(current));
        for(int i=index; i<nums.length; i++){
            current.add(nums[i]);
            subsetRec(subsets, nums, i+1, current);
            current.remove(current.size()-1);
        }

    }

    public static void main(String args[]){
        Subset subset = new Subset();
        List<List<Integer>> subsets = subset.subsets(new int[]{1, 2, 3});
        for(List<Integer> item : subsets){
            for(Integer i : item){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }


}
