package com.mj.algo.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

			
//			for (int i = 0; i <= mid_value; i++) {
//				for (int j = i; j < length-i; j++) {
//					int c1 = A[i][j];
//					int c2 = A[j][length-i];
//					int c3 = A[length-i][length-j];
//					int c4 = A[length-j][i];
//					
//					 A[j][length-i] = c1;
//				     A[length-i][length-j] = c2;
//				     A[length-j][i] = c3;
//				     A[i][j] = c4;
//		
//				}
//	
//			}

			
			for (int i = 0; i <= mid_value; i++) {
				for (int j = i; i <= length-i; j++) {
					
					
					int temp = A[i][j];
					A[i][j]= A[j][length-i];
					A[j][length-i] = A[length-i][length-j];
					A[length-i][length-j]= A[length-j][i];
					A[length-j][i]= temp;
							
					/*int c1 = A [i][j];
					int c2 = A[j][length-i];
					int c3 = A[length-i][length-j];
					int c4 = A[length-j][i];
					
					A [i][length-j] = c1;
					A[length-i][length -j]=c2;
					A[length-j][i]=c3;
					A[i][j]=c4;*/
					
							
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


	private void rotateMatrix(){
		int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

		/*
		1  2  3
 		4  5  6
 		7  8  9

 		Reverse
 		3 6 9
 		2 5 8
 		1 4 7

 		A[0][0] = A[0][2]
 		A[0][1] = A[1][2]
 		A[0][2] = A[2][2]

 		A[1][0] = A[0][1]
		A[1][1] = A[1][1]
		A[1][2] = A[2][1]

		A[2][0] = A[0][0]
		A[2][1] = A[1][0]
		A[2][2] = A[2][0]

		int [][] C = new int[N][N]
		for (int i=0; i<N; i++){
			for (int j=0; j<N; j++){
				C[i][j] = A[J][N-1-i]
			}
		}
		 */

		A[0][0]= 1;
		A[0][1]= 2;
		A[0][2]= 3;
		A[1][0]= 4;
		A[1][1]= 5;
		A[1][2]= 6;
		A[2][0]= 7;
		A[2][1]= 8;
		A[2][2]= 9;




	}

}