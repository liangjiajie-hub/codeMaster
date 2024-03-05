package com.jiejieren.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * 提示：
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
public class Algorithm454_four_sum_count {

    // 暴力法 O(n4)
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int result = 0;

        // 保存数组中每个值出现的次数
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();
        Map<Integer, Integer> map4 = new HashMap<>();

        // 数组长度
        int n = nums1.length;

        for (int i = 0; i < n; i++) {
            Integer times1 = map1.getOrDefault(nums1[i], 0);
            map1.put(nums1[i], ++times1);
            Integer times2 = map2.getOrDefault(nums2[i], 0);
            map2.put(nums2[i], ++times2);
            Integer times3 = map3.getOrDefault(nums3[i], 0);
            map3.put(nums3[i], ++times3);
            Integer times4 = map4.getOrDefault(nums4[i], 0);
            map4.put(nums4[i], ++times4);
        }

        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
                for (Map.Entry<Integer, Integer> entry3 : map3.entrySet()) {
                    for (Map.Entry<Integer, Integer> entry4 : map4.entrySet()) {
                        if (entry1.getKey() + entry2.getKey() + entry3.getKey() + entry4.getKey() == 0) {
                            result += entry1.getValue() * entry2.getValue() * entry3.getValue() * entry4.getValue();
                        }
                    }
                }
            }
        }
        return result;
    }

    public static int fourSumCountByOn2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int sum = num1 + num2;
                Integer times = map.getOrDefault(sum, 0);
                map.put(sum, ++times);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                result += map.getOrDefault(-(num3 + num4), 0);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
