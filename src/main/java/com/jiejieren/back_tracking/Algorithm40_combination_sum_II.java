package com.jiejieren.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm40_combination_sum_II {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) continue;
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            backtracking(candidates, target, i + 1, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
