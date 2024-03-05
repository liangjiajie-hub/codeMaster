package com.jiejieren.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 349. 两个数组的交集
 * 简单
 * 相关标签
 * 相关企业
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class Algorithm349_array_intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : nums2) {
            Integer times = map.getOrDefault(i, 0);
            map.put(i, ++times);
        }
        for (int j : nums1) {
            Integer times = map.getOrDefault(j, 0);
            if (times != 0) {
                arrayList.add(j);
                map.put(j, 0);
            }
        }
        int size = arrayList.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
