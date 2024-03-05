package com.jiejieren.array.slide_window;

/**
 * 209. 长度最小的子数组
 * 中等
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */
public class Algorithm209_smallest_length_subarray {
    /**
     * 滑动窗口
     * 本质上是找出每一个以终止位置结尾的满足条件的最短子数组长度，比较并取得最小值
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum >= target) {
                while (i <= j) {
                    if (sum - nums[i] >= target) {
                        sum -= nums[i];
                    } else {
                        result = Math.min(result, j - i + 1);
                        break;
                    }
                    i++;
                }
            }
        }
        return Integer.MAX_VALUE != result ? result : 0;
    }

    public static void main(String[] args) {
        int result = minSubArrayLen(15, new int[]{1, 2, 3, 4, 5});
        System.out.println("result = " + result);
    }
}
