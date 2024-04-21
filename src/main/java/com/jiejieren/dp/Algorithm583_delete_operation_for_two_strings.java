package com.jiejieren.dp;

/**
 * 583. 两个字符串的删除操作
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 * 示例 1：
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * 示例  2:
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 * 提示：
 * 1 <= word1.length, word2.length <= 500
 * word1 和 word2 只包含小写英文字母
 */
public class Algorithm583_delete_operation_for_two_strings {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return m + n - maxLen * 2;
    }

    public static void main(String[] args) {

    }
}
