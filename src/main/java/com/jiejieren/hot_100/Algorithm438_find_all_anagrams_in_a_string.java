package com.jiejieren.hot_100;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 提示:
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
// TODO I didn't pass by myself
public class Algorithm438_find_all_anagrams_in_a_string {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (pLen > sLen) return result;
        int[] freqArray = new int[26];
        for (int i = 0; i < pLen; i++) {
            freqArray[p.charAt(i) - 'a']++;
        }
        int[] currentFreqArray = new int[26];
        for (int i = 0; i < pLen; i++) {
            currentFreqArray[s.charAt(i) - 'a']++;
        }
        if (checkFreq(freqArray, currentFreqArray)) result.add(0);
        int left = 0, right = pLen - 1;
        while (++right < sLen) {
            currentFreqArray[s.charAt(left) - 'a']--;
            currentFreqArray[s.charAt(right) - 'a']++;
            left++;
            if (checkFreq(freqArray, currentFreqArray)) result.add(left);
        }
        return result;
    }

    private static boolean checkFreq(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
