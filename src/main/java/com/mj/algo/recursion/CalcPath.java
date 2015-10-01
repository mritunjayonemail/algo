package com.mj.algo.recursion;

import java.awt.Point;
import java.util.ArrayList;

/*
 * A robot sitting on the upper left corner of an X by Y grid. the robot can
 * only move in two directions: right and down. How many possible path are there 
 * for the robot to go from (0,0) to (X,Y)
 */
public class CalcPath {
	
	private static boolean getPath(int x, int y, ArrayList<Point> path){
		Point p = new Point(x,y);
		path.add(p);
		if(x==0&& y==0){
			return true;
		}
		
		boolean success = false;
		if(x>=1){
			success = getPath(x-1, y, path);
		}
		if(!success && y>=1){
			success = getPath(x, y-1, path);
		}
		if(success){
			path.add(p);
		}
		return success;
	}
	
	public static final void main(String[] args){
		ArrayList<Point> path = new ArrayList<Point>();
		getPath(10,10, path);
		
		for(Point p: path){
			System.out.print(p);
		}
		
	}

}
