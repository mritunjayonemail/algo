package com.mj.algo.dynamic;

/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.


Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]


Note:

The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
 */
public class NearestZeroDistance {

    static int min(int x, int y, int z)
    {
        int[] arr = new int[]{x , y, z };
        int min = arr[0];
        for(int item: arr){
            if(item<=min){
                min = item;
            }
        }
        return min;
    }

    private int minDistance(int[][] matrix, int i , int j, boolean flag){

        if(flag){
            if(i<0 || j <0){
                return 0;
            }
        }
        else {
            if(i>=matrix.length || j>=matrix[0].length){
                return 0;
            }
        }
        if(matrix[i][j]==0){
            return 0;
        }
        else {
            if (flag) {
                 int x = minDistance(matrix, i - 1, j, flag);
                 int y = minDistance(matrix, i - 1, j - 1, flag);
                 int z = minDistance(matrix, i, j - 1, flag);
                 if(!(x==0 && y==0 && z==0)) {
                     x = x == 0 ? Integer.MAX_VALUE : x;
                     y = y == 0 ? Integer.MAX_VALUE : y;
                     z = z == 0 ? Integer.MAX_VALUE : z;
                 }
                 return 1 + min(x,y,z);
            } else {
                int x = minDistance(matrix, i + 1, j, flag);
                int y = minDistance(matrix, i + 1, j + 1, flag);
                int z = minDistance(matrix, i, j + 1, flag);
                if(!(x==0 && y==0 && z==0)) {
                    x = x == 0 ? Integer.MAX_VALUE : x;
                    y = y == 0 ? Integer.MAX_VALUE : y;
                    z = z == 0 ? Integer.MAX_VALUE : z;
                }
                return 1 + min(x,y,z);
            }
        }

    }
    private int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] retMat = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==1){
                    int x = minDistance(matrix, i, j, true);
                    int y = minDistance(matrix, i, j, false);
                    retMat[i][j] = Math.min(x, y);
                }
                else {
                    retMat[i][j]=0;
                }
            }
        }

        return retMat;
    }

    public static void main(String args[]){
        int[][] matrix = new int[][]{{0,0,0}, {0,1,0}, {1,1,1},};
        NearestZeroDistance nd  = new NearestZeroDistance();
        int[][] retMat = nd.updateMatrix(matrix);

        for(int i=0; i<retMat.length; i++){
            for(int j=0; j<retMat[0].length; j++) {
                System.out.print(retMat[i][j]);
            }
            System.out.println();
        }
    }
}
