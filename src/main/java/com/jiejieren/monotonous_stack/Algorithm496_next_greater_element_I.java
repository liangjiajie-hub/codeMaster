package com.jiejieren.monotonous_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Algorithm496_next_greater_element_I {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // 最终结果
        int[] result = new int[m];
        // key：nums2中的元素，value：nums2中右侧第一个比key大的元素
        Map<Integer, Integer> map = new HashMap<>();
        // 单调栈
        Stack<Integer> monotonousStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (monotonousStack.size() == 0) monotonousStack.push(nums2[i]);
            else {
                while (monotonousStack.size() > 0) {
                    int peek = monotonousStack.peek();
                    if (peek < nums2[i]) {
                        map.put(peek, nums2[i]);
                    } else break;
                    monotonousStack.pop();
                }
                monotonousStack.push(nums2[i]);
            }
        }
        for (int i = 0; i < m; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
