package com.atul.leetcode.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    LC #20 https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParenthesis {
    public boolean isValid(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = str.toCharArray();
        for(char s : arr) {
            if(s == '(' || s=='[' || s=='{')
                stack.push(s);
            else if(!stack.isEmpty() && ((s==')' && stack.peek()=='(')
                    || (s==']' && stack.peek()=='[')
                    || (s=='}' && stack.peek()=='{')) ) {
                stack.pop();
            }
            else
                return false;
        }
        return stack.isEmpty();
    }
}
