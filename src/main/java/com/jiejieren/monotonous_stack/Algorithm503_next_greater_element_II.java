package com.jiejieren.monotonous_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * 示例 1:
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * 提示:
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
public class Algorithm503_next_greater_element_II {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        // 结果数组
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);

        // 单调栈
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < 2 * n) {
            int index = i % n;
            if (stack.size() == 0) stack.push(index);
            else {
                while (stack.size() > 0) {
                    int peek = stack.peek();
                    if (nums[peek] < nums[index]) {
                        result[peek] = result[peek] != Integer.MAX_VALUE ? result[peek] : nums[index];
                        stack.pop();
                    } else break;
                }
                stack.push(index);
            }
            i++;
        }
        for (int j = 0; j < n; j++) {
            if (result[j] == Integer.MAX_VALUE) result[j] = -1;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
