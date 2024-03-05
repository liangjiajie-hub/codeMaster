package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257. 二叉树的所有路径
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 * 输入：root = [1]
 * 输出：["1"]
 * 提示：
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 */
public class Algorithm257_binary_tree_paths {

    private List<String> result = new ArrayList<>();

    private Stack<TreeNode> stack = new Stack<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            stack.add(root);
            dfs(root);
        }
        return result;
    }

    private void dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            result.add(generatePathStr(stack));
            return;
        }
        if (root.left != null) {
            stack.add(root.left);
            dfs(root.left);
            stack.pop();
        }
        if (root.right != null) {
            stack.add(root.right);
            dfs(root.right);
            stack.pop();
        }
    }

    private String generatePathStr(Stack<TreeNode> stack) {
        StringBuilder result = new StringBuilder();
        stack.stream().mapToInt(node -> node.val).forEach(item -> {
            if (result.length() > 0) {
                result.append("->").append(item);
            } else {
                result.append(item);
            }
        });
        return result.toString();
    }

    public static void main(String[] args) {

    }
}
