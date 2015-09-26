package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

/*
 * Lowest common ancestor of a tree whose two nodes are given
 */
public class LowestCommonAncestor {
	
	private static Tree findLCA(Tree ptr, String n1, String n2){
		
		if(ptr == null){
			return null;
		}
		
		if (ptr.getValue().equals(n1) || ptr.getValue().equals(n2)){
		    return ptr;
		}
		 
		Tree left = findLCA(ptr.getLeft(), n1, n2);
		Tree right = findLCA(ptr.getRight(), n1, n2);
		
		if(left !=null && right !=null){
			return ptr;
		}
		else {
			if(left == null && right !=null){
				return findLCA(ptr.getRight(), n1, n2);
			}
			else if(right == null && left !=null){
				return findLCA(ptr.getLeft(), n1, n2);
			}
			else {
				return null;
			}
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
		
		Tree lcaNode = findLCA(root, "D", "F");
		System.out.println("LCA(D,F) is ->" + lcaNode!=null?lcaNode.getValue():"No LCA");
		
	}

}
