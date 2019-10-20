package com.mj.algo.dynamic;

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
            return cost[m][n] +  
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
