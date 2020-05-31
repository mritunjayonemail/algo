package com.mj.algo.dynamic;

/*
	Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
	
	Insert
	Remove
	Replace
	All of the above operations are of equal cost.
 */

public class EditDistance {
	
	static int min(int x,int y,int z) 
    { 
        if (x<=y && x<=z) return x; 
        if (y<=x && y<=z) return y; 
        else return z; 
    } 
	
	static int editDistance(String str1, String str2, int m , int n) {
		if(m == 0) {
			return n;
		}
		if(n == 0) {
			return m;
		}
		
		if (str1.charAt(m-1)== str2.charAt(n-1)) {
			return editDistance(str1, str2, m-1 , n-1);
		}
		else {
			return 1 + min(editDistance(str1, str2, m-1 , n),
					editDistance(str1, str2, m , n-1),
					editDistance(str1, str2, m-1 , n-1));
		}
		
	}
	
	public static void main(String args[]) {
		
		String str1 = "INTENTION";
        String str2 = "EXECUTION";
   
        System.out.println( editDistance( str1 , str2 , str1.length(), str2.length()) ); 
		
	}

}
