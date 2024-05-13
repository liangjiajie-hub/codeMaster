package com.jiejieren.monotonous_stack;

import java.util.Stack;

/**
 * 739. 每日温度
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * 提示：
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class Algorithm739_daily_temperatures {

    // 暴力解法（面向测试用例编程！！！）
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && temperatures[i] == temperatures[i - 1]) {
                result[i] = result[i - 1] > 0 ? result[i - 1] - 1 : result[i - 1];
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    // TODO 单调栈，代码随想录解法
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.size() == 0) {
                stack.push(i);
            } else {
                while (stack.size() > 0) {
                    int peek = stack.peek();
                    if (temperatures[peek] < temperatures[i]) {
                        stack.pop();
                        result[peek] = i - peek;
                    } else break;
                }
                stack.push(i);
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
