package com.atul.leetcode.tree;

import com.atul.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    LC #107 https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */

class LevelOrderTraversal2 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            List<Integer> row = new LinkedList<>();

            int n = q.size();
            for(int i=0;i<n;i++) {

                TreeNode temp = q.poll();
                row.add(temp.val);
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            }
            res.add(0, row);
        }

        return res;
    }

    // DFS Solution
    public List<List<Integer>> dfs(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}

