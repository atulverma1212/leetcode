package com.atul.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 LC #496 https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<nums2.length;i++) {
            while(!s.empty() && nums2[s.peek()] < nums2[i])
                map.put(nums2[s.pop()], nums2[i]);
            s.push(i);
        }
        for(int i=0;i<nums1.length;i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
