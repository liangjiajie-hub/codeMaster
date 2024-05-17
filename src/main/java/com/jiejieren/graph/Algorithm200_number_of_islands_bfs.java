package com.jiejieren.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 200. 岛屿数量
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class Algorithm200_number_of_islands_bfs {

    private int result = 0;

    private boolean[][] mark;

    public int numIslands(char[][] grid) {

        int m = grid.length, n = grid[0].length;
        mark = new boolean[m][n];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || mark[i][j]) continue;
                result++;
                deque.addLast(i);
                deque.addLast(j);
                mark[i][j] = true;
                while (deque.size() > 0) {
                    int a = deque.removeFirst(), b = deque.removeFirst();
                    if (a - 1 >= 0 && grid[a - 1][b] == '1' && !mark[a - 1][b]) {
                        mark[a - 1][b] = true;
                        deque.addLast(a - 1);
                        deque.addLast(b);
                    }
                    if (a + 1 < m && grid[a + 1][b] == '1' && !mark[a + 1][b]) {
                        mark[a + 1][b] = true;
                        deque.addLast(a + 1);
                        deque.addLast(b);
                    }
                    if (b - 1 >= 0 && grid[a][b - 1] == '1' && !mark[a][b - 1]) {
                        mark[a][b - 1] = true;
                        deque.addLast(a);
                        deque.addLast(b - 1);
                    }
                    if (b + 1 < n && grid[a][b + 1] == '1' && !mark[a][b + 1]) {
                        mark[a][b + 1] = true;
                        deque.addLast(a);
                        deque.addLast(b + 1);
                    }
                }
            }
        }
        return result;
    }
}
