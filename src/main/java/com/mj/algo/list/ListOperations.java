package com.mj.algo.list;

import com.mj.algo.list.modal.SingleLinkedList;

public class ListOperations {
	
	/* print the single linked list */
	private void printLinkedlist(SingleLinkedList root){
		while(root!=null){
			System.out.println(root.getValue());
			root= root.getNext();
		}
		
	}
	
	/* get length of linked list */
	private int getLength(SingleLinkedList root){
		SingleLinkedList ptr = root;
		if (ptr == null){
			return  0;
		}
		else {
			int size = 1;
			while (ptr!=null){
				size = size+1;
				ptr = ptr.getNext();		
			}
			return size;
		}
	}
	
	/* reverse a linked list */
	private SingleLinkedList reverseLinkedList(SingleLinkedList root){
		SingleLinkedList prev = null;
		SingleLinkedList current = root;
		SingleLinkedList next = null;
		
		while (current !=null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		return prev;
	}
	
	/* get middle node */
	private SingleLinkedList getMiddleNode(SingleLinkedList root){
		SingleLinkedList fast = root;
		SingleLinkedList slow = root;
		while(fast !=null && fast.getNext()!=null && fast.getNext().getNext()!= null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
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
	
	/*Given a singly linked list: 1->2->3->4->5 
	Change it to 1->5->2->4->3 using O(1) space*/
	private SingleLinkedList shuffleLinkedList(SingleLinkedList root){
		SingleLinkedList middle = getMiddleNode(root);
		/* get location of middle element */
		if (middle !=null) {
				
			//reverse the list after middle position
			SingleLinkedList secondList = reverseLinkedList(middle.getNext());
			
			// get the linked list till middle
			middle.setNext(null);
			SingleLinkedList firstList = root;
			
			// merge first and second list
			SingleLinkedList shuffledRoot = firstList;
			SingleLinkedList shuffledPtr = null;
			boolean fromFirst = true;
			SingleLinkedList firstPtr = firstList;
			SingleLinkedList secondPtr = secondList;
			while (firstPtr != null && secondPtr!=null){
				if (fromFirst){
					if (shuffledPtr == null){
						shuffledPtr = firstList;
						
						firstPtr = firstPtr.getNext();
					}
					else {
						shuffledPtr.setNext(firstPtr);
						shuffledPtr = shuffledPtr.getNext();
						firstPtr = firstPtr.getNext();
					}
				}
				else {
					shuffledPtr.setNext(secondPtr);
					shuffledPtr = shuffledPtr.getNext();
					secondPtr = secondPtr.getNext();
				}
				fromFirst = !fromFirst;
			}
			if (firstPtr == null){
				shuffledPtr.setNext(secondPtr);
			}
			else if(secondPtr == null){
				shuffledPtr.setNext(firstPtr);
			}
		    return shuffledRoot;
			
		}
		else {
			return root;
		}
		
		
	}
	
	
	public static void main(String args[]){
		/*SingleLinkedList lastNode = new SingleLinkedList("8", null);
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
		System.out.println("Start of the loop node is -> " + (circuarHeadNode!=null? circuarHeadNode.getValue(): "") );*/
		
		SingleLinkedList lastNode = new SingleLinkedList("5", null);
		SingleLinkedList singleLinkedList = new SingleLinkedList("4", lastNode);
		singleLinkedList = new SingleLinkedList("3", singleLinkedList);
		singleLinkedList = new SingleLinkedList("2", singleLinkedList);
		SingleLinkedList root = new SingleLinkedList("1", singleLinkedList);
		
		ListOperations listOperations = new ListOperations();
		//listOperations.printLinkedlist(root);
		SingleLinkedList shuffledroot = listOperations.shuffleLinkedList(root);
		System.out.println("Shuffled list is ->");
		listOperations.printLinkedlist(shuffledroot);
		
	}

}
