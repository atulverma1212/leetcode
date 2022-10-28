package com.atul.leetcode.tree;

import com.atul.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    LC #145 https://leetcode.com/problems/binary-tree-postorder-traversal
 */
public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root, pre = null;
        while(cur!=null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if(cur.right != null && cur.right != pre) {
                    cur = cur.right;
                } else {
                    cur = stack.pop();
                    res.add(cur.val);
                    pre = cur;
                    cur = null;
                }
            }
        }
        return res;
    }
}
