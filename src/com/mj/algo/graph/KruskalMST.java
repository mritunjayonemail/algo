package com.mj.algo.graph;

import java.util.Arrays;

import com.mj.algo.graph.modal.Edge;
import com.mj.algo.graph.modal.Graph;

/*
 * Kruskal algorithm for minimum spanning tree.
 */
public class KruskalMST {
	
	class Subset{
		int parent;
		int rank;
		public int getParent() {
			return parent;
		}
		public void setParent(int parent) {
			this.parent = parent;
		}
		public int getRank() {
			return rank;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
		
	}
	
	public int find(Subset[] subsets, int i){
		if(subsets[i].getParent() != i){
			subsets[i].parent = find(subsets, subsets[i].parent);
		}
		return subsets[i].parent;
	}
	
	public void union(Subset[] subsets, int x, int y){
		int xroot = find(subsets, x);
		int yroot = find(subsets, x);
		if(subsets[xroot].getRank()<subsets[yroot].getRank()){
			subsets[xroot].setParent(yroot);
		}
		if(subsets[xroot].getRank()>subsets[yroot].getRank()){
			subsets[yroot].setParent(xroot);
		}
		else {
			subsets[xroot].setParent(yroot);
			subsets[xroot].setRank(subsets[xroot].getRank()+1);
		}
	}
	
	public void findMST(Graph graph){
		int verticesSize = graph.getnVertices();
		//Edge[] graphEdges = graph.getEdges();
		Arrays.sort(graph.getEdges());
		Edge[] result = new Edge[graph.getnVertices()];
		Subset[] subsets = new Subset[graph.getnVertices()];
		for(int index=0; index <graph.getnVertices(); index++){
			Subset subset = new Subset(); 
			subset.setParent(index);
			subset.setRank(0);
			subsets[index]=subset;
		}
		int e = 0;
		int i = 0;
		while(e<(verticesSize-1)){
			Edge next = graph.getEdges()[i++];
			
			int x = find(subsets, next.getSource());
			int y = find(subsets, next.getDestiation());
			if(x!=y){
				result[e++]=next;
				union(subsets, x, y);
				
			}
		}
		
		System.out.println("Following are the edges printed using MST\n");
		for(int index=0; index<result.length; index++){
			Edge next =  result[index];
			if(next!=null)
			System.out.println("Src is - >" + next.getSource() + ", Destination is -> " + next.getDestiation() + " weight is -> " + next.getWeight());
		}
	}
	
	public static void main(String args[]){
		Graph graph = new Graph();
		graph.setnVertices(4);
		graph.setnEdges(5);
		Edge[] edges=  new Edge[graph.getnEdges()];
		edges[0]= new Edge<Edge>(0, 1, 10);
		edges[1]= new Edge<Edge>(0, 2, 6);
		edges[2]= new Edge<Edge>(0, 3, 5);
		edges[3]= new Edge<Edge>(1, 3, 15);
		edges[4]= new Edge<Edge>(2, 3, 4);
		graph.setEdges(edges);
		
		KruskalMST kruskalMST = new KruskalMST();
		kruskalMST.findMST(graph);
	}

}
