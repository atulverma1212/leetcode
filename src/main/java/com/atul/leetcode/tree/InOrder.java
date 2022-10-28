package com.atul.leetcode.tree;


import com.atul.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    LC #94 https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root!=null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;

    }
}
