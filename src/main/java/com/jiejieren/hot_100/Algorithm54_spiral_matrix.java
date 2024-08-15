package com.jiejieren.hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Algorithm54_spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] range = new int[]{0, 0, matrix[0].length - 1, matrix.length - 1};
        int[] offset = new int[]{1, 1, -1, -1};
        List<Integer> result = new ArrayList<>();
        int incre = 0;
        while (true) {
            if (incre % 4 == 0) {
                for (int i = range[0]; i <= range[2]; i++) {
                    result.add(matrix[range[1]][i]);
                }
                range[1] += offset[1];
            } else if (incre % 4 == 1) {
                for (int i = range[1]; i <= range[3]; i++) {
                    result.add(matrix[i][range[2]]);
                }
                range[2] += offset[2];
            } else if (incre % 4 == 2) {
                for (int i = range[2]; i >= range[0]; i--) {
                    result.add(matrix[range[3]][i]);
                }
                range[3] += offset[3];
            } else {
                for (int i = range[3]; i >= range[1]; i--) {
                    result.add(matrix[i][range[0]]);
                }
                range[0] += offset[0];
            }
            incre++;
            if (result.size() >= matrix.length * matrix[0].length) break;
        }
        return result;
    }
}