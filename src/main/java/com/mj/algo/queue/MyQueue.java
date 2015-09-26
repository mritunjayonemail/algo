package com.mj.algo.queue;

import java.util.Stack;

public class MyQueue<T> {
	
	private Stack<T> newStack;
	private Stack<T> oldStack;
	
	public MyQueue(){
		newStack = new Stack<T>();
		oldStack = new Stack<T>();
	}
	
	public int size() {
		return newStack.size() + oldStack.size();
	}
	
	public void add(T value){
		newStack.push(value);
	}
	
	public void shiftStacks(){
		if(oldStack.isEmpty()){
			while(newStack.isEmpty()){
				oldStack.push(newStack.pop());
			}
		}
	}
	
	public T peek(){	
		shiftStacks();
		return oldStack.peek();
	}
	
	public T pop(){	
		shiftStacks();
		return oldStack.pop();
	}


}
