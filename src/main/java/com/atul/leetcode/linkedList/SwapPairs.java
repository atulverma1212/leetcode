package com.atul.leetcode.linkedList;

import com.atul.leetcode.ListNode;

/*
  LC #24: https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    public ListNode swap(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode temp = head, cur = head;
        ListNode newHead = head.next;
        while(cur!=null && cur.next != null) {
            temp = cur;
            cur = cur.next;
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
            if(cur != null && cur.next != null)
                temp.next = cur.next;
        }
        return newHead;
    }

    public ListNode swap1(ListNode head) {
        if(head==null || head.next == null)
            return head;

        ListNode temp = head.next;
        head.next = swap1(head.next.next);
        temp.next = head;
        return temp;
    }

    public ListNode swap2(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode temp = head.next.next;
        ListNode t = head.next;
        head.next.next = head;
        head.next = swap2(temp);
        return t;
    }

    public ListNode swap3(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode result = head.next;
        ListNode prev = null, cur = head, nxt = head.next;

        while(cur!= null && cur.next != null) {
            nxt = cur.next;
            cur.next = nxt.next;
            nxt.next = cur;
            if(prev != null)
                prev.next = nxt;
            prev = cur;
            cur = cur.next;
        }
        return result;
    }

    public ListNode swap4(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode cur = head, n = cur.next, pre = start;
        while(cur!=null && cur.next != null) {
            n = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = n;
            pre = cur;
            cur = cur.next;
        }
        return start.next;
    }


}
