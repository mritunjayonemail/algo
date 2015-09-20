package com.mj.algo.tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.mj.algo.tree.modal.Tree;

/*
 * Tree traversal algorithm
 */
public class TreeTraversal {

	private Map<Integer, String> valuesMap = new HashMap<Integer, String>();
	
	private void constructLevelOrder(Tree root, int level){
		//print values
		if(valuesMap.containsKey(level)){
			String value = valuesMap.get(level);
			value = value + root.getValue();
			valuesMap.put(level, value);
		}
		else{
			String value = root.getValue();
			valuesMap.put(level, value);
		}
	
		if(root.getLeft()!=null){
			constructLevelOrder(root.getLeft(), level+1);
		}
		if(root.getRight()!=null){
			constructLevelOrder(root.getRight(), level+1);
		}
	}
	

	private void printValueMap() {
	    Iterator it = valuesMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
	        System.out.println( pairs.getValue());
	        it.remove(); 
	    }
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
	
	private void postOrder(Tree root){	
		if(root.getLeft()!=null){
			postOrder(root.getLeft());
		}
		if(root.getRight()!=null){
			postOrder(root.getRight());
		}
		if(root!=null){
			System.out.println(root.getValue());
		}
	}
	
	private void inOrder(Tree root){	
		if(root.getLeft()!=null){
			inOrder(root.getLeft());
		}
		if(root!=null){
			System.out.println(root.getValue());
		}
		if(root.getRight()!=null){
			inOrder(root.getRight());
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
		TreeTraversal treeTraversal = new TreeTraversal();
		//level order
		treeTraversal.constructLevelOrder(root,1);
		//treeTraversal.printValueMap();
		//pre order
		//treeTraversal.preOrder(root);
		
		//post order
		//treeTraversal.postOrder(root);
		
		//in order
		//treeTraversal.inOrder(root);
		
	}

}
