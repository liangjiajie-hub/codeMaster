package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

import java.util.Stack;

/**
 * 404. 左叶子之和
 * 简单
 * 相关标签
 * 相关企业
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * 示例 1：
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 示例 2:
 * 输入: root = [1]
 * 输出: 0
 * 提示:
 * 节点数在 [1, 1000] 范围内
 * -1000 <= Node.val <= 1000
 */
public class Algorithm404_sum_of_left_leaves {

    private Stack<TreeNode> stack = new Stack<>();

    private int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            stack.add(root);
            if (root.left == null && root.right == null) {
                root = stack.pop();
                if (stack.peek().left == root) result += root.val;
                stack.push(root);
                return;
            }
            if (root.left != null) {
                dfs(root.left);
                stack.pop();
            }
            if (root.right != null) {
                dfs(root.right);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {

    }
}
