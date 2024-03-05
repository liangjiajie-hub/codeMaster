package com.jiejieren.string.kmp;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 459. 重复的子字符串
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
// TODO I didn't pass by myself
public class Algorithm459_repeated_substring_pattern {

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len == 0) return false;
        char[] charArray = s.toCharArray();
        int[] next = getNext(charArray);
        return next[len - 1] != 0 && len % (len - next[len - 1]) == 0;
    }

    private static int[] getNext(char[] array) {
        int[] next = new int[array.length];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && array[i] != array[j]) {
                j = next[j - 1];
            }
            if (array[i] == array[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern(new String("abcabcabc")));
    }
}
