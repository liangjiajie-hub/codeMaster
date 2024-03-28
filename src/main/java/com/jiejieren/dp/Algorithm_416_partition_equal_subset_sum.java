package com.jiejieren.dp;

import java.util.stream.IntStream;

/**
 * 416. 分割等和子集
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
// TODO I didn't pass by myself
public class Algorithm_416_partition_equal_subset_sum {

    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).boxed().reduce(0, Integer::sum);
        if (sum % 2 != 0) return false;
        int[] dp = new int[sum / 2 + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i >= nums[0]) dp[i] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= 1; j--) {
                dp[j] = Math.max(dp[j], j - nums[i] >= 0 ? dp[j - nums[i]] + nums[i] : 0);
            }
        }
        return dp[dp.length - 1] == dp.length - 1;
    }

    public boolean canPartition2(int[] nums) {
        int sum = IntStream.of(nums).boxed().reduce(0, Integer::sum);
        if (sum % 2 != 0) return false;
        int[][] dp = new int[nums.length][sum / 2 + 1];
        for (int i = 1; i < dp[0].length; i++) {
            if (i >= nums[0]) dp[0][i] = nums[0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], j - nums[i] >= 0 ? dp[i - 1][j - nums[i]] + nums[i] : 0);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1] == dp[0].length - 1;
    }

    public static void main(String[] args) {

    }
}
