package com.atul.leetcode.strings;

/*
    LC #28 https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class StrStr {

    public int strStr(String haystack, String needle) {

        int l1 = haystack.length();
        int l2 = needle.length();

        if(l2 > l1 || l1==0)
            return -1;

        for(int i=0;i<l1;i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                if(check(haystack, needle, l1, l2, i))
                    return i;
            }
        }
        return -1;

    }

    private boolean check(String h, String n, int l1, int l2, int index) {
        int i=index, j = 0;
        while(i<l1 && j<l2) {
            if(h.charAt(i++) != n.charAt(j++))
                return false;
        }
        return j==l2;
    }
}
