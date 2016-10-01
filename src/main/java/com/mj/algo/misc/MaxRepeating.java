package com.mj.algo.misc;

/*
 * Maximum repeating integer in an array
 */
public class MaxRepeating {
	
	private static final int maxRepeating(int[] input, int k){
		int size = input.length;
		int []count = new int[k];
		
		for(int index =0 ; index<size; index++){
			count[input[index]%size] += size;
		}
		
		int max = Integer.MIN_VALUE;
		int result = -1;
	    for (int i = 0; i < k; i++)
	    {
	        if (count[i] > max)
	        {
	            max = count[i];
	            result = i;
	        }
	    }
	    
	    //for (int i = 0; i< size; i++)
	    	//input[i] = input[i]%size;
	    
	    return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int input[] = {2, 3, 3, 5, 3, 4, 1, 7, 7, 7, 9, 8, 8, 8, 9, 8};
		//int input[]= {17, 9, 13, 13, 13, 13, 13, 13, 13, 14, 13, 13, 13, 13, 13, 13, 15};
		//int result = maxRepeating(input);
		int input[]= {33, 46,17,35, 46};
		final int result = maxRepeating(input, 46);
		System.out.println("Maximun repeating word is -> " + input[result]);

	}

}
