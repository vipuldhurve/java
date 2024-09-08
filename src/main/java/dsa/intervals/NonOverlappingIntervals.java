package dsa.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
//    Given an array of intervals where intervals[i] = [start_i, end_i],
//    return the minimum number of intervals you need to remove
//    to make the rest of the intervals non-overlapping.

//    Note: Intervals are non-overlapping even if they have a common point.
//    For example, [1, 3] and [2, 4] are overlapping,
//    but [1, 2] and [2, 3] are non-overlapping.

//    Input: intervals = [[1,2],[2,4],[1,4]]
//    Output: 1

//    Input: intervals = [[1,2],[2,4]]
//    Output: 0

    //    Time complexity: O(NlogN)
    private static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int count = 0;
        int[] interval = new int[]{intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < interval[1]) {
//                Overlap
//                We keep the interval with minimum end value and remove interval with higher end value
//                because interval with higher end value will have more chances to overlap with next intervals
                interval[1] = Math.min(interval[1], intervals[i][1]);
                count++;
            } else {
//                No Overlap
                interval[0] = intervals[i][0];
                interval[1] = intervals[i][1];
            }
        }

        return count;
    }

    private static void solve(int[][] intervals) {
        System.out.println("Input:");
        System.out.println(Arrays.deepToString(intervals));
        System.out.println("Output:" + eraseOverlapIntervals(intervals) + "\n");
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 2},
                {2, 4},
                {1, 4}
        };
        solve(intervals);

        intervals = new int[][]{
                {1, 2},
                {2, 4}
        };
        solve(intervals);
    }

}
