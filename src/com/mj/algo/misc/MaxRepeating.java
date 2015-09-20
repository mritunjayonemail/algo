package com.mj.algo.misc;

/*
 * Maximum repeating integer in an array
 */
public class MaxRepeating {
	
	private static final int maxRepeating(int[] input, int k){
		int size = input.length;
		for(int index =0 ; index<size; index++){
			input[input[index]%k] += k;
		}
		
		int max = input[0], result = 0;
	    for (int i = 1; i < size; i++)
	    {
	        if (input[i] > max)
	        {
	            max = input[i];
	            result = i;
	        }
	    }
	    return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {2, 3, 3, 5, 3, 4, 1, 7, 7, 7, 9,8,8,8, 9, 8};
		int result = maxRepeating(input, 10);
		System.out.println("Maximun repeating word is -> " + result);
		int x = 2%7;
		System.out.println(x);

	}

}
