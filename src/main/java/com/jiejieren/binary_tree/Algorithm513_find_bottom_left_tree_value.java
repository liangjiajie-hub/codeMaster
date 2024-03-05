package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * 提示:
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 */
public class Algorithm513_find_bottom_left_tree_value {

    private int val;

    private int high;

    public int findBottomLeftValue(TreeNode root) {
        high = maxDepth(root);
        findByMaxDepth(root, 1);
        return val;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private void findByMaxDepth(TreeNode root, int level) {
        if (root == null) return;
        if (level == high) {
            val = root.val;
            high = Integer.MAX_VALUE;
        }
        findByMaxDepth(root.left, level + 1);
        findByMaxDepth(root.right, level + 1);
    }

    public static void main(String[] args) {

    }
}
