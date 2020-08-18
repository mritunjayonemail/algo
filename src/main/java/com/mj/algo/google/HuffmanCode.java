package com.mj.algo.google;

import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode>{

    private char val;
    private int frequency;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(){

    }

    public HuffmanNode(char val, int frequency, HuffmanNode left, HuffmanNode right) {
        this.val = val;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode huffmanNode){
        if(this.frequency > huffmanNode.frequency){
            return 1;
        }
        else return 0;
    }
}

class HuffmanCodeComparator implements Comparator<HuffmanNode>{

    @Override
    public int compare(HuffmanNode huffmanNode1, HuffmanNode huffmanNode2) {
        return huffmanNode1.getFrequency() - huffmanNode2.getFrequency();
    }

}


public class HuffmanCode {


    public static void printHuffman(HuffmanNode root, String out){
       if(root == null){
           return;
       }
       if(root.getLeft()!=null){
           printHuffman(root.getLeft(), "0" + out);
       }
       if(root.getRight()!=null){
           printHuffman(root.getRight(), "1" + out);
       }
       if(root.getLeft()==null && root.getRight() ==null){
           System.out.println(root.getVal() + ": " + out);
       }
    }

    public static void main(String args[]){
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charFreq = { 15, 9, 12, 13, 16, 45 };

        PriorityQueue<HuffmanNode> huffmanNodePriorityQueue = new PriorityQueue<>(6, new HuffmanCodeComparator());
        int index = 0;
        while (index < 6){
            HuffmanNode hnode = new HuffmanNode(charArray[index], charFreq[index], null, null);
            huffmanNodePriorityQueue.add(hnode);
            index++;
        }

        HuffmanNode root = null;
        while(huffmanNodePriorityQueue.size()>1){
            HuffmanNode hNode1 = huffmanNodePriorityQueue.poll();
            HuffmanNode hNode2 = huffmanNodePriorityQueue.poll();
            root = new HuffmanNode();
            root.setVal('-');
            root.setLeft(hNode1);
            root.setRight(hNode2);
            int comFreq = 0;
            if (hNode1 !=null){
                comFreq = comFreq + hNode1.getFrequency();
            }
            if (hNode2 !=null){
                comFreq = comFreq + hNode2.getFrequency();
            }

            root.setFrequency(comFreq);
            huffmanNodePriorityQueue.add(root);
        }

        printHuffman(root, "");






    }
}
