package com.jiejieren.greed;

import java.util.*;

/**
 * 763. 划分字母区间
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * 示例 1：
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * 示例 2：
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 * 提示：
 * 1 <= s.length <= 500
 * s 仅由小写英文字母组成
 */
public class Algorithm763_partition_labels {

    public static List<Integer> partitionLabels(String s) {
        Set<String> set = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            if (!set.contains(letter)) {
                list.add(new int[]{s.indexOf(letter), s.lastIndexOf(letter)});
                set.add(letter);
            }
        }
        List<Integer> result = new ArrayList<>();
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        for (int i = 0; i < list.size() - 1; ) {
            int k = i + 1;
            while (k < list.size() && list.get(k)[0] <= end) {
                end = Math.max(end, list.get(k)[1]);
                k++;
                if (k == list.size()) break;
            }
            result.add(end - start + 1);
            if (k == list.size()) break;
            start = list.get(k)[0];
            end = list.get(k)[1];
            if (k == list.size() - 1) result.add(end - start + 1);
            i = k;
        }
        return result;
    }

    public static void main(String[] args) {
        partitionLabels("eaaaabaaec");
    }
}
