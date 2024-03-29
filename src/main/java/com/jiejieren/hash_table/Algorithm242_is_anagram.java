package com.jiejieren.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 简单
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Algorithm242_is_anagram {

    public static boolean isAnagram(String s, String t) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            Integer times = map.getOrDefault(letter, 0);
            map.put(String.valueOf(s.charAt(i)), ++times);
        }
        for (int i = 0; i < t.length(); i++) {
            String letter = String.valueOf(t.charAt(i));
            Integer times = map.getOrDefault(letter, 0);
            map.put(String.valueOf(t.charAt(i)), --times);
        }
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if (item.getValue() != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
