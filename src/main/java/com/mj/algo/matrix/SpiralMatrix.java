package com.mj.algo.matrix;

/* print elements of an matrix in spiral form*/
public class SpiralMatrix {
	
	private void print(int[][] matrix){
		for (int i = 0; i<matrix.length; i++ ){
			for(int j=0; j<matrix[i].length; j++){
				System.out.println( matrix[i][j]);
			}
		}
	}
	
	
	private void printSpiral(int[][] matrix){
		boolean oddLine = true;
		for (int i = 0; i<matrix.length; i++ ){
			if(oddLine){
				for(int j=0; j<matrix[i].length; j++){
					System.out.println( matrix[i][j]);
				}
			}
			else {
				for(int j=matrix[i].length-1; j>=0; j--){
					System.out.println( matrix[i][j]);
				}
			}
			oddLine = !oddLine;
		}
		
	}
	
	public static void main(String args[]){
		int[][] matrix = new int[][]{{1, 2,3},{4, 5, 6},{7,8,9}};
		SpiralMatrix sprialMatrix = new SpiralMatrix();
		sprialMatrix.printSpiral(matrix);
	}
}
