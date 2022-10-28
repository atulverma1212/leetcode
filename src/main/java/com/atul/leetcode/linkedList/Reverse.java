package com.atul.leetcode.linkedList;

import com.atul.leetcode.ListNode;

/*
    LC #206 https://leetcode.com/problems/reverse-linked-list/
 */
public class Reverse {
    public ListNode reverseList(ListNode head) {
        return reverse1(head, null);
    }

    public ListNode reverseIter(ListNode head) {
        ListNode pre=null, cur = head, nxt = null;
        while(cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public ListNode reverse1(ListNode head, ListNode newHead) {
        if(head==null)
            return newHead;

        ListNode next = head.next;
        head.next = newHead;
        return reverse1(next, head);
    }

    public ListNode reverse(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
