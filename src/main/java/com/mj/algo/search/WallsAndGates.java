package com.mj.algo.search;

/*
You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.



Example 1:


Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
Example 2:

Input: rooms = [[-1]]
Output: [[-1]]
Example 3:

Input: rooms = [[2147483647]]
Output: [[2147483647]]
Example 4:

Input: rooms = [[0]]
Output: [[0]]

Constraints:

m == rooms.length
n == rooms[i].length
1 <= m, n <= 250
rooms[i][j] is -1, 0, or 231 - 1.

 */
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j]==0){
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int distance){
        if(i<0 || j<0 || i>=rooms.length || j>=rooms[i].length || rooms[i][j]<distance)
            return;
        rooms[i][j] = distance;
        dfs(rooms, i, j+1, distance+1);
        dfs(rooms, i, j-1, distance+1);
        dfs(rooms, i-1, j, distance+1);
        dfs(rooms, i+1, j, distance+1);
    }

    public static void main(String args[]){
        int[][] rooms = new int[][]{{3,-1,0,1},{2,2,1,-1},{1,-1,2,-1},{0,-1,3,4}};
        WallsAndGates wg = new WallsAndGates();
        wg.wallsAndGates(rooms);
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i=0;i<m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rooms[i][j]);
            }
            System.out.println();
        }
    }
}
