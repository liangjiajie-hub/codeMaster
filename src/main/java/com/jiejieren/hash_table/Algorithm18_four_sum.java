package com.jiejieren.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * 提示：
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class Algorithm18_four_sum {

    // 双指针法
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 最终返回结果
        List<List<Integer>> result = new ArrayList<>();
        // 数组长度
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[0] > target) return result;
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j - 1 >= i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long miss = (long) target - nums[i] - nums[j];
                    if (nums[left] + nums[right] > miss) right--;
                    else if (nums[left] + nums[right] < miss) left++;
                    else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        list.add(nums[i]);
                        right--;
                        left++;
                        // 去重
                        if (result.size() > 0 && list.get(0).equals(result.get(result.size() - 1).get(0)) &&
                                list.get(1).equals(result.get(result.size() - 1).get(1)) &&
                                list.get(2).equals(result.get(result.size() - 1).get(2)) &&
                                list.get(3).equals(result.get(result.size() - 1).get(3))) continue;
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSumOptimize(int[] nums, int target) {
        // 最终返回结果
        List<List<Integer>> result = new ArrayList<>();
        // 数组长度
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[0] > target) return result;
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j - 1 >= i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long miss = (long) target - nums[i] - nums[j];
                    if (nums[left] + nums[right] > miss) right--;
                    else if (nums[left] + nums[right] < miss) left++;
                    else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        list.add(nums[i]);
                        // 去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000}, 294967296));

    }
}
