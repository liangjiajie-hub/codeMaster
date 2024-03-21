package com.jiejieren.greed;

public class Algorithm45_jump_game_II {

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int result = 0;
        for (int i = 0; i < nums.length - 1;) {
            if (nums[i] > 0) {
                result++;
                int next = i;
                if (i + nums[i] >= nums.length - 1) break;
                for (int j = i + 1; j <= i + nums[i] && j < nums.length - 1; j++) {
                    if (next + nums[next] <= j + nums[j]) {
                        next = j;
                    }
                }
                i = next;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
