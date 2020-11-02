package com.mj.algo.leetcode;

import java.util.*;

/*
There are n cities numbered from 0 to n-1 and n-1 roads such that there is only one way to travel between two different cities (this network form a tree).
Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [a, b] represents a road from city a to b.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach the city 0 after reorder.



Example 1:



Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Constraints:

2 <= n <= 5 * 10^4
connections.length == n-1
connections[i].length == 2
0 <= connections[i][0], connections[i][1] <= n-1
connections[i][0] != connections[i][1]

 */
public class RoutesReorder {

    public int minReorder(int n, int[][] connections) {
        int change=0;
        Set<String> pathsOrder=new HashSet<>();
        for(int[] p:connections){
            int a=p[0];
            int b=p[1];
            pathsOrder.add(a +"#"+ b);
        }

        List<Integer>[] graph=new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new ArrayList<>();
        }

        buildGraph(graph,connections);

        change = dfs(n, graph, pathsOrder);

        return connections.length-change;
    }

    private void buildGraph(List<Integer>[] graph,int[][] connections) {
        for(int[] connection:connections){
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
    }

    private int dfs(final int n , List<Integer>[] graph, Set<String>  pathsOrder){
        int change = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(0);
        while(! queue.isEmpty()){
            int item = queue.poll();

            if(!visited[item]){
                visited[item]=true;
                List<Integer> childs = graph[item];
                for (int child : childs){
                    if(!visited[child]){
                        String str= item +"#"+ child;
                        if(!pathsOrder.contains(str))
                            change++;
                        queue.add(child);
                    }
                }

            }
        }
        return change;

    }

    public static void main(String argsp[]){
        int n = 6;
        int[][] connections = new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}};
        RoutesReorder routesReorder = new RoutesReorder();
        int change = routesReorder.minReorder(6, connections);
        System.out.println("Changes required is ->" + change);


    }
}
