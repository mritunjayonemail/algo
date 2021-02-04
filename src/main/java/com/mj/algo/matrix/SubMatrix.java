package com.mj.algo.matrix;

/*
Input: mat = [[1,0,1],
              [1,1,0],
              [1,1,0]]
Output: 13
Explanation:
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2.
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
Example 2:

Input: mat = [[0,1,1,0],
              [0,1,1,1],
              [1,1,1,0]]
Output: 24
Explanation:
There are 8 rectangles of side 1x1.
There are 5 rectangles of side 1x2.
There are 2 rectangles of side 1x3.
There are 4 rectangles of side 2x1.
There are 2 rectangles of side 2x2.
There are 2 rectangles of side 3x1.
There is 1 rectangle of side 3x2.
Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
 */
public class SubMatrix {


    public int numSubmat(int[][] mat) {

        int n =  mat.length;
        int m =  mat[0].length;
        int[][] arr = new int[m][n];

        for(int i=0; i<n; i++){
            int c = 0;
            for(int j=m-1; j>=0; j--){
                if(mat[i][j]==1){
                    c++;
                }
                else{
                    c=0;
                }
                arr[i][j]=c;
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int x = Integer.MAX_VALUE;
                for(int k=i; k<n; k++){
                    x = Math.min(x, arr[k][j]);
                    ans = ans+x;
                }
            }

        }
        return ans;
    }

    public static void main(String args[]){
        SubMatrix smatrix = new SubMatrix();
        int[][] mat = {{1,0,1},{1,1,0},{1,1,0}};
        smatrix.numSubmat(mat);

    }
}
