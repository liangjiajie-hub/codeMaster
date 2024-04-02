package com.jiejieren.dp;

/**
 * 322. 零钱兑换
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 提示：
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class Algorithm322_coin_change {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        if (amount == 0) return 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (j == coins[i]) dp[j] = 1;
                else {
                    if (dp[j - coins[i]] != 0) {
                        if (dp[j] != 0) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                        else dp[j] = dp[j - coins[i]] + 1;
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {

    }
}
