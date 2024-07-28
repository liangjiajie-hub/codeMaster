package com.jiejieren.hot_100;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
// TODO I didn't pass by myself
public class Algorithm560_subarray_sum_equals_k {

    // public int subarraySum(int[] nums, int k) {
    //     int result = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         int sum = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             sum += nums[j];
    //             if (sum == k) result++;
    //         }
    //     }
    //     return result;
    // }

    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(pre, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                result += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return result;
    }
}
