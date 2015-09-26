










package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;


public class CreateMinimalBST {
	
	public Tree createMinimalBST(int arr[], int start, int end){
		if(end<start){
			return null;
		}
		int mid= (start+end)/2;
		Tree n = new Tree(new Integer(arr[mid]).toString(), null, null);
		Tree left = createMinimalBST(arr, start, mid-1);
		Tree right = createMinimalBST(arr, mid+1, end);
		n.setLeft(left);
		n.setRight(right);
		return n;
	}
	
	private void preOrder(Tree root){
		if(root!=null){
			System.out.println(root.getValue());
		}
		if(root.getLeft()!=null){
			preOrder(root.getLeft());
		}
		if(root.getRight()!=null){
			preOrder(root.getRight());
		}
	}
	
	
	public static void main(String args[]){
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		CreateMinimalBST createMinimalBST = new CreateMinimalBST();
		Tree root = createMinimalBST.createMinimalBST(arr, 0, 7);
		createMinimalBST.preOrder(root);
	}

}
	
	
	
	



