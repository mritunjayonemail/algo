package com.mj.algo.tree;

import com.mj.algo.tree.modal.Tree;

import java.util.ArrayList;
import java.util.List;

/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

Complexity of algorithm is O(n)
 */
public class PathSum {

    private int count = 0;
    private List<Integer> paths = new ArrayList<Integer>();

    public void getSum(Tree<Integer> root, int sum){
        if(root == null){
            return;
        }

        paths.add(root.getValue());

        pathSum(root.getLeft(), sum);

        pathSum(root.getRight(), sum);

        int tempSum =0;
        for(int i=paths.size()-1; i>=0; i--) {
            tempSum = tempSum + paths.get(i);
            if(tempSum == sum){
                count++;
            }
        }
        paths.remove(paths.size()-1);

    }

    public int pathSum(Tree<Integer> root, int sum) {

        getSum(root, sum);
        return count;
    }

    public static void main(String args[]){
        Tree<Integer> child41 = new Tree<Integer>(3, null, null);
        Tree<Integer> child42 = new Tree<Integer>(-2, null, null);
        Tree<Integer> child43 = new Tree<Integer>(1, null, null);
        Tree<Integer> child31 = new Tree<Integer>(3,child41, child42);
        Tree<Integer> child32 = new Tree<Integer>(2, null, child43);
        Tree<Integer> child33 = new Tree<Integer>(11,null, null);

        Tree<Integer> child1 =  new Tree<Integer>(5, child31, child32);
        Tree<Integer> child2 =  new Tree<Integer>(-3, null, child33);

        Tree<Integer> root = new Tree<Integer>(10, child1, child2);

        PathSum pathSum = new PathSum();
        System.out.println("Paths is: " + pathSum.pathSum(root, 8));
    }
}
