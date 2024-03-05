package com.jiejieren.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 239. 滑动窗口最大值
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
// TODO I didn't pass by myself
public class Algorithm239_sliding_window_maximum {

    // 单调队列
    static class MonotonicQueue {

        public Deque<Integer> deque;

        public MonotonicQueue() {
            this.deque = new ArrayDeque<>();
        }

        public void pop(int value) {
            if (Integer.valueOf(value).equals(deque.getFirst())) {
                deque.pop();
            }
        }

        public void push(int value) {
            while (!deque.isEmpty() && deque.getLast() < value) {
                deque.pollLast();
            }
            if (deque.isEmpty() || deque.getLast() >= value) {
                deque.addLast(value);
            }
        }

        public int peek() {
            return deque.getFirst();
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        for (int i = 0; i < k; i++) {
            monotonicQueue.push(nums[i]);
        }
        result[0] = monotonicQueue.peek();
        int start = 0, end = k - 1;
        while (end < nums.length - 1) {
            monotonicQueue.pop(nums[start]);
            start++;
            end++;
            monotonicQueue.push(nums[end]);
            result[start] = monotonicQueue.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
