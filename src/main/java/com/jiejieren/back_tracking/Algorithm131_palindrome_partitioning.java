package com.jiejieren.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串
 * 。返回 s 所有可能的分割方案。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class Algorithm131_palindrome_partitioning {

    private List<List<String>> result = new ArrayList<>();

    private List<String> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int splitIndex) {
        if (check(s)) {
            if (s.length() >= 1) {
                list.add(s);
                list.remove(list.size() - 1);
            } else {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = splitIndex; i < s.length(); i++) {
            String strPre = s.substring(0, i + 1);
            if (!check(strPre)) continue;
            list.add(strPre);
            backtracking(s.substring(i + 1), 0);
            list.remove(list.size() - 1);
        }
    }

    private boolean check(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i > len - i - 1) break;
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
