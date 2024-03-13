package com.jiejieren.back_tracking;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Algorithm77_combine {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1, new ArrayList<>());
        return result;
    }

    private void backtracking(int n, int k, int index, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            backtracking(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    // 代码随想录题解剪枝优化
    private void backtracking2(int n, int k, int index, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtracking2(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
