package com.mj.algo.list;

import com.mj.algo.list.modal.SingleLinkedList;

public class ListOperations {
	
	private void printLinkedlist(SingleLinkedList root){
		while(root!=null){
			System.out.println(root.getValue());
			root= root.getNext();
		}
		
	}
	
	public static void main(String args[]){
		SingleLinkedList singleLinkedList = new SingleLinkedList("ba", null);
		singleLinkedList = new SingleLinkedList("c", singleLinkedList);
		singleLinkedList = new SingleLinkedList("ed", singleLinkedList);
		singleLinkedList = new SingleLinkedList("f", singleLinkedList);
		singleLinkedList = new SingleLinkedList("g", singleLinkedList);
		singleLinkedList = new SingleLinkedList("ef", singleLinkedList);
		singleLinkedList = new SingleLinkedList("bcd", singleLinkedList);
		SingleLinkedList root = new SingleLinkedList("a", singleLinkedList);
		ListOperations listOperations = new ListOperations();
		listOperations.printLinkedlist(root);
	}

}
