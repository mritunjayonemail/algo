package com.mj.algo.tree.modal;

public class Tree<T> {
	
	private T value;
	private Tree left;
	private Tree right;
	
	public Tree(T value, Tree left, Tree right){
		this.value = value;
		this.left = left;
		this.right= right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Tree getLeft() {
		return left;
	}

	public void setLeft(Tree left) {
		this.left = left;
	}

	public Tree getRight() {
		return right;
	}

	public void setRight(Tree right) {
		this.right = right;
	}
}
