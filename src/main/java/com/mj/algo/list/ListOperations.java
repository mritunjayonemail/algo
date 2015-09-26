package com.mj.algo.list;

import com.mj.algo.list.modal.SingleLinkedList;

public class ListOperations {
	
	private void printLinkedlist(SingleLinkedList root){
		while(root!=null){
			System.out.println(root.getValue());
			root= root.getNext();
		}
		
	}
	
	/*
	 * Method to find kth element from last in linked list.
	 */
	private int nthToLast(SingleLinkedList root, int k){
		if(root == null){
			return 0;
		}
		
		int i = nthToLast(root.getNext(), k) +1;
		if(i==k){
			System.out.println("k the lement is -> " + root.getValue());
		}
		return i;
	}
	
	/*
	 * Given a circular linked list, implement an algorithm which returns 
	 * the node at the beginning of the loop
	 */
	private SingleLinkedList getNodeAtBeginningOfCircularList(SingleLinkedList root){
		SingleLinkedList slow = root;
		SingleLinkedList fast = root;
		
	    while(fast !=null && fast.getNext()!=null){
	    	slow = slow.getNext();
	    	fast = fast.getNext().getNext();
	    	if(slow == fast){
	    		break;
	    	}
	    }
	    
	    if(fast==null || fast.getNext()==null){
	    	return null;//no loop
	    }
	
	    
	    slow = root;
	    
	    while(slow!=fast){
	    	slow = slow.getNext();
	    	fast=fast.getNext();
	    }
		return fast;
		
	}
	
	public static void main(String args[]){
		SingleLinkedList lastNode = new SingleLinkedList("8", null);
		SingleLinkedList singleLinkedList = new SingleLinkedList("7", lastNode);
		singleLinkedList = new SingleLinkedList("6", singleLinkedList);
		singleLinkedList = new SingleLinkedList("5", singleLinkedList);
		SingleLinkedList circularPointer = new SingleLinkedList("4", singleLinkedList);
		singleLinkedList = new SingleLinkedList("3", circularPointer);
		singleLinkedList = new SingleLinkedList("2", singleLinkedList);
		SingleLinkedList root = new SingleLinkedList("1", singleLinkedList);
		ListOperations listOperations = new ListOperations();
		listOperations.printLinkedlist(root);
		listOperations.nthToLast(root, 5);
		lastNode.setNext(circularPointer);
		SingleLinkedList circuarHeadNode = listOperations.getNodeAtBeginningOfCircularList(root);
		System.out.println("Start of the loop node is -> " + (circuarHeadNode!=null? circuarHeadNode.getValue(): "") );
	}

}
