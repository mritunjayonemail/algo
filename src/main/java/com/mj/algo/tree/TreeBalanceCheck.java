package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

/*
 * Class to check a binary tree is balanced or not. A balanced tree is defined to be 
 * a tree such that the heights of the two subtree of any node never differ by more than one.
 */
public class TreeBalanceCheck {
	
	public int getHeight(Tree root){
		if(root == null){
			return 0;
		}
		int leftHeight = getHeight(root.getLeft()) + 1;
		int rightHeight = getHeight(root.getRight()) + 1;
		
		return leftHeight<rightHeight?rightHeight:leftHeight;
	}
	
	public boolean isBalanced(Tree root){
		if(root == null){
			return true;
		}
		int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight());
		if(Math.abs(heightDiff)>1){
			return false;
		}
		else {
			return isBalanced(root.getLeft()) && isBalanced(root.getRight());
		}
	}
	
	public static void main(String args[]){
		Tree child11 = new Tree("D", null, null);
		Tree child22 = new Tree("E", null, null);
		Tree child33 = new Tree("F", null, null);
		Tree child44 = new Tree("G", null, null);
		
		Tree child1 =  new Tree("B", child11, child22);
		Tree child2 =  new Tree("C", child33, child44);
		
		Tree root = new Tree("A", child1, child2);
		TreeBalanceCheck treeBalanceCheck = new TreeBalanceCheck();
		//level order
		System.out.print("Is Tree balanced " + treeBalanceCheck.isBalanced(root));
		
	}

}