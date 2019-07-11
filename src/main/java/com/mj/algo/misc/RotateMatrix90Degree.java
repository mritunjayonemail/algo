package com.mj.algo.misc;

import java.util.*;
import java.lang.*;
import java.io.*;

class RotateMatrix90Degree {
	public static void main(String[] args) throws IOException {
		// code
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			final int N = Integer.parseInt(in.readLine());
			String arr = in.readLine();
			int[][] A = new int[N][N];
			String[] splittedArr = arr.split("\\s+");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					A[i][j] = Integer.parseInt(splittedArr[N * i + j]);
				}
			}
			int length = A.length-1;
			int mid_value = length / 2;
			
			System.out.println(mid_value);

			
			for (int i = 0; i <= mid_value; i++) {
				for (int j = i; j < length-i; j++) {
					int c1 = A[i][j];
					int c2 = A[j][length-i];
					int c3 = A[length-i][length-j];
					int c4 = A[length-j][i];
					
					 A[j][length-i] = c1;
				     A[length-i][length-j] = c2;
				     A[length-j][i] = c3;
				     A[i][j] = c4;
		
				}
	
			}
			
			System.out.println("----");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.println(A[i][j]);
				}
			}
				
			

		}

	}

}