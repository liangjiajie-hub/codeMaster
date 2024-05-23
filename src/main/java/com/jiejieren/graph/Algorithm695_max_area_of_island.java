package com.jiejieren.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 695. 岛屿的最大面积
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * 示例 1：
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * 示例 2：
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 */
public class Algorithm695_max_area_of_island {

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] mark = new boolean[m][n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || mark[i][j]) continue;
                deque.addLast(i);
                deque.addLast(j);
                mark[i][j] = true;
                int item = 1;
                while (deque.size() > 0) {
                    int a = deque.removeFirst(), b = deque.removeFirst();
                    if (a - 1 >= 0 && grid[a - 1][b] == 1 && !mark[a - 1][b]) {
                        deque.add(a - 1);
                        deque.add(b);
                        mark[a - 1][b] = true;
                        item++;
                    }
                    if (a + 1 < m && grid[a + 1][b] == 1 && !mark[a + 1][b]) {
                        deque.add(a + 1);
                        deque.add(b);
                        mark[a + 1][b] = true;
                        item++;
                    }
                    if (b - 1 >= 0 && grid[a][b - 1] == 1 && !mark[a][b - 1]) {
                        deque.add(a);
                        deque.add(b - 1);
                        mark[a][b - 1] = true;
                        item++;
                    }
                    if (b + 1 < n && grid[a][b + 1] == 1 && !mark[a][b + 1]) {
                        deque.add(a);
                        deque.add(b + 1);
                        mark[a][b + 1] = true;
                        item++;
                    }
                    result = Math.max(result, item);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
