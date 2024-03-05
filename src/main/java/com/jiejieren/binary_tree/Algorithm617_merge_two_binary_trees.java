package com.jiejieren.binary_tree;

import com.jiejieren.util.tree.binary.TreeNode;

import java.util.Stack;

/**
 * 617. 合并二叉树
 * 简单
 * 相关标签
 * 相关企业
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 * 示例 1：
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * 示例 2：
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 * 提示：
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -104 <= Node.val <= 104
 */
public class Algorithm617_merge_two_binary_trees {

    private Stack<TreeNode> stack1 = new Stack<>();
    private Stack<TreeNode> stack2 = new Stack<>();

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = null;
        if (root1 == null && root2 == null) return null;
        if (root1 != null && root2 != null) {
            root = root1;
            root1.val += root2.val;
            stack1.push(root1);
            stack2.push(root2);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
            stack1.pop();
            stack2.pop();
        } else {
            if (root1 != null) root = root1;
            if (root2 != null) root = root2;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
