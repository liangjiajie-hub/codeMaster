package com.jiejieren.dp;

/**
 * 516. 最长回文子序列
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 */
public class Algorithm516_longest_palindromic_subsequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        int result = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, Math.max(dp[i + 1][j], dp[i][j - 1]));
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                result = Math.max(dp[i][j], result);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
