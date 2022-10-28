package com.atul.leetcode.arrays;

/*
    LC #189 https://leetcode.com/problems/rotate-array/
 */
public class RotateRight {

        public void rotate(int[] nums, int k) {
            k%=nums.length;
            int n = nums.length;

            int count = 0;

            for(int start=0; count<n; start++) {
                int current = start;
                int prev = nums[start];
                do {
                    int next = (start+k)%n;
                    int temp = nums[next];
                    nums[next] = prev;
                    prev = temp;
                    count++;
                    start = next;
                } while(start != current);
            }
        }
}
