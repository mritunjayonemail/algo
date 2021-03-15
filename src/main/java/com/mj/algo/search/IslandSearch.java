package com.mj.algo.search;

/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

 */
public class IslandSearch {

    private void mark(char[][] grid, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] !='1')
            return;
        grid[i][j] = '2';
        mark(grid, i-1, j, m, n);
        mark(grid, i, j-1, m, n);
        mark(grid, i, j+1, m, n);
        mark(grid, i+1, j, m, n);

    }
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int noIslands = 0;
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]== '1'){
                    noIslands++;
                    mark(grid, i, j, m, n);
                }
            }
        }
        return noIslands;

    }

    public static void main(String args[]){

    }
}
