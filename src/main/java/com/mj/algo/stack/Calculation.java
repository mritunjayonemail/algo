package com.mj.algo.stack;

import java.util.Stack;

/*
Given a string s representing an expression, implement a basic calculator to evaluate it.



Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
 */
public class Calculation {

    public int calculate(String s) {
        Stack<Character> stack = new Stack<Character>();
        StringBuffer posix = new StringBuffer();
        for(char ch : s.toCharArray()){
            if(ch == '-'  || ch == '(') stack.push(ch);
            else if(ch == '+'){
                while (! stack.isEmpty() && stack.peek() == '-'){
                    posix.append("-");
                    stack.pop();
                }
                stack.push('+');
            }
            else if (ch != ' ') {
                if(ch == ')'){
                    Character operand = stack.pop();
                    while(operand!='('){
                        posix.append(String.valueOf(operand));
                        operand = stack.pop();
                    }
                }
                else {
                    posix.append(String.valueOf(ch));
                }
            }
        }

        StringBuffer rem = new StringBuffer();
        while(!stack.isEmpty()){
            if(stack.peek() == '-'){
                posix.append("-");
                stack.pop();
            }
            else if(stack.peek() == '+'){
                stack.pop();
                while (!stack.isEmpty() && stack.peek() == '-'){
                    posix.append("-");
                    stack.pop();
                }
                posix.append("+");
            }
        }

        System.out.println(posix);
        Stack<Integer> stack1 = new Stack<Integer>();
        for(char ch: posix.toString().toCharArray()){
            if(ch == '+' || ch == '-'){
                int val1 = stack1.pop();
                int val2 = stack1.pop();
                if(ch == '+'){
                    stack1.push(val1 + val2);
                }
                else if(ch == '-'){
                    stack1.push(val2 - val1);
                }
            }
            else {
                stack1.push(Integer.parseInt(String.valueOf(ch)));
            }
        }
        return stack1.pop();

    }

    public static void main(String args[]){
        Calculation cal = new Calculation();

        System.out.println("Calc is " + cal.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
