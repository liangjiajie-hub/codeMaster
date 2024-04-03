package com.jiejieren.dp;

import java.util.Arrays;

public class Algorithm279_perfect_squares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) return 1;
        for (int i = 1; i < n; i++) {
            for (int j = (int) Math.pow(i, 2); j <= n; j++) {
                if (j - (int) Math.pow(i, 2) == 0) dp[j] = 1;
                else {
                    if(dp[j] == 0) {
                        if(dp[j - (int) Math.pow(i, 2)] != 0) dp[j] = dp[j - (int) Math.pow(i, 2)] + 1;
                    } else {
                        if(dp[j - (int) Math.pow(i, 2)] != 0) dp[j] = Math.min(dp[j], dp[j - (int) Math.pow(i, 2)] + 1);;
                    }
                }
            }
        }
        return dp[n];
    }

    // 代码随想录解法
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i ; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i ] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
