package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Example 1:

Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,2]
Output: [1,2]
 */
public class Serialize {

    private String rSerialize(Tree tree, String str){
        if(tree==null) return str + "null,";
        str = str  + tree.getValue() + ',';
        str = rSerialize(tree.getLeft(), str);
        str = rSerialize(tree.getRight(), str);
        return str;
    }

    public String serealize(Tree tree){
        return rSerialize(tree, "");
    }

    private Tree<String> rDeserealize(List<String> l){
        if(l.get(0).equals("null")){
            l.remove(0);
            return null;
        }
        Tree tree = new Tree(l.get(0), null, null);
        l.remove(0);
        Tree left = rDeserealize(l);
        Tree right = rDeserealize(l);
        tree.setLeft(left);
        tree.setRight(right);
        return tree;
    }

    public Tree<String> deserealize(String s){
        String[] data_array = s.split(",");
        List<String> data_list = new LinkedList(Arrays.asList(data_array));
        return rDeserealize(data_list);
    }

    public static void main(String args[]){
        Tree<String> child11 = new Tree<String>("D", null, null);
        Tree<String> child22 = new Tree<String>("E", null, null);
        Tree<String> child33 = new Tree<String>("F", null, null);
        Tree<String> child44 = new Tree<String>("G", null, null);

        Tree<String> child1 =  new Tree<String>("B", child11, child22);
        Tree<String> child2 =  new Tree<String>("C", child33, child44);

        Tree<String> root = new Tree<String>("A", child1, child2);

        Serialize se = new Serialize();
        String ser = se.serealize(root);
        System.out.println("Serialized string is " + ser);

        Tree des = se.deserealize(ser);
        System.out.println("DeSerialized node is " + des);
    }

}
