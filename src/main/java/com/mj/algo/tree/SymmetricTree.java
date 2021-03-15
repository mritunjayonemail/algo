package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

import java.util.List;

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 */
public class SymmetricTree {

    private String serialise(Tree<String> root, String s, boolean p){
        if(root==null){
            return "null,";
        }
        if(p){
            s = s + root.getValue() + "," + serialise(root.getLeft(), s, p) + serialise(root.getRight(), s, p);
        }
        else {
            s = s + root.getValue() + "," + serialise(root.getRight(), s, p) + serialise(root.getLeft(), s, p);
        }
        return s;
    }

    public boolean isSymmetric(Tree root) {
        String left = serialise(root, "", true);
        String right = serialise(root, "", false);

        return left.equals(right);

    }

    public static void main(String args[]){
        Tree<String> child11 = new Tree<String>("3", null, null);
        Tree<String> child22 = new Tree<String>("4", null, null);
        Tree<String> child33 = new Tree<String>("4", null, null);
        Tree<String> child44 = new Tree<String>("3", null, null);

        Tree<String> child1 =  new Tree<String>("2", child11, child22);
        Tree<String> child2 =  new Tree<String>("2", child33, child44);

        Tree<String> root = new Tree<String>("1", child1, child2);

        SymmetricTree st = new SymmetricTree();
        System.out.println("Symmetric tree: " + st.isSymmetric(root));
    }


}
