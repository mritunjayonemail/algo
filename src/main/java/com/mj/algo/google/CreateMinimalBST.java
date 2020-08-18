package com.mj.algo.google;

import com.mj.algo.tree.modal.Tree;

import java.util.Arrays;

public class CreateMinimalBST {

    public Tree createMinimalBST(int[] array, int start, int end){

        if(start>end){
            return null;
        }

        int mid = Math.abs((start + end)/2);
        Tree left =  createMinimalBST(array, start, mid-1);
        Tree right =  createMinimalBST(array, mid+1, end);
        return new Tree(new Integer(array[mid]).toString(), left, right);
    }

    public static void main(String args[]){

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        Arrays.sort(arr);
        CreateMinimalBST createMinimalBST = new CreateMinimalBST();
        Tree root = createMinimalBST.createMinimalBST(arr, 0, 7);
        System.out.print(root);

    }
}
