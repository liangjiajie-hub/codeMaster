package com.jiejieren.dp.tree_dp;

import com.jiejieren.util.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 337. 打家劫舍 III
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * 示例 1:
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 示例 2:
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * 提示：
 * 树的节点数在 [1, 104] 范围内
 * 0 <= Node.val <= 104
 */
// TODO I didn't pass by myself
public class Algorithm337_house_robber_III {

    // 代码随想录树状dp
    public int rob(TreeNode root) {
        int[] result = robTreeDP(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robTreeDP(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = robTreeDP(root.left);
        int[] right = robTreeDP(root.right);

        // 选当前节点
        int val1 = left[1] + right[1] + root.val;
        // 不选当前节点
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{val1, val2};
    }

    public static void main(String[] args) {

    }
}
