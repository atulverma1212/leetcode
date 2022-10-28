package com.atul.leetcode.tree;

import com.atul.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    LC #103 https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 */
public class ZigZagOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        boolean rev = false;

        while(!q.isEmpty()) {
            List<Integer> row = new LinkedList<>();

            int n = q.size();
            for(int i=0;i<n;i++) {

                TreeNode temp = q.poll();
                if(rev)
                    row.add(0, temp.val);
                else
                    row.add(temp.val);
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);

            }
            res.add(row);
            rev = !rev;
        }

        return res;
    }
}
