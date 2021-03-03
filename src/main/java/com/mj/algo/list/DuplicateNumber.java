package com.mj.algo.list;

public class DuplicateNumber {

    public int findDuplicate(int[] nums){
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow= nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);

        fast = nums[0];
        while(slow!=fast){
            slow= nums[slow];
            fast = nums[fast];
        }

        return slow;

    }


    public static void main(String args[]){
        int[] nums = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        DuplicateNumber dn = new DuplicateNumber();
        int duplicate = dn.findDuplicate(nums);

        System.out.printf("Duplicate No is %1d", duplicate);

    }
}
