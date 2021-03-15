package com.mj.algo.recursion;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Note: There will be some test cases with a board or a word larger than constraints to test if your solution is using pruning.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]== word.charAt(0) && dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(char[][] board, String word, int i, int j, int count){
        if(count == word.length()) {
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j] != word.charAt(count)){
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, word, i+1, j, count+1) || dfs(board, word, i-1, j, count+1) ||
                dfs(board, word, i, j+1, count+1) || dfs(board, word, i, j-1, count+1);
        board[i][j] = tmp;
        return found;
    }

    public static void main(String args[]){
        WordSearch ws = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println("Word exists in board " + ws.exist(board, word));
    }
}
