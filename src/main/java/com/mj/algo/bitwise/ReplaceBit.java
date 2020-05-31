package com.mj.algo.bitwise;

/*
 * We are given two 32 bit numbers, N and M, and two bit positions, i and j. Write a method to insert
 * M into N such that M starts at bit j and ends at bit i. You can assume that the bits j through i have enough 
 * space to fit all of M. That is, if M= 10011, you can assume that there are at least 5 bits between j and i. 
 * You would not, for example, have j=3 and i=2, because M could not fully fit between bit 3 and bit 2.
 * 
 * Example N = 10000000000, M=10011, i=2, j=6
 * Output: N = 10001001100
 */
public class ReplaceBit {
	
	public int replace(int n, int m, int i, int j){
		
		int left = ~0<<(j+1);
		int right = (1 << i) -1;
		int mask = left | right;
		// clear the bits between j and i
		int n_cleared = n & mask;
		int m_shifted = m << i;
		return n_cleared & m_shifted;
		
	}
	
	public static void main(String args[]){
		int n = 1000000;
		int m = 1001;
		ReplaceBit replaceBit = new ReplaceBit();
	    System.out.println(replaceBit.replace(n, m, 5, 1));
	}

}
