package com.jiejieren.string.kmp;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * 简单
 * 相关标签
 * 相关企业
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * 提示：
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class Algorithm28_find_the_index_of_the_first_occurrence_in_a_string {

    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        for (int i = 0; i < next.length; i++) {
            for (int k = 0; k < i; k++) {
                boolean flag = true;
                for (int j = 0; j <= k; j++) {
                    if (needle.charAt(j) != needle.charAt(i - k + j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    next[i] = Math.max(next[i], k + 1);
                }
            }
        }
        int i = 0;
        int j = 0;
        while (haystack.length() != i && needle.length() != j) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                if (j == 0) i++;
                while (j != 0) {
                    j = next[j - 1];
                    if (haystack.charAt(i) == needle.charAt(j)) {
                        i++;
                        j++;
                        break;
                    } else {
                        if (j == 0) {
                            i++;
                            break;
                        }
                    }
                }
            } else {
                i++;
                j++;
            }
        }
        if (i <= haystack.length() && j == needle.length()) return i - needle.length();
        return -1;
    }

    // 根据代码随想录题解优化产生next数组的时间复杂度
    public int strStr2(String haystack, String needle) {
        int[] next = getNext(needle);
        int i = 0;
        int j = 0;
        while (haystack.length() != i && needle.length() != j) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                if (j == 0) i++;
                while (j != 0) {
                    j = next[j - 1];
                    if (haystack.charAt(i) == needle.charAt(j)) {
                        i++;
                        j++;
                        break;
                    } else {
                        if (j == 0) {
                            i++;
                            break;
                        }
                    }
                }
            } else {
                i++;
                j++;
            }
        }
        if (i <= haystack.length() && j == needle.length()) return i - needle.length();
        return -1;
    }

    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int j = 0;
        next[0] = j;
        for (int i = 1; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {

    }
}
