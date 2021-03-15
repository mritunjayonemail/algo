package com.mj.algo.tree;

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

import com.mj.algo.tree.modal.Tree;

class Height {
    int h;
}


public class TreeDiameter {

    int ans = 0;
    public int diameterOfBinaryTree(Tree<String> root) {
        int ans = getDiameter(root, new Height());
        return ans==0?0:ans-1;

    }

    private int getDiameter(Tree<String> root, Height height){
        if (root == null){
            height.h=0;
            return 0;
        }

        Height lh = new Height();
        Height rh = new Height();

        int ldiameter = getDiameter(root.getLeft(), lh);
        int rdiameter = getDiameter(root.getRight(), rh);
        height.h = 1+ Math.max(lh.h, rh.h);
        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
    }

    public static void main(String args[]){
        Tree<String> child11 = new Tree<String>("D", null, null);
        Tree<String> child22 = new Tree<String>("E", null, null);
        Tree<String> child33 = new Tree<String>("F", null, null);
        Tree<String> child44 = new Tree<String>("G", null, null);

        Tree<String> child1 =  new Tree<String>("B", child11, child22);
        Tree<String> child2 =  new Tree<String>("C", child33, child44);

        Tree<String> root = new Tree<String>("A", child1, child2);

        TreeDiameter td = new TreeDiameter();
        System.out.println("Diameter of tree is " + td.diameterOfBinaryTree(root));
    }


}
