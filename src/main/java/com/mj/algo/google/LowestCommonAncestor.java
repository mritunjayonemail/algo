package com.mj.algo.google;

import com.mj.algo.tree.modal.Tree;

public class LowestCommonAncestor {

    public static Tree findLCA(Tree ptr, String s1, String s2){
        if(ptr == null){
            return null;
        }
        if(ptr.getValue().equals(s1) ||  ptr.getValue().equals(s2) ){
            return ptr;
        }
        Tree left = null;
        Tree right = null;
        if (ptr.getLeft() !=null) {
            left = findLCA(ptr.getLeft(), s1, s2);
        }
        if (ptr.getRight() !=null) {
            right = findLCA(ptr.getRight(), s1, s2);
        }
        if(left == null && right == null){
            return null;
        }

        if(left != null && right != null){
            return ptr;
        }
        else if(left !=null){
            return findLCA(left, s1, s2);
        }
        else if(right !=null){
            return findLCA(right, s1, s2);
        }
        return null;
    }

    public static void main(String args[]){

        Tree child11 = new Tree("D", null, null);
        Tree child22 = new Tree("E", null, null);
        Tree child33 = new Tree("F", null, null);
        Tree child44 = new Tree("G", null, null);

        Tree child1 =  new Tree("B", child11, child22);
        Tree child2 =  new Tree("C", child33, child44);

        Tree root = new Tree("A", child1, child2);

        Tree lcaNode = findLCA(root, "D", "F");
        System.out.println("LCA(D,F) is ->" + lcaNode!=null?lcaNode.getValue():"No LCA");

    }
}
