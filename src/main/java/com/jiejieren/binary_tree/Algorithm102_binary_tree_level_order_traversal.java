package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 中等
 * 相关标签
 * 相关企业
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class Algorithm102_binary_tree_level_order_traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(temp);
        }
        return result;
    }

    // 递归法
    private List<List<Integer>> result2 = new ArrayList<>();

    public List<List<Integer>> levelOrder2(TreeNode root) {
        dfs(root, 1);
        return result2;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (result2.size() < level) {
            List<Integer> list = new ArrayList<>();
            result2.add(list);
        }
        result2.get(level - 1).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {

    }
}
