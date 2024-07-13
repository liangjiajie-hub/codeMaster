package com.jiejieren.hot_100;

import java.util.*;

/**
 * 128. 最长连续序列
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
// TODO I didn't pass by myself
public class Algorithm128_longest_consecutive_sequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (Integer item : set) {
            if (!set.contains(item - 1)) {
                int currentResult = 1;
                int currentNum = item + 1;
                while (set.contains(currentNum)) {
                    currentResult++;
                    currentNum++;
                }
                result = Math.max(currentResult, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result = longestConsecutive(new int[]{-3,2,8,5,1,7,-8,2,-8,-4,-1,6,-6,9,6,0,-7,4,5,-4,8,2,0,-2,-6,9,-4,-1});
        System.out.println(result);
    }
}
