package com.mj.algo.graph.modal;


public class Edge<T> implements Comparable<Edge>{
	
	private int source;
	private int destiation;
	private int weight;
	
	public Edge(int source, int destiation) {
		super();
		this.source = source;
		this.destiation = destiation;
	}
	
	public Edge(int source, int destiation, int weight) {
		super();
		this.source = source;
		this.destiation = destiation;
		this.weight = weight;
	}
	
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getDestiation() {
		return destiation;
	}
	public void setDestiation(int destiation) {
		this.destiation = destiation;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if(weight<o.getWeight()){
			return 1;
		}
		return 0;
	}

}
