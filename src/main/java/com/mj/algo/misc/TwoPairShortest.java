package com.mj.algo.misc;

public class TwoPairShortest {
	
	private static void sortestPairDiif(int a1[], int a2[], int m, int n, int sum){
		int l = 0; 
		int r = n-1;
		int diff = Integer.MAX_VALUE;
		int res_l=0;
		int res_r = 0;
		while(l<m && r>=0){
			if((Math.abs(a1[l] + a2[r] - sum))< diff){
				res_l = l;
				res_r = r ;
				diff = Math.abs(a1[l] + a2[r] - sum);
			}
			else if((a1[l] + a2[r])>sum){
				r--;
			}
			else {
				l++;
			}
		}
		System.out.print("Closes pair is -> " + a1[res_l] + " and " + a2[res_r]);
		
	}
	
	public static void main(String args[]){
		int ar1[] = {1, 4, 5, 7};
	    int ar2[] = {10, 20, 30, 40};
	    
	    int m = 4;
	    int n= 4;
	    sortestPairDiif(ar1, ar2, m, n, 50);
	    
	}

}
