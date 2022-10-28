package com.atul.leetcode.linkedList;

import com.atul.leetcode.ListNode;

/*
    LC #92 https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetween {

    public ListNode reverseBetween1(ListNode head, int m, int n) {

        if(head==null || head.next==null || m==n)
            return head;

        ListNode cur = head, pre = null;
        while(m>1) {
            m--;
            n--;
            pre = cur;
            cur = cur.next;
        }

        ListNode con = pre, tail = cur;

        while(n>0) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            n--;
        }

        if(con==null) {
            head = pre;
        } else {
            con.next = pre;
        }

        tail.next = cur;
        return head;
    }



    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head==null || head.next==null || left==right)
            return head;

        ListNode start = new ListNode(0), post = head, pre = start;
        start.next = head;
        int i=0;
        while(i<left-1) {
            i++;
            pre = pre.next;
        }
        post = pre;
        while(i<right) {
            i++;
            post = post.next;
        }
        ListNode nxt = post.next;
        post.next = null;

        ListNode temp = pre.next;
        pre.next = reverse(pre.next);
        temp.next = nxt;
        return start.next;

    }

    public ListNode reverse(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }


}
