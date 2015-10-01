package com.mj.algo.recursion;

/*
 * A magic index is an array is defined to be an index such that a[i]=i.
 * Given a sorted array of distinct integers, write a method to 
 * find a magic index if one exists, in array A.
 */
public class MagicArray {
	
	public static int magicFast(int[] array, int start, int end){
		if(start<0 || end>=array.length|| end< start){
			return -1;
		}
		int mid = (start+end)/2;
		if(array[mid]==mid){
			return mid;
		}
		else if(array[mid]==mid){
			return mid;
		}
		else if(array[mid]>mid){
			return magicFast(array, start, mid-1);
		}
		else{
			return magicFast(array, mid+1, end-1);
		}
	}
	
	public static final void main(String[] args){
		int[] array = {-40, -20, -1, 1, 2,3,5,7,9,12,13};
		int magicIndex = magicFast(array, 0,10);
		System.out.print("Matched index is -> " + magicIndex);
	}

}
