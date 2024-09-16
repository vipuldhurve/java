package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {
//    Given an integer array nums of unique elements, return all possible
//    subsets(the power set).

//    The solution set must not contain duplicate subsets. Return the solution in any order.

//    Example 1:
//    Input: nums = [1,2,3]
//    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

//    Example 2:
//    Input: nums = [0]
//    Output: [[],[0]]

    static List<List<Integer>> powerSet;

    private static void findSubsets(int[] nums, int i, List<Integer> sub) {
        if (i >= nums.length) {
            powerSet.add(new ArrayList<>(sub));
            return;
        }
//        include i element
        sub.add(nums[i]);
        findSubsets(nums, i + 1, sub);
        sub.remove(sub.size() - 1);
//        not include i element
        findSubsets(nums, i + 1, sub);
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][]{
                {1, 2, 3},
                {0}
        };
        Arrays.stream(inputs)
                .peek(i -> System.out.println("INPUT: " + Arrays.toString(i)))
                .forEach(i -> {
                    powerSet = new ArrayList<>();
                    findSubsets(i, 0, new ArrayList<>());
                    System.out.println("OUTPUT: " + powerSet.toString() + "\n");
                });
    }
}

