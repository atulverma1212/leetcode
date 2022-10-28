package com.atul.leetcode.tree;

import com.atul.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    LC #144 https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root!=null || !stack.isEmpty()) {
            while(root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
