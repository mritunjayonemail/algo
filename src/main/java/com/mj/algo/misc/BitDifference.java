package com.mj.algo.misc;

/*
Given an integer array of n integers, find sum of bit differences in all pairs that can be formed from array elements.
Bit difference of a pair (x, y) is count of different bits at same positions in binary representations of x and y.
For example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010 and 7 is 111( first and last bits differ in two numbers).
*/

public class BitDifference {
    /*
    An Efficient Solution can solve this problem in O(n) time using the fact that all numbers are represented using 32 bits
    (or some fixed number of bits). The idea is to count differences at individual bit positions.
    We traverse from 0 to 31 and count numbers with i’th bit set. Let this count be ‘count’.
    There would be “n-count” numbers with i’th bit not set. So count of differences at i’th bit would be “count * (n-count) * 2”,
    the reason for this formula is as every pair having one element which has set bit at i’th position
    and second element having unset bit at i’th position contributes exactly 1 to sum,
    therefore total permutation count will be count*(n-count) and multiply by 2 is due to
    one more repetition of all this type of pair as per given condition for making pair 1<=i,j<=N.
     */

    public static int sumBitDifferences(int[] arr, int n){
        int ans = 0;
        for (int i=0; i<32; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if ((arr[j] & (1 << i)) == 0){
                    count +=1;
                }
            }
            ans += count * (n - count)*2;
        }
        return ans;
    }

    public static void main(String[] args){
        int arr[] = { 2, 3 };
        int n = arr.length;

        System.out.println(1 << 5);

        System.out.println(sumBitDifferences(
                arr, n));
    }
}
