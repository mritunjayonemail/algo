package com.mj.algo.google;

import com.mj.algo.graph.modal.GraphAdjNode;
import com.mj.algo.graph.modal.GraphNode;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphTraversal {

    public void bfs(GraphNode root){

        LinkedHashMap<GraphNode, Boolean> visited = new LinkedHashMap<>();

        Queue<GraphNode> queue = new PriorityQueue<GraphNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            GraphNode gn = queue.peek();
            System.out.println(gn.getData());
            visited.put(gn, true);
            GraphAdjNode adjNode = gn.getAdjacentNode();
            if(adjNode!=null){
                if (!visited.get(adjNode.getGraphNode())){
                    queue.add(adjNode.getGraphNode());
                }
                while(adjNode.getNext()!=null){
                    if (!visited.get(adjNode.getGraphNode())){
                        queue.add(adjNode.getNext());
                    }
                }
            }
        }
    }
}
