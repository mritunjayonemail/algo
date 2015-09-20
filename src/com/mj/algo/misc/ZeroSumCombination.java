package com.mj.algo.misc;

public class ZeroSumCombination {
	
	void printCombinationZeroSum(int arr[], int n, int r)
	{
		int [] data= new int[r];
	 
	    // Print all combination using temprary array 'data[]'
	    combinationUtilZeroSum(arr, n, r, 0, data, 0);
	}
	
	void combinationUtil(int arr[], int n, int r, int index, int data[], int i)
	{	
		if(index == r){
			for(int pos = 0; pos<r; pos++){
				System.out.print(data[pos] + " ");
			}
			System.out.println();
			return;
		}
		
		if(i>=n){
			return;
		}
		data[index]=arr[i];
		
		// current is included, put next at next location
		combinationUtil(arr,n, r, index+1, data, i+1);
		
		// current is excluded, replace it with next (Note that
	    // i+1 is passed, but index is not changed)
		combinationUtil(arr,n, r, index, data, i+1);
		
	}

	void combinationUtilZeroSum(int arr[], int n, int r, int index, int data[], int i)
	{	
		if(index == r){
			if(checkSumtoZero(data)){
				System.out.println();
			}
			return;
		}
		
		if(i>=n){
			return;
		}
		data[index]=arr[i];
		
		// current is included, put next at next location
		combinationUtil(arr,n, r, index+1, data, i+1);
		
		// current is excluded, replace it with next (Note that
	    // i+1 is passed, but index is not changed)
		combinationUtil(arr,n, r, index, data, i+1);
		
	}
	
	private boolean checkSumtoZero(int[] input){
		if(input == null){
			return false;
		}
		int sum = 0;
		for(int index = 0; index<input.length; index++){
			sum = sum + input[index];
		}
		if(sum == 0){
			return true;
		}
		return false;
	}
	
	private void findSumToZero(int[] input){
		for(int index = 0; index<input.length; index++){
			printCombinationZeroSum(input, input.length, index);
		}
	}
	
	
	
	public static final void main(String args[]){
		ZeroSumCombination zeroSumCombination = new ZeroSumCombination();
		int[] input = {2, 3, 1, -2, -1, 0, 2, -3, 0};
		zeroSumCombination.findSumToZero(input);
	}

}
