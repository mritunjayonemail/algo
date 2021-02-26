package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

import java.util.Stack;

/*
Pre order tree traversal
root->left->right
 */
public class PreOrder {

    Stack<Tree> stack = new Stack<Tree>();

    public void preOrder(Tree<String> root){
        Tree<String> ptr = root;
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
            Tree<String> child11 = new Tree<String>("D", null, null);
            Tree<String> child22 = new Tree<String>("E", null, null);
            Tree<String> child33 = new Tree<String>("F", null, null);
            Tree<String> child44 = new Tree<String>("G", null, null);

            Tree<String> child1 =  new Tree<String>("B", child11, child22);
            Tree<String> child2 =  new Tree<String>("C", child33, child44);

            Tree<String> root = new Tree<String>("A", child1, child2);

            PreOrder preOrder = new PreOrder();
            preOrder.preOrder(root);
    }
}
