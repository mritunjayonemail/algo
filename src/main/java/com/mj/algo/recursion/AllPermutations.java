package com.mj.algo.recursion;

/*
 * All permutation of a input integer array
 */
public class AllPermutations {
	
	private  String swap(String input, int index1, int index2){
		char index1Char = input.charAt(index1);
		char index2Char = input.charAt(index2);

		char[] charArray = input.toCharArray();
		charArray[index1]=index2Char;
		charArray[index2]= index1Char;
		input = String.valueOf(charArray);
		return input;
	}
	
	private  int[] swap(int[] input, int index1, int index2){
		int index1Val = input[index1];
		int index2Val = input[index2];

		input[index1]=index2Val;
		input[index2]= index1Val;
		return input;
	}
	
	
	private  void allPermutations(String input, int start, int end){
		
		if(start == end){
			System.out.println(input);
		}
		else {
			for(int index = start; index<end; index++){
				input = swap(input, start, index);
				allPermutations(input, start+1, end);
			}
		}
		
	}

	
	
	public static final void main(String args[]){
		String input = "123";
		AllPermutations allPermutations= new AllPermutations();
		allPermutations.allPermutations(input, 0, input.length());
	}

}
