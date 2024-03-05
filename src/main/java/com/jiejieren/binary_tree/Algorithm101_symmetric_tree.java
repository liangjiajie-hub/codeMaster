package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Algorithm101_symmetric_tree {

    private Queue<Entity> queue = new ArrayDeque<>();

    class Entity {
        public int level;
        public int val;

        public Entity(int level, int val) {
            this.level = level;
            this.val = val;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        dfs(root.left, 1, 2);
        dfs(root.right, 0, 2);
        return queue.size() == 0;
    }

    private void dfs(TreeNode root, int flag, int level) {
        if (root == null) return;
        if (flag == 1) {
            dfs(root.left, 1, level + 1);
            queue.add(new Entity(level, root.val));
            dfs(root.right, 1, level + 1);
        } else {
            dfs(root.right, 0, level + 1);
            if (!queue.isEmpty()
                    && queue.peek().val == root.val
                    && queue.peek().level == level) queue.remove();
            else {
                queue.add(new Entity(level, root.val));
                return;
            }
            dfs(root.left, 0, level + 1);
        }
    }

    public static void main(String[] args) {

    }
}
