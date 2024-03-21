package com.jiejieren.greed;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1005. K 次取反后最大化的数组和
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * 示例 1：
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 * 提示：
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 */
public class Algorithm1005_maximize_sum_of_array_after_K_negations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        if (k == 0) return sum;
        if (k % 2 != 0) {
            Arrays.sort(nums);
            sum -= nums[0] * 2;
        }
        return sum;
    }

    public int largestSumAfterKNegations2(int[] nums, int k) {
        int sum = 0;
        nums = IntStream
                .of(nums)
                .boxed()
                .sorted((a, b) -> Math.abs(b) - Math.abs(a))
                .mapToInt(Integer::intValue)
                .toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) nums[nums.length - 1] *= -1;
        return Arrays.stream(nums).reduce(0, Integer::sum);
    }


    public static void main(String[] args) {

    }
}
