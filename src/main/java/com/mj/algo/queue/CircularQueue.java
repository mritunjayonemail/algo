package com.mj.algo.queue;

/*
Circular queue representation
 */
public class CircularQueue {

    private int size;
    private int[] arr;
    private int front=-1;
    private int rear=-1;

    public CircularQueue(final int size){
        this.size= size;
        this.arr = new int[size];
    }

    public void qInsert(int item){
        if((this.front == 0  & this.rear == this.size-1) || (this.front == this.rear+1)){
            System.out.print("Overflow");
        }
        if(this.front==-1){
            this.front = 0;
            this.rear=0;
        }

        if(this.rear == this.size-1){
            this.rear = 0;
        }
        else {
            this.rear = this.rear + 1;
        }
        this.arr[this.rear] = item;
    }

    public void qDelete(){
        if(this.front == -1){
            System.out.print("Underrflow");
        }

        if(this.front == this.rear){
            this.front = -1;
            this.rear = -1;
        }
        if(this.front==this.size-1){
            this.front = 0;
        }
        else {
            this.front = this.front + 1;
        }

    }


    public static void main(String args[]){
        CircularQueue queue = new CircularQueue(5);
        queue.qInsert(2);
        queue.qInsert(8);
        queue.qInsert(5);
        queue.qInsert(10);
        queue.qInsert(9);

    }

}
