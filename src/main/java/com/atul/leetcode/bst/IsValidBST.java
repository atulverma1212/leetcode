package com.atul.leetcode.bst;


import com.atul.leetcode.TreeNode;

class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) return true;

        if(max != null && root.val >= max.val) return false;
        if(min != null && root.val <= min.val) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}