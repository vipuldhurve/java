package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextPermutation {
//    A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

//    For example, for arr = [1,2,3],
//    the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
//    The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
//    More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
//    then the next permutation of that array is the permutation that follows it in the sorted container.

//    If such arrangement is not possible,
//    the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

//    For example, the next permutation of arr = [1,2,3] is [1,3,2].
//    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
//    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

//    Given an array of integers nums, find the next permutation of nums.

//    The replacement must be in place and use only constant extra memory

    static class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    // TIME COMPLEXITY: O(N + NlogN)   |   SPACE COMPLEXITY: O(N)
    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        Stack<Node> stack = new Stack<>();
        int i = n - 1;

        while (i >= 0) {
            if (!stack.isEmpty() && stack.peek().val > nums[i]) {
                int swapIndex = stack.pop().index;
                // find greater element to current element with the highest possible index
                while (!stack.isEmpty() && stack.peek().val > nums[i]) swapIndex = stack.pop().index;
                // swap
                int temp = nums[i];
                nums[i] = nums[swapIndex];
                nums[swapIndex] = temp;
                // sort sub array from i+1 to n
                Arrays.sort(nums, i + 1, n);
                return;
            }
            // store current element and index
            stack.push(new Node(nums[i], i));
            i--;
        }
        // If no possible permutation found return sorted array
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 3},
                {2, 3, 1},
                {3, 2, 1},
                {1, 3, 1, 2, 2, 4},
                {1, 3, 1, 2, 2}
        };

        Arrays.stream(input)
                .peek(i -> System.out.println("INPUT: " + Arrays.toString(i)))
                .forEach(i -> {
                    nextPermutation(i);
                    System.out.println("OUTPUT: " + Arrays.toString(i) + "\n");
                });
    }
}
