package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

/**
 * 110. 平衡二叉树
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 */
public class Algorithm110_balanced_binary_tree {

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftHigh = dfs(root.left);
        int rightHigh = dfs(root.right);
        if (Math.abs(leftHigh - rightHigh) > 1) flag = false;
        return Math.max(leftHigh, rightHigh) + 1;
    }

    public static void main(String[] args) {

    }
}
