package com.atul.leetcode.linkedList;

import com.atul.leetcode.ListNode;

/*
    LC #142 https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}



