package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

import java.util.Stack;

/*
In order tree traversal
left>root>right
 */
public class InOrder {

    Stack<Tree> stack = new Stack<Tree>();

    public void inOrder(Tree<String> root){
        Tree<String> ptr = root;
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
        Tree<String> child11 = new Tree<String>("D", null, null);
        Tree<String> child22 = new Tree<String>("E", null, null);
        Tree<String> child33 = new Tree<String>("F", null, null);
        Tree<String> child44 = new Tree<String>("G", null, null);

        Tree<String> child1 =  new Tree<String>("B", child11, child22);
        Tree<String> child2 =  new Tree<String>("C", child33, child44);

        Tree<String> root = new Tree<String>("A", child1, child2);

        InOrder inOrder = new InOrder();
        inOrder.inOrder(root);
    }


}
