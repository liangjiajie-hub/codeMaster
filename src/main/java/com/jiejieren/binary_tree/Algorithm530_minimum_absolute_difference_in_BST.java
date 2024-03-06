package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * 提示：
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 * 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 */
public class Algorithm530_minimum_absolute_difference_in_BST {

    private List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) result = Math.min(result, list.get(i) - list.get(i - 1));
        }
        return result;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inorderTraversal(root.left);
        list.add(root.val);
        if (root.right != null) inorderTraversal(root.right);
    }

    public static void main(String[] args) {

    }
}
