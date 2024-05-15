package com.jiejieren.monotonous_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 42. 接雨水
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */

public class Algorithm42_trapping_rain_water {

    /**
     * 核心思路：每个元素入单调栈时计算与栈中最后一个大于等于它的元素（若没有则选择栈中最大的元素）围成的区域能够接到的雨水
     * ，并在计算的过程中减去这个范围内以每一个元素结尾围成的区域能够接到的雨水（去除重复计算的雨水）
     */
    public int trap(int[] height) {
        int n = height.length;
        int result;
        int[] subTrap = new int[n];

        // 单调栈
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.size() == 0) {
                stack.push(i);
            } else {
                int right = i;
                int left = i;
                while (stack.size() > 0) {
                    int peek = stack.peek();
                    left = peek;
                    if (height[peek] < height[i]) {
                        stack.pop();
                    } else break;
                }
                stack.push(i);
                if (right - left >= 2) {
                    int trap = Math.min(height[left], height[right]) * (right - left - 1);
                    for (int j = left + 1; j < right; j++) {
                        trap -= height[j] + subTrap[j];
                    }
                    subTrap[i] = trap;
                }
            }
        }
        return Arrays.stream(subTrap).sum();

    }

    public static void main(String[] args) {

    }
}
