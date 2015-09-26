package com.mj.algo.dynamic;

/*
 * Maximum sum of array in which two consecutive elements are not allowed.
 * It is using dynamic programming.
 */
public class MaxSum {
	
	private static int maxSum(int[] arr){
		if(arr==null || arr.length==0){
			return 0;
		}
		
		int length = arr.length;
		
		if(length==1){
			return arr[0];
		}
		
		int[] sum = new int[length];
		sum[0]=arr[0];
		sum[1]= arr[0]>arr[1]?arr[0]:arr[1];
		if(length==2){
			return sum[1];
		}
		
		for(int index=2;index<length;index++){
			int incl = sum[index-2]+arr[index];
			sum[index]= incl>sum[index-1]?incl:sum[index-1];
		}
		return sum[length-1];

		
	}

	public static void main(String[] args) {
		 int arr[] = {5,  5, 10, 40, 50, 35};
		 System.out.println("Max Sum ->" + maxSum(arr));

	}

}
