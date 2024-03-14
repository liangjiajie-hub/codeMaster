package com.jiejieren.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Algorithm78_subsets {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<Integer>());
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<Integer>(list));
            backtracking(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
