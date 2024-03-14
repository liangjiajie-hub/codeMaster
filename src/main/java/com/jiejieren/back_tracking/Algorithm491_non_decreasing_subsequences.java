package com.jiejieren.back_tracking;

import java.io.IOException;
import java.util.*;

/**
 * 491. 非递减子序列
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * 示例 1：
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * 提示：
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */
public class Algorithm491_non_decreasing_subsequences {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (startIndex == nums.length) return;
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (list.size() == 0) {
                list.add(nums[i]);
                set.add(nums[i]);
            } else {
                if (nums[i] >= list.get(list.size() - 1)) {
                    list.add(nums[i]);
                    set.add(nums[i]);
                    result.add(new ArrayList<>(list));
                } else continue;
            }
            backtracking(nums, i + 1);
            list.remove(list.size()  - 1);
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
