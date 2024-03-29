package com.mj.algo.dynamic;

/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.



Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.


Constraints:

n == ratings.length
1 <= n <= 2 * 104
1 <= ratings[i] <= 2 * 104
 */
public class CandyDistribution {

    public int candy(int[] ratings) {

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        for(int i=0; i<ratings.length; i++){
            left[i] = 1;
            right[i] = 1;
        }



        for(int i=1; i<ratings.length; i++){
            if(ratings[i-1]<ratings[i]){
                left[i] = left[i-1] +1;
            }
        }

        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                right[i] = right[i+1] +1;
            }
        }

        // get max
        int candies = 0;
        for(int i=0; i<ratings.length; i++){
            candies = candies + Math.max(left[i] , right[i]);
        }
        return candies;

    }

    public static void main(String args[]){
        int [] rankings = {1,0,2};
        CandyDistribution cd = new CandyDistribution();
        System.out.println("Total candies required " + cd.candy(rankings));
    }
}
