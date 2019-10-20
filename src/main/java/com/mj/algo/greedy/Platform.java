package com.mj.algo.greedy;

/*
Given arrival and departure times of all trains that reach a railway station, 
find the minimum number of platforms required for the railway station so that no train waits.
*/

public class Platform {
	
	public static int findPlatforms(int[] arrivals, int[] departures) {
		int n = arrivals.length;
		int platforms = 1;
		int result =1;
		int i=1;
		int j=0;
		while(i<n && j<n) {
			if(arrivals[i]<=departures[j]) {
				platforms++;
				i =i + 1;
				// Update result if needed  
		         if (platforms > result)  
		             result = platforms; 
			}
			else {
				platforms--;
				j = j + 1;
			}
				
		}
		return result;
		
	}
	
	public static void main(String args[]) {
		int[] arrivals = {900, 940, 950, 1100, 1500, 1800};
		int[] departures = {910, 1200, 1120, 1130, 1900, 2000};
		int paltforms = findPlatforms(arrivals, departures);
		System.out.print("Platform needed " + paltforms );
	}

}
