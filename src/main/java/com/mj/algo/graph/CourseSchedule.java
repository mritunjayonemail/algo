package com.mj.algo.graph;

import java.util.ArrayList;
import java.util.List;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {

    private List<Integer>[] graph;
    private boolean[] visited;
    private boolean[] marked;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph=new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i]=new ArrayList<>();
        }
        buildGraph(graph, prerequisites);
        visited = new boolean[numCourses];
        marked = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if(!visited[i]){
                if(isCyclic(i)){
                    return false;
                }
            }
        }
        return true;

    }

    private void buildGraph(List<Integer>[] graph, int[][] prerequisites){
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
    }

    private boolean isCyclic(int source){
        visited[source] = true;
        for(int j: graph[source]){
            if(!visited[j]){
                if(isCyclic(j)){
                    return true;
                }
            }
            else if(!marked[j]){
                return true;
            }
        }
        marked[source] = true;
        return false;
    }

    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        CourseSchedule cs = new CourseSchedule();
        System.out.println("CourseSchedule finish " + cs.canFinish(2, prerequisites));
    }

}
