package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * 示例 1:
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * 提示:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 */
public class Algorithm106_construct_binary_tree_from_inorder_and_postorder_traversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int indexInInorder = findIndexInArray(inorder, postorder[postorder.length - 1]);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, indexInInorder),
                Arrays.copyOfRange(postorder, 0, indexInInorder));
        if (indexInInorder + 1 < postorder.length) {
            root.right = buildTree(Arrays.copyOfRange(inorder, indexInInorder + 1, inorder.length),
                    Arrays.copyOfRange(postorder, indexInInorder + 1, postorder.length - 1));
        }
        return root;
    }

    private int findIndexInArray(int[] array, int val) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
