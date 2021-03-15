package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

import java.util.*;

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */
public class TreeZigZaw {

    public List<List<String>> zigzagLevelOrder(Tree<String> root) {
        List<List<String>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        int odd = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<String> currentLevel = new ArrayList<String>();
            for(int i=0; i<size; i++){
                Tree<String> currentNode = queue.remove();
                currentLevel.add(currentNode.getValue());
                if(currentNode.getLeft()!=null){
                    queue.add(currentNode.getLeft());
                }
                if(currentNode.getRight()!=null){
                    queue.add(currentNode.getRight());
                }
            }


            if(odd%2==0){
                result.add(currentLevel);
            }
            else {
                Collections.reverse(currentLevel);
                result.add(currentLevel);
            }
            odd++;
        }
        return result;
    }

    public static void main(String args[]){
        Tree<String> child11 = new Tree<String>("D", null, null);
        Tree<String> child22 = new Tree<String>("E", null, null);
        Tree<String> child33 = new Tree<String>("F", null, null);
        Tree<String> child44 = new Tree<String>("G", null, null);

        Tree<String> child1 =  new Tree<String>("B", child11, child22);
        Tree<String> child2 =  new Tree<String>("C", child33, child44);

        Tree<String> root = new Tree<String>("A", child1, child2);

        TreeZigZaw tz = new TreeZigZaw();
        List<List<String>> zigZawOrder = tz.zigzagLevelOrder(root);
        System.out.println("ZigZaw Order");
        for(List<String> item: zigZawOrder){
            item.forEach(a -> System.out.print(a));
            System.out.println();
        }
    }



}
