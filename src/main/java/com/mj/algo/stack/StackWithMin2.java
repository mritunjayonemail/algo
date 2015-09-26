package com.mj.algo.stack;

import java.util.Stack;

/*
 * Stack which in addition of push and pop, also has a function min 
 * which returns the minimum element.
 */
public class StackWithMin2 extends Stack<Integer>{
	
	private Stack<Integer> s2;
	
	public StackWithMin2(){
		s2 = new Stack<Integer>();
	}
	
	public void push(int value){
		if(value<=min()){
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop(){
		int value = super.pop();
		if(value ==min()){
			s2.pop();
		}
		return value;
	}
	
	private int min(){
		if(s2.isEmpty()){
			return Integer.MAX_VALUE;
		}
		else {
			return s2.peek();
		}
	}

}
