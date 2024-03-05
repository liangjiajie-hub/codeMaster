package com.jiejieren.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * 简单
 * 相关标签
 * 相关企业
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class Algorithm383_ransom_note {

    public static boolean canConstruct(String ransomNote, String magazine) {
        // magazine字符串长度
        int n = magazine.length();

        // ransomNote字符串长度
        int m = ransomNote.length();

        // 哈希map，key代表字母，value代表字母出现的次数
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String letter = String.valueOf(magazine.charAt(i));
            Integer times = map.getOrDefault(letter, 0);
            map.put(letter, ++times);
        }

        for (int i = 0; i < m; i++) {
            String letter = String.valueOf(ransomNote.charAt(i));
            Integer times = map.getOrDefault(letter, 0);
            if (times == 0) return false;
            map.put(letter, --times);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
