package dsa.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
//    Given an array of intervals where intervals[i] = [start_i, end_i],
//    merge all overlapping intervals, and return an array of the non-overlapping intervals
//    that cover all the intervals in the input.

//    You may return the answer in any order.

//    Note: Intervals are non-overlapping if they have no common point.
//    For example, [1, 2] and [3, 4] are non-overlapping,
//    but [1, 2] and [2, 3] are overlapping.

//    Input: intervals = [[1,3],[1,5],[6,7]]
//    Output: [[1,5],[6,7]]

//    Input: intervals = [[1,2],[2,3]]
//    Output: [[1,3]]

    //    Time Complexity: O(NlogN)
    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        ArrayList<int[]> result = new ArrayList<>();
        int[] interval = new int[]{intervals[0][0], intervals[0][1]};
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= interval[1]) {
//                Overlap
                interval[1] = Math.max(interval[1], intervals[i][1]);
            } else {
//                No Overlap
                result.add(new int[]{interval[0], interval[1]});
                interval[0] = intervals[i][0];
                interval[1] = intervals[i][1];
            }
        }
        result.add(interval);

        int[][] nonOverlappingIntervals = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            nonOverlappingIntervals[i] = result.get(i);
        }

        return nonOverlappingIntervals;
    }

    private static void solve(int[][] intervals) {
        System.out.println("Input:");
        System.out.println(Arrays.deepToString(intervals));
        System.out.println("Output:");
        System.out.println(Arrays.deepToString(merge(intervals)) + "\n");
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {1, 5},
                {6, 7}
        };
        solve(intervals);

        intervals = new int[][]{
                {1, 2},
                {2, 3}
        };
        solve(intervals);
    }

}
