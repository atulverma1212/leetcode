package com.atul.leetcode.linkedList;

import com.atul.leetcode.ListNode;

/*
    LC: #83 https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        return recurse1(head);
    }

    public ListNode delete(ListNode head) {
        if(head==null || head.next == null)
            return head;

        ListNode temp = head;

        while(temp.next!=null) {
            if(temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }

        return head;

    }

    public ListNode recurse(ListNode head) {
        if(head==null || head.next == null)
            return head;

        if(head.val == head.next.val)
            return recurse(head.next);
        else
            head.next = recurse(head.next);

        return head;
    }

    public ListNode recurse1(ListNode head) {
        if(head==null || head.next==null)
            return head;

        head.next = recurse1(head.next);
        return (head.next.val == head.val) ? head.next : head;
    }
}
