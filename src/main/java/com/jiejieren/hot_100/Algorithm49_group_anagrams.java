package com.jiejieren.hot_100;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * 49. 字母异位词分组
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class Algorithm49_group_anagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] freq = new int[26];
            for (int j = 0; j < str.length(); j++) {
                freq[str.charAt(j) - 'a']++;
            }
            StringBuilder freqStr = new StringBuilder();
            for (int k : freq) {
                freqStr.append(k);
                freqStr.append(",");
            }
            List<String> list = map.getOrDefault(freqStr.toString(), new ArrayList<>());
            list.add(str);
            map.put(freqStr.toString(), list);
        }
        map.forEach((key, value) -> result.add(value));
        return result;
    }


    public static void main(String[] args) throws InterruptedException {
        List<List<String>> list = groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
        new CountDownLatch(1).await();
    }
}
