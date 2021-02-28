package com.mj.algo.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/*
You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
Complexity of algorithm is O(N^2)
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length==0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] x1, int[] x2){
                if(x1[0] == x2[0]){
                    return x2[1] - x1[1];
                }
                else {
                    return x1[0]-x2[0];
                }
            }
        });


        int n = envelopes.length;
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
        }
        for(int i=1; i<n;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    dp[i] = Math.max(dp[i], 1+ dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();

    }

    public static void main(String args){
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        RussianDollEnvelopes rde = new RussianDollEnvelopes();
        System.out.printf("Max size of envelopes are %1d",  rde.maxEnvelopes(envelopes));
    }


}
