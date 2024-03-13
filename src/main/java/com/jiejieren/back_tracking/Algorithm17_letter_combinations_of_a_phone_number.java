package com.jiejieren.back_tracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Algorithm17_letter_combinations_of_a_phone_number {

    private Map<String, String> map = new HashMap<>();

    private List<String> result = new ArrayList<>();

    private StringBuilder item = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        backtracking(digits, 0);
        return result;
    }

    private void backtracking(String digits, int startIndex) {
        if (item.length() == digits.length()) {
            if (item.length() > 0) result.add(new String(item));
            return;
        }
        String letters = map.get(String.valueOf(digits.charAt(startIndex)));
        for (int j = 0; j < letters.length(); j++) {
            item.append(letters.charAt(j));
            backtracking(digits, startIndex + 1);
            item.deleteCharAt(item.length() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
