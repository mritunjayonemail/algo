package com.mj.algo.graph;

import com.mj.algo.graph.modal.Graph;
import com.mj.algo.graph.modal.GraphAdjNode;
import com.mj.algo.graph.modal.GraphNode;

import java.util.*;

/*
Topological sorting of graph
Let S be a directed gaph without cycles(or a partially ordered set). A topological
sort T of S is a linear ordering of the nodes of S which preserves the original partial ordring of S.
That is, if u<v is S(i.e., if there is a path from u to v in S), then u comes before v in the linear ordering T.
 */
public class TopologicalSorting {

    private int getInDegree(GraphNode rootNode, GraphNode searchedNode){
        int indegree= 0;
        GraphNode ptr = rootNode;
        while(ptr !=null){
            GraphAdjNode adjNode = ptr.getAdjacentNode();
            while(adjNode !=null){
                if(adjNode.getGraphNode() == searchedNode){
                    indegree = indegree + 1;
                }
                adjNode = adjNode.getNext();
            }
            ptr= ptr.getNext();
        }

        return indegree;
    }


    public void topologicalSort(GraphNode root){

        if(root == null){
            return;
        }

        Queue<GraphNode> graphNodeQueue = new LinkedList<GraphNode>();

        // calculate indegree
        Map<GraphNode, Integer> indegreeMap = new HashMap<GraphNode, Integer>();

        GraphNode ptr = root;
        while(ptr!=null){
            int indegree =  getInDegree(root, ptr);
            indegreeMap.put(ptr, indegree);
            if(indegree==0){
                // put all the zero indegree node to queue
                graphNodeQueue.add(ptr);
            }
            ptr = ptr.getNext();
        }
        while(!graphNodeQueue.isEmpty()){
            ptr = graphNodeQueue.poll();
            System.out.println(ptr.getData());
            // For each neighbour of ptr, decrease the indegree by 1 and if indegree is zeo, add it to queue.
            GraphAdjNode graphAdjNode = ptr.getAdjacentNode();
            while(graphAdjNode!=null){
                GraphNode adjGraphNode = graphAdjNode.getGraphNode();
                int indegree = indegreeMap.get(adjGraphNode);
                indegree = indegree - 1;
                indegreeMap.put(adjGraphNode, indegree);
                if(indegree == 0){
                    graphNodeQueue.add(adjGraphNode);
                }
                graphAdjNode = graphAdjNode.getNext();
            }

        }

    }

    public static void main(String args[]){

        GraphNode graphNode7 = new GraphNode(7,null, null);
        GraphNode graphNode6 = new GraphNode(6,graphNode7, null);
        GraphNode graphNode5 = new GraphNode(5,graphNode6, null);
        GraphNode graphNode4 = new GraphNode(4, graphNode5, null);
        GraphNode graphNode3 = new GraphNode(3, graphNode4, null );
        GraphNode graphNode2 = new GraphNode(2, graphNode3, null );
        GraphNode graphNode1 = new GraphNode(1, graphNode2, null );

        GraphAdjNode graphAdjacentNode1 = new GraphAdjNode();
        graphAdjacentNode1.setGraphNode(graphNode3);
        graphNode1.setAdjacentNode(graphAdjacentNode1);

        GraphAdjNode graphAdjacentNode2 = new GraphAdjNode();
        graphAdjacentNode2.setGraphNode(graphNode4);
        GraphAdjNode graphAdjacentNode2_6 = new GraphAdjNode();
        graphAdjacentNode2_6.setGraphNode(graphNode6);
        graphAdjacentNode2.setNext(graphAdjacentNode2_6);
        graphNode2.setAdjacentNode(graphAdjacentNode2);

        GraphAdjNode graphAdjacentNode4 = new GraphAdjNode();
        graphAdjacentNode4.setGraphNode(graphNode3);
        graphNode4.setAdjacentNode(graphAdjacentNode4);

        GraphAdjNode graphAdjacentNode5 = new GraphAdjNode();
        graphAdjacentNode5.setGraphNode(graphNode3);
        graphNode5.setAdjacentNode(graphAdjacentNode5);


        GraphAdjNode graphAdjacentNode7 = new GraphAdjNode();
        graphAdjacentNode7.setGraphNode(graphNode1);
        GraphAdjNode graphAdjacentNode7_6 = new GraphAdjNode();
        graphAdjacentNode7_6.setGraphNode(graphNode6);
        graphAdjacentNode7.setNext(graphAdjacentNode7_6);
        graphNode7.setAdjacentNode(graphAdjacentNode7);


        TopologicalSorting topologicalSorting = new TopologicalSorting();
        topologicalSorting.topologicalSort(graphNode1);

    }


}
