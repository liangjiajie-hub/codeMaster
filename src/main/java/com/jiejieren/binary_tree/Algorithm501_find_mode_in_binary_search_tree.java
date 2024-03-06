package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * 示例 1：
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：root = [0]
 * 输出：[0]
 * 提示：
 * 树中节点的数目在范围 [1, 104] 内
 * -105 <= Node.val <= 105
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class Algorithm501_find_mode_in_binary_search_tree {

    private Map<Integer, Integer> map = new HashMap<>();

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inorderTraversal(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.right != null) inorderTraversal(root.right);
    }

    public int[] findMode(TreeNode root) {
        inorderTraversal(root);
        List<Integer> list = new ArrayList<>();
        int maxFrequency = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxFrequency = Math.max(maxFrequency, entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxFrequency == entry.getValue()) list.add(entry.getKey());
        }
        return list.stream().mapToInt(item -> item).toArray();
    }


    // 代码随想录题解做法
    List<Integer> result = new ArrayList<>();

    int maxCount = 0;
    int count = 0;

    TreeNode cur;

    public int[] findMode2(TreeNode root) {
        search(root);
        if (count + 1 > maxCount) {
            result.clear();
            result.add(cur.val);
        } else if (count + 1 == maxCount) {
            result.add(cur.val);
        }
        return result.stream().mapToInt(item -> item).toArray();
    }

    private void search(TreeNode root) {
        if (root == null) return;
        search(root.left);
        if (cur != null) {
            count++;
            if (cur.val != root.val) {
                if (count > maxCount) {
                    maxCount = count;
                    result.clear();
                    result.add(cur.val);
                } else if (count == maxCount) {
                    result.add(cur.val);
                }
                count = 0;
            }
        }
        cur = root;
        search(root.right);
    }

    public static void main(String[] args) {

    }
}
