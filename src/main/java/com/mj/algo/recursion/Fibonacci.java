package com.mj.algo.recursion;

public class Fibonacci {
	
	/*
	 * Fibonacci series using dynamic programming.
	 * it has complexity of o(n) time
	 * 
	 */
	private static int[] dynamicFib(int n){
		int[] fib = new int[n+1];
		fib[0] = 0;
		fib[1] = 1;
		
		//Complexity will be order of n
		for(int index=2; index<n; index++){
			fib[index] = fib[index-2]+fib[index-1];
		}
		return fib;	
	}
	
	
	public static void main(String args[]){
		int[] fib = dynamicFib(8);
		
		for(int index =0; index<8; index++){
			System.out.println(fib[index]);
		}
	}
	
	

}
