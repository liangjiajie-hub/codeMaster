package com.jiejieren.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 202. 快乐数
 * 简单
 * 相关标签
 * 相关企业
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * 提示：
 * 1 <= n <= 231 - 1
 */
public class Algorithm202_is_happy {

    public static boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(n, n);
        while (true) {
            n = getPosSqrtSum(n);
            if (n == 1) {
                return true;
            }
            if (map.get(n) != null) {
                return false;
            }
            map.put(n, n);
        }
    }

    // 获取一个正整数每个位置上的平方和
    private static int getPosSqrtSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
