package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

/**
 * 111. 二叉树的最小深度
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class Algorithm111_minimum_depth_of_binary_tree {

    public int minDepth(TreeNode root) {
        if (root != null) {
            if (root.left != null && root.right != null)
                return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
            if (root.left == null && root.right == null) return 1;
            return root.left != null ? minDepth(root.left) + 1 : minDepth(root.right) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
