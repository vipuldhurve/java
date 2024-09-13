package dsa.heap;

import java.util.*;

public class TaskScheduler {
//    You are given an array of CPU tasks,
//    each represented by letters A to Z, and a cooling time, n.

//    Each cycle or interval allows the completion of one task.

//    Tasks can be completed in any order, but there's a constraint:
//    identical tasks must be separated by at least n intervals due to cooling time.

//    Return the minimum number of intervals required to complete all tasks.

//    Example 1:
//    Input: tasks = ["A","A","A","B","B","B"], n = 2
//    Output: 8
//    Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

//    Example 2:
//    Input: tasks = ["A","C","A","B","D","B"], n = 1
//    Output: 6
//    Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

//    Example 3:
//    Input: tasks = ["A","A","A", "B","B","B"], n = 3
//    Output: 10
//    Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.


    //    TIME COMPLEXITY: O(NlogN) |  SPACE COMPLEXITY: O(N)   for N is tasks
    private static int leastInterval(char[] tasks, int n) {
//        Count of each task
        Map<Character, Integer> countMap = new HashMap<>();
        for (char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }

//        maxHeap for getting task with higher count
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

//        Add all tasks count in maxHeap
        for (Map.Entry<Character, Integer> taskEntry : countMap.entrySet()) {
            maxHeap.offer(new int[]{taskEntry.getKey(), taskEntry.getValue()});
        }

//        For keeping a task once processed
//        We can just store there remaining task-count and there next-idle-time
//        But if we need to print the task order we can store the task
//        [task, task-count, next-idle-Time]
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
//            If time is greater than next-idle -time for peek task in queue
//            Add it to maxHeap to process
            if (!queue.isEmpty() && time >= queue.peek()[2]) {
//               taskDetails = [task, task-count, next-idle-Time]
                int[] taskDetails = queue.poll();
                maxHeap.offer(new int[]{taskDetails[0], taskDetails[1]});
            }

//            Process peek task from maxHeap
            if (!maxHeap.isEmpty()) {
//                Reduce task count
//                taskDetails = [task, task-count]
                int[] taskDetails = maxHeap.poll();
                int remainingCount = taskDetails[1] - 1;
                System.out.print((char) taskDetails[0] + " ");
//                If task count is not zero than add it to queue to process it later
//                Calculate next idle time to process the task as currentTime + n + 1
                if (remainingCount > 0) {
                    queue.offer(new int[]{taskDetails[0], remainingCount, time + n + 1});
                }
            } else {
                System.out.print("# ");
            }
            time++;
        }
        return time;
    }

    private static void solve(char[] tasks, int n) {
        System.out.println("INPUT: " + Arrays.toString(tasks) + "   n = " + n);
        System.out.print("OUTPUT: ");
        int leastTime = leastInterval(tasks, n);
        System.out.println("\nTIME = " + leastTime + "\n");
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        solve(tasks, n);

        tasks = new char[]{'A', 'C', 'A', 'B', 'D', 'B'};
        n = 1;
        solve(tasks, n);

        tasks = new char[]{'A', 'A', 'A', 'B', 'C'};
        n = 3;
        solve(tasks, n);

        tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        n = 3;
        solve(tasks, n);
    }
}
