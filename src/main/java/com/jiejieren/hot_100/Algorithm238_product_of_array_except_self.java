package com.jiejieren.hot_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 238. 除自身以外数组的乘积
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * 提示：
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 */
public class Algorithm238_product_of_array_except_self {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Map<String, Integer> map = new HashMap<>();
        int multiLeft = 1;
        int multiRight = 1;
        for (int i = 1, j = nums.length - 2; i < nums.length && j >= 0; i++, j--) {
            multiLeft *= nums[i - 1];
            multiRight *= nums[j + 1];
            map.put("left" + i, multiLeft);
            map.put("right" + j, multiRight);
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.getOrDefault("left" + i, 1) * map.getOrDefault("right" + i, 1);
        }
        return result;
    }


    // O(1) 空间复杂度
    public int[] productExceptSelfOptimizeSpace(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int multiLeft = 1;
        int multiRight = 1;
        for (int i = 1, j = nums.length - 2; i < nums.length && j >= 0; i++, j--) {
            multiLeft *= nums[i - 1];
            multiRight *= nums[j + 1];
            result[i] *= multiLeft;
            result[j] *= multiRight;
        }
        return result;
    }
}
