package com.jiejieren.string;

/**
 * 541. 反转字符串 II
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class Algorithm541_reverse_string_2 {

    public String reverseStr(String s, int k) {
        // 字符串长度
        int n = s.length();
        // 得到字符数组
        char[] charArray = s.toCharArray();
        // 计数，每次循环的起始反转点
        int count = 0;
        while (count < n) {
            int left = count;
            int right = count + k - 1 < n ? count + k - 1 : n - 1;
            while (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
            count = count + 2 * k;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {

    }
}
