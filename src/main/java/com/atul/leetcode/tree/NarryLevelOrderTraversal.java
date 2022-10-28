package com.atul.leetcode.tree;


import com.atul.leetcode.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    LC #429 https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
class NarryLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            List<Integer> row = new LinkedList<>();

            int n = q.size();
            for(int i=0;i<n;i++) {

                Node temp = q.poll();
                row.add(temp.val);
                for(Node child : temp.children) {
                    if(child!=null)
                        q.offer(child);
                }
            }
            res.add(row);
        }
        return res;
    }

    // DFS Solution

    public List<List<Integer>> dfs(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        traverse(res, root, 0);
        return res;
    }

    public void traverse(List<List<Integer>> res, Node root, int level) {
        if(root == null) return;
        if(level >= res.size())
            res.add(new LinkedList<Integer>());
        res.get(level).add(root.val);
        for(Node child : root.children)
            if(child != null)
                traverse(res, child, level+1);
    }
}

