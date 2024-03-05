package com.jiejieren.hash_table;

import java.util.*;

/**
 * 15. 三数之和
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 提示：
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Algorithm15_three_sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 返回结果集合
        List<List<Integer>> result = new ArrayList<>();
        // 数组长度
        int n = nums.length;
        // 升序
        Arrays.sort(nums);
        // HashSet去重
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 1; i < n - 1; i++) {
            int left = 0;
            int right = n - 1;
            while (left < i && right > i) {
                if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else {
                    // 如果第i个元素和i-1个元素相等，那么left就必须为i-1才不和之前的重复
                    if (nums[i] == nums[i - 1] && nums[left] != nums[i]) {
                        left++;
                        right--;
                        continue;
                    }
                    // 如果第i个元素和i-2个元素相等，那么不论何种情况此次都是重复的结果
                    if (i - 2 >= 0 && nums[i] == nums[i - 2]) {
                        left++;
                        right--;
                        continue;
                    }
                    // 如果这次的和上次的list元素一致，则为重复的list
                    if (result.size() != 0 &&
                            nums[left] == result.get(result.size() - 1).get(0) &&
                            nums[i] == result.get(result.size() - 1).get(1) &&
                            nums[right] == result.get(result.size() - 1).get(2)) {
                        left++;
                        right--;
                        continue;
                    }
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4});
    }
}
