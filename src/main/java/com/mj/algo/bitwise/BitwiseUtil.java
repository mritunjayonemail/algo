package com.mj.algo.bitwise;

public class BitwiseUtil {
	
	/*
	 * get bit at position i
	 */
	public static boolean getBit(int num, int i){
		return ((num & (1 << i)) == 0);
	}
	
	/*
	 * set bit at position i
	 */
	public static int setBit(int num, int i){
		return  num | (1 << i);
	}
	
	/*
	 * clear bit at position i
	 */
	public static int clearBit(int num, int i){
		int mask = ~(1 << i);
		return num & mask;
	}
	
	/*
	 * Clear all bits from the most significant bit through i (inclusive)
	 */
	public static int clearBitsMSBThroughI(int num, int i){
		int mask = (1<< i) -1;
		return num & mask;
		
	}
	
	/*
	 * Clear all bits through i through 0(inclusive)
	 */
	public static int clearBitsThroughIThrough0(int num, int i){
		int mask = ~((1 << (i+1)) -1);
		return num & mask;
	}
	
	/*
	 * Update bit at location i
	 */
	public static int updateBit(int num, int i, int v){
		int mask = ~( 1 << i);
		return (num & mask) | (v << i);
		
	}
	

}
