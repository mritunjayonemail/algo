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
	
	private void constructLevelOrder(Tree<String> root, int level){
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
	
	private void preOrder(Tree<String> root){
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
	
	private void postOrder(Tree<String> root){
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
	
	private void inOrder(Tree<String> root){
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
	
	/*
	 * Find the algorithm to find the 'next' node(i.e. in order successor) of a given node
	 * in a binary search tree.
	 */
	/*public Tree inOrderSuccessor(Tree node){
		if(node == null){
			return null;
		}
		if(node.getRight()!=null){
			return leftMostChild(node);
		}
		else {
			Tree q = node;
			Tree x = q.getParent();
			while(x!=null&& x.getLeft()!=q){
				q=x;
				x=x.getParent();
			}
		}
		return x;
		
	}*/
	
	/*
	 * Method returns leftmost child of a node
	 */
	public Tree leftMostChild(Tree node){
		if(node == null){
			return null;
		}
		while(node.getLeft()!=null){
			node = node.getLeft();
		}
		return node;
	}

	public int getHeight(Tree node){
		if(node == null){
			return 0;
		}
		int leftHeight = 0;
		int rightHeight = 0;
		if (node.getLeft() !=null)
			leftHeight = getHeight(node.getLeft());
		if (node.getRight() !=null)
			rightHeight = getHeight(node.getLeft());
		return 1 + Math.max(leftHeight, rightHeight);

	}

	int getWidth(Tree node, int level)
	{
		if (node == null)
			return 0;

		if (level == 1)
			return 1;
		else if (level > 1)
			return getWidth(node.getLeft(), level - 1)
					+ getWidth(node.getRight(), level - 1);
		return 0;
	}

	int getMaxWidth(Tree node)
	{
		int maxWidth = 0;
		int width;
		int h = getHeight(node);
		int i;

        /* Get width of each level and compare
           the width with maximum width so far */
		for (i = 1; i <= h; i++) {
			width = getWidth(node, i);
			if (width > maxWidth)
				maxWidth = width;
		}

		return maxWidth;
	}


	public static void main(String args[]){
		Tree<String> child11 = new Tree<String>("D", null, null);
		Tree<String> child22 = new Tree<String>("E", null, null);
		Tree<String> child33 = new Tree<String>("F", null, null);
		Tree<String> child44 = new Tree<String>("G", null, null);
		
		Tree<String> child1 =  new Tree<String>("B", child11, child22);
		Tree<String> child2 =  new Tree("C", child33, child44);
		
		Tree<String> root = new Tree<String>("A", child1, child2);
		TreeTraversal treeTraversal = new TreeTraversal();
		//level order
		// treeTraversal.constructLevelOrder(root,1);
		//treeTraversal.printValueMap();
		//pre order
		//treeTraversal.preOrder(root);
		
		//post order
		//treeTraversal.postOrder(root);
		
		//in order
		//treeTraversal.inOrder(root);

		// height
		int height = treeTraversal.getHeight(root);
		System.out.println("Height of tree is " + height);

		int width = treeTraversal.getWidth(root, height);
		System.out.println("Height of tree is " + width);
		
	}

}
