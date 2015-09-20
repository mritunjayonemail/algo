package com.mj.algo.tree.modal;

public class Tree {
	
	private String value;
	private Tree left;
	private Tree right;
	
	public Tree(String value, Tree left, Tree right){
		this.value = value;
		this.left = left;
		this.right= right;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
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
