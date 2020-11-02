package com.mj.algo.leetcode;

import java.util.Stack;

/*

A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.

Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.



Example 1:

Input: "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 */
public class ParenthesisRemoval {
    public String removeOuterParentheses(String S) {
        StringBuffer newStr = new StringBuffer("");
        Stack stack = new Stack();
        StringBuffer innerStr = new StringBuffer("");
        for (int i = 0; i < S.length(); i++) {
            char charI = S.charAt(i);
            if (charI == '(') {
                stack.push(charI);
                innerStr.append("(");
            } else if (charI == ')' & !stack.isEmpty()) {
                char pItm = (char)stack.pop();
                if(stack.size()==0 & pItm == '('){
                    innerStr.deleteCharAt(0);
                    newStr.append(innerStr);
                    stack = new Stack();
                    innerStr = new StringBuffer("");
                }
                else{
                    innerStr.append(")");
                }
            }

        }
        return newStr.toString();
    }

    public static void main(String args[]){
        String parenthesis = "()()";
        ParenthesisRemoval  pr = new ParenthesisRemoval();
        System.out.println(pr.removeOuterParentheses(parenthesis));

    }
}
