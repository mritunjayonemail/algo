package com.mj.algo.google;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
You have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes the existence of a bidirectional path from garden xi to garden yi. In each garden, you want to plant one of 4 types of flowers.

There is no garden that has more than three paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.



Example 1:

Input: n = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]
Example 2:

Input: n = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]
Example 3:

Input: n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]
 */
public class FlowerPlanting {

    static boolean[] visited;
    public int[] gardenNoAdj(int n, int[][] paths) {
        visited = new boolean[n];
        List<Integer>[] graph=new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new ArrayList<>();
        }

        ArrayList<ArrayList> connectedCompnents = new ArrayList();
        buildGraph(graph,paths);
        ArrayList visNodes = dfs(n, graph, 0);
        connectedCompnents.add(visNodes);
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visNodes = dfs(n, graph, i);
                connectedCompnents.add(visNodes);
            }
        }

        int[] flowers = new int[n];
        int index = 0;
        for(int i = 0; i < connectedCompnents.size(); i++) {
            for(int j=1; j<= connectedCompnents.get(i).size(); j++){
                flowers[index] = j;
                index++;
            }
        }


        return flowers;
    }

    private void buildGraph(List<Integer>[] graph,int[][] paths) {
        for(int[] path:paths){
            graph[path[0]-1].add(path[1]-1);
            //graph[path[1]-1].add(path[0]-1);
        }
    }

    private ArrayList dfs(final int n, List<Integer>[] graph, int itemIndex) {
        ArrayList visNodes = new ArrayList();
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(itemIndex);
        while (!queue.isEmpty()) {
            int item = queue.poll();
            if (!visited[item]) {
                visNodes.add(item);
                visited[item] = true;
                List<Integer> childs = graph[item];
                for (int child : childs) {
                    if (!visited[child]) {
                        queue.add(child);
                    }
                }
            }
        }
        return visNodes;
    }

    public static void main(String args[]){
        FlowerPlanting flowerPlanting = new FlowerPlanting();
        int [] [] paths= new int[][] {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
        int[] flowers = flowerPlanting.gardenNoAdj(4, paths);
        for (int element: flowers) {
            System.out.println(element);
        }
    }
}
