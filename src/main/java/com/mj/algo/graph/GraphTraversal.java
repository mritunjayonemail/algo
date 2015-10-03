package com.mj.algo.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.mj.algo.graph.modal.GraphAdjNode;
import com.mj.algo.graph.modal.GraphNode;

/*
 * DFS and BFS graph traversal
 */
public class GraphTraversal {
	
	Stack<GraphNode> stack = new Stack<GraphNode>();
	Queue<GraphNode> queue = new PriorityQueue<GraphNode>();
	
	/*
	 * BFS
	 */
	private void bfs(GraphNode root){
		
	  int n = getGraphSize(root);
	  Map<GraphNode, Boolean> visited = new HashMap<GraphNode, Boolean>();
	  
       while(root!=null){
    	   queue.add(root);
       }
      
       while(!queue.isEmpty()){
    	   GraphNode returnNode =  queue.poll();
    	   System.out.println(returnNode.getData());
    	   visited.put(returnNode, true);
    	   GraphAdjNode adjNode =root.getAdjacentNode();
    	   if(adjNode!=null){
    		   if(!visited.get(adjNode.getGraphNode())){
    			   queue.add(adjNode.getGraphNode());
    		   }
	    	   while(adjNode.getNext()!=null){
	    		   if(!visited.get(adjNode.getGraphNode())){
	    			   queue.add(adjNode.getNext());
	    		   }
	    	   }
    	   }
       }
       
	}
	
	/*
	 * DFS
	 */
	private void dfs(GraphNode root){
		
		  int n = getGraphSize(root);
		  Map<GraphNode, Boolean> visited = new HashMap<GraphNode, Boolean>();
		  
	       while(root!=null){
	    	   stack.push(root);
	       }
	      
	       while(!queue.isEmpty()){
	    	   GraphNode returnNode =  stack.pop();
	    	   System.out.println(returnNode.getData());
	    	   visited.put(returnNode, true);
	    	   GraphAdjNode adjNode =root.getAdjacentNode();
	    	   if(adjNode!=null){
	    		   if(!visited.get(adjNode.getGraphNode())){
	    			   stack.push(adjNode.getGraphNode());
	    		   }
		    	   while(adjNode.getNext()!=null){
		    		   if(!visited.get(adjNode.getGraphNode())){
		    			   stack.push(adjNode.getNext());
		    		   }
		    	   }
	    	   }
	       }
	       
		}
	
	private int getGraphSize(GraphNode node){
		if(node==null){
			return 0;
		}
		int size = 1;
		while(node.getNext()!=null){
			size=size+1;
			node = node.getNext();
		}
		return size;
	}

}
