package com.jiejieren.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
 * 示例 1：
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 示例 2：
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 * 提示：
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 105
 */
public class Algorithm417_pacific_atlantic_water_flow {

    private int[][] diff = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] po = new int[m][n];
        int[][] ao = new int[m][n];

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            po[0][i] = 1;
            dfs(heights, po, 0, i);
            ao[m - 1][i] = 1;
            dfs(heights, ao, m - 1, i);
        }
        for (int j = 0; j < m; j++) {
            po[j][0] = 1;
            dfs(heights, po, j, 0);
            ao[j][n - 1] = 1;
            dfs(heights, ao, j, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ao[i][j] == 1 && po[i][j] == 1) {
                    result.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int[][] mark, int indexI, int indexJ) {
        int m = heights.length;
        int n = heights[0].length;

        for (int k = 0; k < 4; k++) {
            int a = indexI + diff[k][0], b = indexJ + diff[k][1];
            if (a < 0 || a == m || b < 0 || b == n) continue;
            if (mark[a][b] == 1) continue;
            if (heights[a][b] >= heights[indexI][indexJ]) {
                mark[a][b] = 1;
                dfs(heights, mark, a, b);
            }
        }
    }

    public static void main(String[] args) {

    }
}
