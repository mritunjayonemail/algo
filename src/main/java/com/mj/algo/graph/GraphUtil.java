package com.mj.algo.graph;

import com.mj.algo.graph.modal.Graph;

public class GraphUtil {
	
	
 // A utility function to find the subset of an element i
 private static int find(int parent[], int i)
 {
	    if (parent[i] == -1)
	        return i;
	    return find(parent, parent[i]);
 }
 
 //A utility function to do union of two subsets 
 private static void Union(int parent[], int x, int y)
 {
   int xset = find(parent, x);
   int yset = find(parent, y);
   parent[xset] = yset;
 }
	
 public static boolean isCycle(Graph graph){
	 
	 int[] parent = new int[graph.getnVertices()];
	 
	 for(int i =0; i<graph.getnVertices() ; i++){
		 parent[i] = -1;
	 }
	 for(int i = 0; i < graph.getnVertices(); ++i){
		 int x = find(parent, graph.getEdges()[i].getSource());
		 int y = find(parent, graph.getEdges()[i].getDestiation());

		 if (x == y){
			 return true;
		 }
		 Union(parent, x, y);
	 }
	 return false;
 }

}
