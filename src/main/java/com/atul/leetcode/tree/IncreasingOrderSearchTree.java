package com.atul.leetcode.tree;

import com.atul.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
    LC #897 https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        dfs(root, ans);
        return ans.right;
    }

    // DFS Solution
    public TreeNode dfs(TreeNode node, TreeNode cur) {
        if (node == null) return cur;
        cur = dfs(node.left, cur);

        node.left = null;
        cur.right = node;

        cur =  dfs(node.right, cur.right);
        return cur;
    }

    // Second Solution
    public TreeNode increasingBST2(TreeNode root) {
        List<Integer> arr = new LinkedList<>();

        inorder(root, arr);
        TreeNode res = new TreeNode(0), ans = res;
        for(int i : arr) {
            res.right = new TreeNode(i);
            res = res.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List arr) {
        if (node == null) return;
        inorder(node.left, arr);
        arr.add(node.val);
        inorder(node.right, arr);
    }
}
