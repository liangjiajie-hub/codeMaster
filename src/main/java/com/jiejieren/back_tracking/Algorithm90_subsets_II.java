package com.jiejieren.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
 * 子集
 * （幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class Algorithm90_subsets_II {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> list = new ArrayList<Integer>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i - 1] == nums[i]) continue;
            list.add(nums[i]);
            result.add(new ArrayList<Integer>(list));
            backtracking(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
