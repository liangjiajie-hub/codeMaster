package com.jiejieren.dp;

public class Algorithm115_distinct_subsequences {

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        long[][] dp = new long[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1L;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return (int) (dp[m][n] % (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {
        numDistinct("babgbag", "bag");
    }
}
