package com.mj.algo.leetcode;

/*
You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to the closest person.


 */
public class ShortestDistance {

    public int maxDistToClosest(int[] seats) {
        int maxPos = -1;
        int maxDistance = -1;
        for(int i=0; i<seats.length; i++){
            if(seats[i]==0){
                int closestPos = findClosest(i, seats);
                int max = Math.abs(closestPos - i);
                if(maxDistance<max){
                    maxDistance = max;
                    maxPos = i;
                }
            }
        }
        return maxDistance;
    }

    private int findClosest(int pos, int[] seats){

        int min = Integer.MAX_VALUE;
        int minPos = 0;
        for(int i=0; i<seats.length; i++){
            if(seats[i] == 1){
                int dist = Math.abs(pos-i);
                if(min>dist){
                    min = dist;
                    minPos = i;
                }
            }
        }
        return minPos;

    }

    public static void main(String args[]){

        int[] seats= new int[]{1,0,0,0,1,0,1};
        ShortestDistance shortestDistance = new ShortestDistance();
        System.out.println(shortestDistance.maxDistToClosest(seats));


    }
}
