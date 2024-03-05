package com.jiejieren.stack_and_queue;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class Algorithm347_top_k_frequent_elements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>(map.entrySet());
        arrayList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = 0; i < k; i++) {
            result[i] = arrayList.get(i).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
    }
}
