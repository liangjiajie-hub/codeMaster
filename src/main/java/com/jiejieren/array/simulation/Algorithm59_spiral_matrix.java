package com.jiejieren.array.simulation;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * 中等
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * 提示：
 * 1 <= n <= 20
 */
public class Algorithm59_spiral_matrix {
    public static int[][] generateMatrix(int n) {

        // 边界：左、上、右、下
        int[] bounds = {0, 0, n - 1, n - 1};

        // 偏移量：+1 +1 -1 -1（与边界一一对应，每走完一条边加一次偏移）
        int[] offsets = {1, 1, -1, -1};

        // 结果矩阵
        int[][] matrix = new int[n][n];

        // 记录每一次循环起始边界，除以4取余得到起始边界值的索引，循环一次则加1
        int count = 0;

        // 矩阵起始值
        int val = 1;
        while (val <= n * n) {

            // 边的固定行下标或者列下标值得索引
            int boundsMidIndex = (count + 1) % 4;

            // 起始边界和结束边界值的索引
            int boundsLeftIndex = count % 4;
            int boundsRightIndex = (count + 2) % 4;


            if (bounds[boundsLeftIndex] < bounds[boundsRightIndex]) {
                for (int i = bounds[boundsLeftIndex]; i <= bounds[boundsRightIndex]; i++) {
                    if (boundsMidIndex % 2 != 0) matrix[bounds[boundsMidIndex]][i] = val;
                    else matrix[i][bounds[boundsMidIndex]] = val;
                    val++;
                }
            } else {
                for (int i = bounds[boundsLeftIndex]; i >= bounds[boundsRightIndex]; i--) {
                    if (boundsMidIndex % 2 != 0) matrix[bounds[boundsMidIndex]][i] = val;
                    else matrix[i][bounds[boundsMidIndex]] = val;
                    val++;
                }
            }
            bounds[boundsMidIndex] += offsets[boundsMidIndex];
            count++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] matrix = generateMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
