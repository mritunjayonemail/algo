package com.mj.algo.stack;

import java.util.Stack;

/*
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<Character>();
        for(int index=0; index<num.length(); index++){
            char ch = num.charAt(index);
            while(!stack.isEmpty() && k>0 && stack.lastElement()>ch){
                stack.pop();
                k--;
            }
            if(!stack.isEmpty() || !(ch == '0')){
                stack.push(ch);
            }

        }

        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()){
            return "0";
        }
        StringBuffer sf = new StringBuffer();
        while(!stack.isEmpty()){
            sf.insert(0, String.valueOf(stack.pop()));
        }
        return sf.toString();
    }

    public static void main(String args[]){
        RemoveKDigits rkd = new RemoveKDigits();
        System.out.printf("Digits after removing %1d digits from string %2s are %3s", 3, "1432219", rkd.removeKdigits("1432219", 3));
    }
}
