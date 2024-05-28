package com.jiejieren.graph;

import java.util.Stack;

/**
 * 1020. 飞地的数量
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * 示例 1：
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 */

public class Algorithm1020_number_of_enclaves {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;

        // 标记陆地的状态，0代表未被访问过、1代表被访问过
        int[][] mark = new int[m][n];

        int[][] offsets = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // 记录广度优先遍历每一层的节点
        Stack<Integer> stack1 = new Stack<>();

        // 记录一个陆地区域每一块陆地单元格的下表
        int area = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mark[i][j] == 1 || grid[i][j] == 0) continue;
                mark[i][j] = 1;
                stack1.push(j);
                stack1.push(i);
                area++;
                boolean isOut = false;
                while (stack1.size() > 0) {
                    int a = stack1.pop(), b = stack1.pop();
                    for (int k = 0; k < offsets.length; k++) {
                        int l = a + offsets[k][0], r = b + offsets[k][1];
                        if (!(l < 0 || l >= m || r < 0 || r >= n)) {
                            if (mark[l][r] == 1 || grid[l][r] == 0) continue;
                            mark[l][r] = 1;
                            stack1.push(r);
                            stack1.push(l);
                            area++;
                        } else {
                            isOut = true;
                            continue;
                        }
                    }
                }
                if (!isOut) {
                    result += area;
                }
                area = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
