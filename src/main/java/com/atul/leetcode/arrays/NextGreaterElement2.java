package com.atul.leetcode.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    LC #503 https://leetcode.com/problems/next-greater-element-ii/
 */
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {

        Deque<Integer> s = new ArrayDeque<>();

        int l = nums.length;
        int res[] = new int[l];

        for(int i=2*l;i >= 0;i--) {
            int c = i%l;
            while(!s.isEmpty() && nums[s.peek()] <= nums[c])
                s.pop();

            res[c] = s.isEmpty()? -1 : nums[s.peek()];
            s.push(c);
        }

        return res;


    }
}
