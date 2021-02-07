package com.mj.algo.dynamic;

/*
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach
(m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell.
Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
You can only traverse down, right and diagonally lower cells from a given cell, i.e.,
from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed.
You may assume that all costs are positive integers.
 */

public class MinimumCostPath {

	static int min(int x, int y, int z) 
    { 
        if (x < y) 
            return (x < z) ? x : z; 
        else
            return (y < z) ? y : z; 
    }  
	
	

	static int minCost(int[][] cost, int m, int n) {
		
		if (n < 0 || m < 0) 
            return Integer.MAX_VALUE; 
        else if (m == 0 && n == 0) 
            return cost[m][n]; 
        else
            return 1 +
                min( minCost(cost, m-1, n-1), 
                     minCost(cost, m-1, n),  
                     minCost(cost, m, n-1) ); 

	}

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		
	    
	    int[][] cost = new int[][]{ {1, 2,3}, {4, 8, 2}, {1, 5, 3}};
	    System.out.println(minCost(cost, 2,2));
	   

	}

}
