package dsa.intervals;

import java.util.*;

public class MeetingSchedule {

//    Given an array of meeting time interval objects consisting of start and end times
//    [[start_1,end_1],[start_2,end_2],...] (start_i < end_i),
//    find the minimum number of days required to schedule all meetings without any conflicts.

//    Input: intervals = [(0,40),(5,10),(15,20)]
//    Output: 2
//    day1: (0,40)
//    day2: (5,10),(15,20)

//    Input: intervals = [(4,9)]
//    Output: 1

    //    Time Complexity: O(NlogN)  |  Space Complexity: O(N) where N is no. of intervals
    private static int meetingSchedule(int[][] intervals) {
//        Sort the intervals according to start time to find overlaps
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
//        Keep on removing intervals from queue until overlap is found
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        int days = 0;
        for (int[] interval : intervals) {
//            Keep on removing intervals from queue that don't overlap
            while (!minHeap.isEmpty() && !(interval[0] < minHeap.peek()[1])) minHeap.poll();
            minHeap.add(interval);
            days = Math.max(minHeap.size(), days);
        }
        return days;
    }

    private static void solve(int[][] intervals) {
        System.out.println("Input:");
        System.out.println(Arrays.deepToString(intervals));
        System.out.println("Output:" + meetingSchedule(intervals) + "\n");
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {0, 30},
                {5, 10},
                {15, 20}
        };
        solve(intervals);

        intervals = new int[][]{
                {1, 18},
                {18, 23},
                {15, 29},
                {4, 15},
                {2, 11},
                {5, 13}
        };
        solve(intervals);

        intervals = new int[][]{
                {0, 40},
                {5, 10},
                {15, 20}
        };
        solve(intervals);

        intervals = new int[][]{
                {4, 9}
        };
        solve(intervals);

        intervals = new int[][]{
                {2, 6},
                {3, 6},
                {1, 4},
                {5, 7}
        };
        solve(intervals);

        intervals = new int[][]{
                {2, 6},
                {1, 4},
                {5, 7}
        };
        solve(intervals);
    }
}


