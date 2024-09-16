package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {
//    You are given an array of integers stones
//    where stones[i] represents the weight of the ith stone.

//    We want to run a simulation on the stones as follows:
//    1. At each step we choose the two heaviest stones,
//    with weight x and y and smash them togethers
//    2. If x == y, both stones are destroyed
//    3. If x < y, the stone of weight x is destroyed,
//    and the stone of weight y has new weight y - x.

//    Continue the simulation until there is no more than one stone remaining.

//    Return the weight of the last remaining stone or return 0 if none remain.

//    Input: stones = [2,3,6,2,4]
//    Output: 1

//    Input: stones = [1,2]
//    Output: 1

    private static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int stone : stones) maxHeap.offer(stone);
        while (maxHeap.size() > 1) {

            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
//            Case1 : If stone1 = stone2, remove them as they get destroyed
//            Case 2: If stone1 weight > stone2, new stone is added
//            with weight = stone1 - stone2
            if (stone1 > stone2) maxHeap.offer(stone1 - stone2);
        }
        if (!maxHeap.isEmpty()) return maxHeap.peek();
        return 0;
    }

    public static void main(String[] args) {
        int[][] stones = {
                {2, 3, 6, 2, 4},
                {1, 2}
        };

        Arrays.stream(stones)
                .peek(el -> System.out.println("INPUT: " + Arrays.toString(el)))
                .map(LastStoneWeight::lastStoneWeight)
                .forEach(el -> System.out.println("OUTPUT: " + el + "\n"));
    }
}
