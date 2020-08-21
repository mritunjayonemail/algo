package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

import java.util.Stack;

public class PostOrder {

    class StackItem {
        boolean flag;
        Tree item;
        StackItem(boolean flag, Tree item){
            this.flag = flag;
            this.item = item;
        }
    }

    Stack<StackItem> stack = new Stack<StackItem>();

    public void postOrder(Tree root){
        Tree ptr = root;
        if(ptr == null){
            return;
        }
        while(ptr !=null){
            StackItem stackItem = new StackItem(false, ptr);
            stack.push(stackItem);
            if (ptr.getRight() !=null){
                stackItem = new StackItem(true, ptr.getRight());
                stack.push(stackItem);
            }
            ptr = ptr.getLeft();
        }
        StackItem stackItem = stack.pop();
        while(stackItem !=null){
            if(stackItem.flag){
                postOrder(stackItem.item);
            }
            else {
                System.out.println(stackItem.item.getValue());
            }
            if(!stack.empty()){
                stackItem = stack.pop();
            }
            else {
                stackItem = null;
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

        PostOrder postOrder = new PostOrder();
        postOrder.postOrder(root);
    }
}
