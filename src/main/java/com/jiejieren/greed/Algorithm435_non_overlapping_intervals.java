package com.jiejieren.greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. 无重叠区间
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * 示例 1:
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * 提示:
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 */
public class Algorithm435_non_overlapping_intervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        int result = 0;
        boolean[] removed = new boolean[intervals.length];
        for (int i = 0; i < intervals.length - 1; ) {
            if (removed[i]) {
                i++;
                continue;
            }
            int k = i + 1;
            while (k < intervals.length - 1 && removed[k]) {
                k++;
            }
            if (removed[k]) break;
            if (intervals[i][0] == intervals[k][0]) {
                result++;
                removed[i] = true;
                i++;
            } else if (intervals[i][1] > intervals[k][0]) {
                result++;
                if (intervals[i][1] < intervals[k][1]) {
                    removed[k] = true;
                } else {
                    removed[i] = true;
                    i++;
                }
            } else i++;
        }
        return result;
    }

    // 代码随想录解法
    public static int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
    }
}

