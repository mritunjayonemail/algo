package com.mj.algo.recursion;

/*
 * All combination of a input integer array
 */
public class AllCombinations {
	
	// The main function that prints all combinations of size r
	// in arr[] of size n. This function mainly uses combinationUtil()
	void printCombination(int arr[], int n, int r)
	{
		int [] data= new int[3];
	 
	    // Print all combination using temprary array 'data[]'
	    combinationUtil(arr, n, r, 0, data, 0);
	}
	
	
	/* arr[]  ---> Input Array
	   n      ---> Size of input array
	   r      ---> Size of a combination to be printed
	   index  ---> Current index in data[]
	   data[] ---> Temporary array to store current combination
	   i      ---> index of current element in arr[]     */
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

	
	public static final void main(String args[]){
		AllCombinations allCombinations= new AllCombinations();
		int[] input = {2, 3, 1, -2, -1, 0, 2, -3, 0};
		allCombinations.printCombination(input, 9, 1);
	}

}
