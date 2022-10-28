package com.atul.leetcode.misc;


import java.util.*;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(! set.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                String str = q.poll();
                char[] arr = str.toCharArray();
                for(int j=0;j<arr.length;j++) {
                    char original = arr[j];
                    for(char c = 'a';c<='z';c++) {
                        if(c == original) continue;
                        arr[j] = c;
                        String chk = String.valueOf(arr);
                        if(chk.equals(endWord)) return level+1;
                        if(set.contains(chk)) {
                            q.offer(chk);
                            set.remove(chk);
                        }
                    }
                    arr[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}
