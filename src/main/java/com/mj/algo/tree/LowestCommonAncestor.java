package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

/*
 * Lowest common ancestor of a tree whose two nodes are given
 */
public class LowestCommonAncestor {
	
	private static Tree findLCA(Tree<String> ptr, String n1, String n2){
		
		if(ptr == null){
			return null;
		}
		
		if (ptr.getValue().equals(n1) || ptr.getValue().equals(n2)){
		    return ptr;
		}
		 
		Tree<String> left = findLCA(ptr.getLeft(), n1, n2);
		Tree<String> right = findLCA(ptr.getRight(), n1, n2);
		
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
		Tree<String> child11 = new Tree<String>("D", null, null);
		Tree<String> child22 = new Tree<String>("E", null, null);
		Tree<String> child33 = new Tree<String>("F", null, null);
		Tree<String> child44 = new Tree<String>("G", null, null);
		
		Tree<String> child1 =  new Tree<String>("B", child11, child22);
		Tree<String> child2 =  new Tree<String>("C", child33, child44);
		
		Tree<String> root = new Tree<String>("A", child1, child2);
		
		Tree<String> lcaNode = findLCA(root, "D", "F");
		System.out.println("LCA(D,F) is ->" + lcaNode!=null?lcaNode.getValue():"No LCA");
		
	}

}
