package com.atul.leetcode.linkedList;

import com.atul.leetcode.ListNode;

/*
 LC #19: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromLast {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;

        for(int i=0;i<n;i++)
            fast = fast.next;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;

    }

    // TODO
    public ListNode recursive(ListNode head, int n) {
        return null;
    }



}
