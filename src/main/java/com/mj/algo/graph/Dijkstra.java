package com.mj.algo.graph;

/*
 * Shortest path between pair of nodes, negative edges are allowed.
 */
public class Dijkstra {
	
	private static final int vSize = 9;
	
	// A utility function to find the vertex with minimum distance value, from
	// the set of vertices not yet included in shortest path tree
	private int minDistance(int[] dist, boolean[] sptSet){
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int index = 0; index<vSize; index++){
			if(min>dist[index] && !sptSet[index]){
				min=dist[index] ; 
				minIndex = index;
			}
		}
		return minIndex;
	}
	
    private void printSolution(int dist[], int n)
    {
	   System.out.println("Vertex   Distance from Source\n");
	   for (int index = 0; index <vSize; index++)
		   System.out.println(" " + index + "        " + dist[index]);
	}
	
    private void findPath(int[][] graph, int src){
		int[] dist = new int[vSize];
		boolean[] sptSet= new boolean[vSize];
		
		
		for(int index = 0; index<vSize; index++){
			dist[index] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		for(int index = 0; index<vSize; index++){
			int  u = minDistance(dist, sptSet);
			sptSet[u] =  true;
			
			//update distance
			for (int v = 0; v < vSize; v++){
				if(!sptSet[v] && graph[u][v] !=0 && dist[u] !=  Integer.MAX_VALUE &&
						dist[u] + graph[u][v]<dist[v]){
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		
		printSolution(dist, src);
		
	}
    
    public static void main(String args[]){
    	/* Let us create the example graph discussed above */
    	   int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
    	                      {4, 0, 8, 0, 0, 0, 0, 11, 0},
    	                      {0, 8, 0, 7, 0, 4, 0, 0, 2},
    	                      {0, 0, 7, 0, 9, 14, 0, 0, 0},
    	                      {0, 0, 0, 9, 0, 10, 0, 0, 0},
    	                      {0, 0, 4, 0, 10, 0, 2, 0, 0},
    	                      {0, 0, 0, 14, 0, 2, 0, 1, 6},
    	                      {8, 11, 0, 0, 0, 0, 1, 0, 7},
    	                      {0, 0, 2, 0, 0, 0, 6, 7, 0}
    	                     };
    	 
    	   Dijkstra Dijkstra = new Dijkstra();
    	   Dijkstra.findPath(graph, 0);
    }
	
	

}
