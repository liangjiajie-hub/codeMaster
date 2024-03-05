package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

public class Algorithm226_invert_binary_tree {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {

    }
}
