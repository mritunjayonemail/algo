package com.mj.algo.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a snake and ladder board, find the minimum number of dice throws required to reach the destination or last cell from source or 1st cell. Basically, the player has total control over outcome of dice throw and wants to find out minimum number of throws required to reach last cell.

If the player reaches a cell which is base of a ladder, the player has to climb up that ladder and if reaches a cell is mouth of the snake, has to go down to the tail of snake without a dice throw.
 */

public class SnakeAndLadder {

    static class QueueEntry{
        int v;
        int dist;
    }

    // This function returns minimum number of dice
    // throws required to Reach last cell from 0'th cell
    // in a snake and ladder game. move[] is an array of
    // size N where N is no. of cells on board If there
    // is no snake or ladder from cell i, then move[i]
    // is -1 Otherwise move[i] contains cell to which
    // snake or ladder at i takes to.
    public static int getMinDiceThrows(int move[], int n){

        int visited[] = new int[n];

        QueueEntry qe = new QueueEntry();
        qe.v = 0; //vertex no
        qe.dist = 0; //distance of this vertex from source

        Queue<QueueEntry> q = new LinkedList<QueueEntry>();

        // Mark the node 0 as visited and enqueue it.
        visited[0] = 1;
        q.offer(qe);

        while(!q.isEmpty()){
            qe =q.remove();
            int v= qe.v;

            // If front vertex is the destination
            // vertex, we are done
            if (v == n - 1)
                break;

            for(int j=v+1; j<=v+6 & j<n; j++){

                // If this cell is already visited, then ignore
                if (visited[j] == 0)
                {
                    // Otherwise calculate its distance and
                    // mark it as visited
                    QueueEntry a = new QueueEntry();
                    a.dist = (qe.dist + 1);
                    visited[j] = 1;

                    // Check if there a snake or ladder at 'j'
                    // then tail of snake or top of ladder
                    // become the adjacent of 'i'
                    if (move[j] != -1)
                        a.v = move[j];
                    else
                        a.v = j;
                    q.add(a);
                }

            }
        }

        return qe.dist;
    }

    public static void main(String args[]){
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                getMinDiceThrows(moves, N));
    }
}
