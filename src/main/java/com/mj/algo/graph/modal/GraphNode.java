package com.mj.algo.graph.modal;

public class GraphNode {
	
	private int data;
	
	private GraphNode next;
	
	private GraphAdjNode adjacentNode;

	public GraphNode(int data, GraphNode next, GraphAdjNode adjacentNode) {
		this.data = data;
		this.next = next;
		this.adjacentNode = adjacentNode;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public GraphNode getNext() {
		return next;
	}

	public void setNext(GraphNode next) {
		this.next = next;
	}

	public GraphAdjNode getAdjacentNode() {
		return adjacentNode;
	}

	public void setAdjacentNode(GraphAdjNode adjacentNode) {
		this.adjacentNode = adjacentNode;
	}

	
	
}
