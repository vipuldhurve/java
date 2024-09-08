package dsa.intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertNewInterval {
//    You are given an array of non-overlapping intervals where
//    intervals[i] = [start_i, end_i] represents the start and the end time of the ith interval.
//    intervals is initially sorted in ascending order by start_i.

//    You are given another interval newInterval = [start, end].

//    Insert newInterval into intervals
//    such that intervals is still sorted in ascending order by start_i
//    and also intervals still does not have any overlapping intervals.
//    You may merge the overlapping intervals if needed.

//    Return intervals after adding newInterval.

//    Note: Intervals are non-overlapping if they have no common point.
//    For example, [1,2] and [3,4] are non-overlapping, but [1,2] and [2,3] are overlapping.

//    1) 0 <= intervals.length <= 1000
//    2) newInterval.length == intervals[i].length == 2
//    3) 0 <= start <= end <= 1000

//    Time Complexity: O(N)
    private static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};
        ArrayList<int[]> result = new ArrayList<>();
        int index = 0;
        while (index < intervals.length) {
            int[] interval = intervals[index];
            if (interval[1] < newInterval[0]) {
//             2.) None overlapping case: 1
//                    i0---i1
//                               ni0---ni1
                result.add(interval);
            } else if (newInterval[1] < interval[0]) {
//            1.) Non overlapping case: 2
//                                i0---i1
//                    ni0---ni1
                result.add(newInterval);
                break;
            } else {
//                Overlapping case
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            index++;
        }

        if (index < intervals.length) {
//            loop existed before intervals as newInterval cam before some interval
            while (index < intervals.length) result.add(intervals[index++]);
        } else {
//            index would have reached end only if
//            - merged newInterval with last interval in intervals
//            - newInterval comes at end of intervals
            result.add(newInterval);
        }

        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private static void solve(int[][] intervals, int[] newInterval) {
        System.out.println("Intervals:");
        System.out.println(Arrays.deepToString(intervals));
        System.out.println("New Interval:");
        System.out.println(Arrays.toString(newInterval));
        System.out.println("Output:");
        System.out.println(Arrays.deepToString(insertInterval(intervals, newInterval)) + "\n");
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {4, 6}
        };
        int[] newInterval = new int[]{2, 5};
        solve(intervals, newInterval);

        intervals = new int[][]{
                {1, 2},
                {3, 5},
                {9, 10}
        };
        newInterval = new int[]{6, 7};
        solve(intervals, newInterval);

        intervals = new int[][]{
                {2, 5},
                {6, 7},
                {8, 9}
        };
        newInterval = new int[]{0, 1};
        solve(intervals, newInterval);
    }
}
