package com.mj.design;

import java.util.LinkedList;

/*
Design a Snake game that is played on a device with screen size height x width. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0, 0) with a length of 1 unit.

You are given an array food where food[i] = (ri, ci) is the row and column position of a piece of food that the snake can eat. When a snake eats a piece of food, its length and the game's score both increase by 1.

Each piece of food appears one by one on the screen, meaning the second piece of food will not appear until the snake eats the first piece of food.

When a piece of food appears on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

The game is over if the snake goes out of bounds (hits a wall) or if its head occupies a space that its body occupies after moving (i.e. a snake of length 4 cannot run into itself).

Implement the SnakeGame class:

SnakeGame(int width, int height, int[][] food) Initializes the object with a screen of size height x width and the positions of the food.
int move(String direction) Returns the score of the game after applying one direction move by the snake. If the game is over, return -1.


Example 1:


Input
["SnakeGame", "move", "move", "move", "move", "move", "move"]
[[3, 2, [[1, 2], [0, 1]]], ["R"], ["D"], ["R"], ["U"], ["L"], ["U"]]
Output
[null, 0, 0, 1, 1, 2, -1]

Explanation
SnakeGame snakeGame = new SnakeGame(3, 2, [[1, 2], [0, 1]]);
snakeGame.move("R"); // return 0
snakeGame.move("D"); // return 0
snakeGame.move("R"); // return 1, snake eats the first piece of food. The second piece of food appears
                     // at (0, 1).
snakeGame.move("U"); // return 1
snakeGame.move("L"); // return 2, snake eats the second food. No more food appears.
snakeGame.move("U"); // return -1, game over because snake collides with border


Constraints:

1 <= width, height <= 104
1 <= food.length <= 50
food[i].length == 2
0 <= ri < height
0 <= ci < width
direction.length == 1
direction is 'U', 'D', 'L', or 'R'.
At most 104 calls will be made to move.
 */
public class SnakeGame {

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private int width;
    private int height;
    private LinkedList<int[]> food;
    private LinkedList<int[]> body;
    private int score;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width-1;
        this.height= height-1;
        this.food=new LinkedList<int[]>();
        for(int[] f: food){
            this.food.add(f);
        }
        this.body = new LinkedList<int[]>();
        this.body.addFirst(new int[]{0,0});
        this.score = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] currentPos = this.body.getLast();
        int currentWidth = currentPos[0];
        int currentHeight = currentPos[1];

        if(direction.equals("U"))
            currentHeight--;
        else  if(direction.equals("L"))
            currentWidth--;
        else  if(direction.equals("R"))
            currentWidth++;
        else  if(direction.equals("D"))
            currentHeight++;

        if(currentWidth<0 || currentWidth>this.width || currentHeight<0 || currentHeight>this.height){
            return -1;
        }

        int[] newPos = new int[]{currentWidth, currentHeight};

        // if snake eats food
        int[] currentFood = this.food.size()>0?this.food.getFirst():null;
        if(currentFood !=null && currentFood[0] == currentHeight && currentFood[1] == currentWidth){
            this.body.addLast(newPos);
            this.food.removeFirst();
            this.score++;
        }
        else {
            this.body.removeFirst();
            // snake cross its own body
            for(int[] bCell : this.body){
                if(bCell[0] == currentWidth && bCell[1] == currentHeight){
                    return -1;
                }
            }
            // valid cell
            this.body.addLast(newPos);
        }
        return this.score;
    }
}
