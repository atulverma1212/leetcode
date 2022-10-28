package com.atul.leetcode.linkedList;

import com.atul.leetcode.TreeNode;

/*
    LC #114 https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenTree {

    // TODO: Iterative Solution

    public void flatten(TreeNode root) {

        if(root == null)
            return;

        flatten(root.left);

        TreeNode temp = root.right;

        root.right = root.left;
        root.left = null;
        while(root.right != null)
            root = root.right;
        root.right = temp;

        flatten(root.right);

    }

}
