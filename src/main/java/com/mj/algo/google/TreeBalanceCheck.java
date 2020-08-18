package com.mj.algo.google;

import com.mj.algo.tree.modal.Tree;

public class TreeBalanceCheck {

    public static boolean treeBalanceCheck(Tree root){
        if(root==null){
            return true;
        }

        int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight());
        if (Math.abs(heightDiff) > 1){
            return false;
        }

        return treeBalanceCheck(root.getLeft())&& treeBalanceCheck(root.getRight());


    }

    public static int getHeight(Tree root){

        if(root==null){
            return 0;
        }

        int leftHeight = 0;
        int rightHeight = 0;

        if (root.getLeft() != null){
            leftHeight = getHeight(root.getLeft()) + 1;
        }

        if (root.getRight() != null){
            rightHeight = getHeight(root.getRight()) + 1;
        }

        return leftHeight>rightHeight?leftHeight:rightHeight;

    }

    public static int checkHeight(Tree root){
        if(root == null){
            return 0;
        }

        int leftHeight = checkHeight(root.getLeft());
        if (leftHeight==-1){
            return -1;
        }

        int rightHeight = checkHeight(root.getRight());
        if (rightHeight==-1){
            return -1;
        }

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff)>1){
            return -1;
        }
        else{
            return Math.max(checkHeight(root.getLeft()), checkHeight(root.getRight()));
        }
    }

    public static boolean treeBalanceCheckON(Tree root){
        // check height balance of tree in O1 time
        if (checkHeight(root) == -1){
            return false;
        }
        {
            return true;
        }
    }


    public static void main(String args[]){

        Tree t4 = new Tree("4", null, null);
        Tree t3 = new Tree("3", null, null);
        Tree t2 = new Tree("2", t3, null);
        Tree t1 = new Tree("1", t2, t3);

        System.out.println(getHeight(t1));

    }
}
