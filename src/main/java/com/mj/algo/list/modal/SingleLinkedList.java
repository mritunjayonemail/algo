package com.mj.algo.list.modal;

public class SingleLinkedList {
	
	private String value;
	private SingleLinkedList next;
	
	public SingleLinkedList(String value, SingleLinkedList next){
		this.value = value;
		this.next = next;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public SingleLinkedList getNext() {
		return next;
	}

	public void setNext(SingleLinkedList next) {
		this.next = next;
	}

}
