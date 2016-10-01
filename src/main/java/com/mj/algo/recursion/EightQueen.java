package com.mj.algo.recursion;

import java.util.ArrayList;

public class EightQueen {
	
	static int  GRID_SIZE = 8;
	
	
	private void placeQueen(int row, Integer[] columns, ArrayList<Integer[]> results){
		if(row== GRID_SIZE){
			results.add(columns.clone());
		}
		else {
			for(int col=0; col<GRID_SIZE; col++){
				if(isValid(columns, row, col)){
					columns[row]=col;
					placeQueen(row+1, columns, results);
				}
			}
		}
	}
	
	private boolean isValid(Integer[] columns, int row1, int column1){
		for(int row2=0; row2<row1; row2++){
			int column2=columns[row2];
			
			// Check if (row2, column2) invalidates (row1, column1) as a queen shot
			
			// check if rows have a queen in the same column
			if(column1 == column2){
				return false;
			}
			
			int columnDistance =  Math.abs(column2 - column1);
			
			// row1>row2, so no need for abs
			int rowDistance = row1 - row2;
			
			if(columnDistance == rowDistance){
				return false;
			}
			
		}
		return true;
	}
	
	
	public static void main(String args[]){
		EightQueen eightQueen = new EightQueen();
		Integer[] columns = new Integer[GRID_SIZE];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		eightQueen.placeQueen(0, columns, results);
		for(int index=0; index<results.size(); index++){
			Integer[] values = results.get(index);
			for(int i=0; i<values.length; i++){
				System.out.println("" + i  + " " + values[i]);
			}
			System.out.println("\n New Value");
		}
		
	}

}
