package com.jiejieren.back_tracking;


import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 中等
 * 相关标签
 * 相关企业
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 提示：
 * 1 <= s.length <= 20
 * s 仅由数字组成
 */
public class Algorithm93_restore_IP_addresses {

    private List<String> result = new ArrayList<>();

    private StringBuilder str = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 1);
        return result;
    }

    private void backtracking(String s, int splitIndex, int depth) {
        if (depth == 4) {
            if (s.length() > 3 || s.length() == 0 || Integer.parseInt(s) > 255 || (s.charAt(0) == '0' && s.length() > 1)) return;
            result.add(str.append(s).toString());
            str.delete(str.length() - s.length(), str.length());
            return;
        }
        for (int i = splitIndex; i < s.length(); i++) {
            String preStr = s.substring(0, i + 1);
            if (preStr.length() > 3 || Integer.parseInt(preStr) > 255 || (preStr.charAt(0) == '0' && preStr.length() > 1)) continue;
            str.append(preStr);
            str.append(".");
            backtracking(s.substring(i + 1), 0, depth + 1);
            str.delete(str.length() - preStr.length() - 1, str.length());
        }
    }

    public static void main(String[] args) {

    }
}
