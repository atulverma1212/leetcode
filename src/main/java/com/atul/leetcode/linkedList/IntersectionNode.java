package com.atul.leetcode.linkedList;

import com.atul.leetcode.ListNode;

/*
 LC #160 https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA, b = headB;

        while(a != b) {
            a = a==null?  headB : a.next;
            b = b== null? headA : b.next;
        }
        return a;

    }
}
