package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

import java.util.Stack;

/*
Post Order tree traversal
Left->right->root
 */
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

    public void postOrder(Tree<String> root){
        Tree<String> ptr = root;
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
        Tree<String> child11 = new Tree<String>("D", null, null);
        Tree<String> child22 = new Tree<String>("E", null, null);
        Tree<String> child33 = new Tree<String>("F", null, null);
        Tree<String> child44 = new Tree<String>("G", null, null);

        Tree<String> child1 =  new Tree<String>("B", child11, child22);
        Tree<String> child2 =  new Tree<String>("C", child33, child44);

        Tree<String> root = new Tree<String>("A", child1, child2);

        PostOrder postOrder = new PostOrder();
        postOrder.postOrder(root);
    }
}
