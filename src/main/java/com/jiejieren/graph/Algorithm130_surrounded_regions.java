package com.jiejieren.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 130. 被围绕的区域
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 示例 1：
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 */
public class Algorithm130_surrounded_regions {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        // 标记区域是否被访问过
        boolean[][] mark = new boolean[m][n];

        int[][] diff = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // 缓存广度优先搜索当前层的节点的索引
        Deque<Integer> deque1 = new ArrayDeque<>();
        // 缓存相连区域的索引
        Deque<Integer> deque2 = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' || mark[i][j]) continue;
                mark[i][j] = true;
                deque1.addLast(i);
                deque1.addLast(j);
                deque2.addLast(i);
                deque2.addLast(j);
                boolean flag = false;
                while (deque1.size() > 0) {
                    int a = deque1.removeFirst(), b = deque1.removeFirst();
                    for (int k = 0; k < 4; k++) {
                        int indexI = a + diff[k][0];
                        int indexJ = b + diff[k][1];
                        if (indexI >= 0 && indexI < m && indexJ >= 0 && indexJ < n) {
                            if (mark[indexI][indexJ] || board[indexI][indexJ] == 'X') continue;
                            mark[indexI][indexJ] = true;
                            deque1.addLast(indexI);
                            deque1.addLast(indexJ);
                            deque2.addLast(indexI);
                            deque2.addLast(indexJ);
                        } else flag = true;
                    }
                }
                if (!flag) {
                    while (deque2.size() > 0) {
                        int a = deque2.removeFirst(), b = deque2.removeFirst();
                        board[a][b] = 'X';
                    }
                }
                deque2.clear();
            }
        }
    }

    public static void main(String[] args) {

    }
}
