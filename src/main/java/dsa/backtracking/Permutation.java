package dsa.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
//    Given an array nums of unique integers,
//    return all the possible permutations.
//    You may return the answer in any order.

//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

//    Input: nums = [7]
//    Output: [[7]]

    //    TIME COMPLEXITY : O(N*N!)
//    SPACE COMPLEXITY: O(N*N!)
//    Recursive Call Stack Space: O(N)
//    Auxiliary Space for Intermediate Computation: O(N)
    private static List<List<Integer>> permute(int[] nums) {
//        List to store permutations of array
        List<List<Integer>> result = new ArrayList<>();
//        If only 1 element
        if (nums.length == 1) {
            List<Integer> singleNum = new ArrayList<>();
            singleNum.add(nums[0]);
            result.add(singleNum);
            return result;
        }
//        Find permutation of array if size > 1
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
//            Fix one element
            int[] remainingNums = new int[nums.length - 1];
            int idx = 0;
//            Create array of remaining elements
            for (int j = 0; j < nums.length; j++) {
                if (j != i) remainingNums[idx++] = nums[j];
            }
//            Recursively find permutations of remaining elements
            List<List<Integer>> perms = permute(remainingNums);
//            Add currentNum to all permutations
            for (List<Integer> perm : perms) {
                perm.add(currentNum);
//                Add permutation to result
                result.add(perm);
            }
        }

        return result;
    }


    //    TIME COMPLEXITY : O(N*N!)
//    SPACE COMPLEXITY: O(N*N!)
//    Recursive Call Stack Space: O(N)
//    Auxiliary Space for Intermediate Computation: O(N)
    private static List<List<Integer>> sortedPermute(int[] nums) {
//        Sort the input array to ensure permutations are generated in lexicographical order
        Arrays.sort(nums);
        List<List<Integer>> sortedResult = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        sortedPermuteBacktrack(nums, permutation, used, sortedResult);
        return sortedResult;
    }

    private static void sortedPermuteBacktrack(int[] nums, List<Integer> permutation, boolean[] used, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            Skip used elements
            if (used[i]) continue;
//            Add element in permutation and mark used
            permutation.add(nums[i]);
            used[i] = true;
//            Recursively build rest of the permutation
            sortedPermuteBacktrack(nums, permutation, used, result);
//            Backtrack: remove nums[i] and mark it as unused
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 3},
                {7}
        };
        Arrays.stream(input)
                .peek(i -> System.out.println("INPUT: " + Arrays.toString(i)))
                .forEach(i -> {
                    List<List<Integer>> permutations = permute(i);
                    System.out.println("Permutations: " + permutations);
                    List<List<Integer>> sortedPermutations = sortedPermute(i);
                    System.out.println("Sorted Permutations: " + sortedPermutations + "\n");
                });
    }

}
