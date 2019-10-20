package com.mj.algo.google;
import java.util.Arrays;  
import java.io.*;

/*
	Input : arr[] = {0, -1, 2, -3, 1}
	Output : 0 -1 1
	         2 -3 1
	
	Input : arr[] = {1, -2, 1, 0, 5}
	Output : 1 -2  1
 */

public class TripletWithZeroSum {
	
	public static void tripletWithZeroSum(int[] arr) {
		Arrays.sort(arr);
		int n = arr.length;
		for(int i =0; i<n-1; i++) {
			int l= i+1;
			int r = n-1;
			while(l<r) {
				if(arr[i] + arr[l] + arr[r] == 0) {
					 System.out.print(arr[i] + " "); 
	                 System.out.print(arr[l]+ " "); 
	                 System.out.println(arr[r]+ " "); 
	                 l++;
	                 r--;
				}
				else {
					if(arr[i] + arr[l] + arr[r] < 0) {
						l++;
					}
					else {
						r--;
					}
				}
					
			}		
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {0, -1, 2, -3, 1};  
		 tripletWithZeroSum(arr); 

	}

}
