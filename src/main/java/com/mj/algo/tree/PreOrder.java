package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

import java.util.Stack;

/*
Pre order tree traversal
root->left->right
 */
public class PreOrder {

    Stack<Tree> stack = new Stack<Tree>();

    public void preOrder(Tree root){
        Tree ptr = root;
        while(ptr !=null){
           System.out.println(ptr.getValue());
           if(ptr.getRight()!=null){
               stack.push(ptr.getRight());
           }
           if(ptr.getLeft()!=null){
               ptr = ptr.getLeft();
           }
           else if (!stack.empty()){
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

            PreOrder preOrder = new PreOrder();
            preOrder.preOrder(root);
    }
}
