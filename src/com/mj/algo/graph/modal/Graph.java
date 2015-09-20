package com.mj.algo.graph.modal;


public class Graph {
	
	private int nVertices;
	private int nEdges;
	
	private Edge[] edges;

	public int getnVertices() {
		return nVertices;
	}

	public void setnVertices(int nVertices) {
		this.nVertices = nVertices;
	}

	public int getnEdges() {
		return nEdges;
	}

	public void setnEdges(int nEdges) {
		this.nEdges = nEdges;
	}

	public Edge[] getEdges() {
		return edges;
	}

	public void setEdges(Edge[] edges) {
		this.edges = edges;
	}

	
}
