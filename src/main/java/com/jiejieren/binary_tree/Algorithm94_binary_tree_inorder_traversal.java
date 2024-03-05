package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Algorithm94_binary_tree_inorder_traversal {

    // 递归法
    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        result.add(root.val);
        dfs(root.right);
    }

    // 迭代法
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result2 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (stack.size() != 0) {
            TreeNode p = stack.peek();
            if (p.left == null) {
                result2.add(stack.pop().val);
                if (p.right != null) {
                    stack.push(p.right);
                    p.right = null;
                }
            } else {
                if (p.right != null) {
                    stack.pop();
                    stack.push(p.right);
                    stack.push(p);
                    p.right = null;
                }
                stack.push(p.left);
                p.left = null;
            }
        }
        return result2;
    }


    public static void main(String[] args) {

    }
}
