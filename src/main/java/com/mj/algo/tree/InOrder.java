package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

import java.util.Stack;

/*
In order tree traversal
 */
public class InOrder {

    Stack<Tree> stack = new Stack<Tree>();

    public void inOrder(Tree root){
        Tree ptr = root;
        if(ptr == null){
            return;
        }
        stack.push(ptr);
        while(ptr.getLeft() !=null){
            stack.push(ptr.getLeft());
            ptr = ptr.getLeft();
        }
        ptr = stack.pop();
        while(ptr !=null){
            System.out.println(ptr.getValue());
            if(ptr.getRight()!=null){
                inOrder(ptr.getRight());
                ptr = null;
            }
            else if(!stack.empty()){
                ptr = stack.pop();
            }
            else {
                ptr = null;
            }
        }

    }



    public static void main(String args[]){
        Tree child11 = new Tree("D", null, null);
        Tree child22 = new Tree("E", null, null);
        Tree child33 = new Tree("F", null, null);
        Tree child44 = new Tree("G", null, null);

        Tree child1 =  new Tree("B", child11, child22);
        Tree child2 =  new Tree("C", child33, child44);

        Tree root = new Tree("A", child1, child2);

        InOrder inOrder = new InOrder();
        inOrder.inOrder(root);
    }
}
