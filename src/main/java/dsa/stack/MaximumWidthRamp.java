package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumWidthRamp {
//    A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j].
//    The width of such a ramp is j - i.

//    Given an integer array nums, return the maximum width of a ramp in nums.
//    If there is no ramp in nums, return 0.

//    Example 1:
//    Input: nums = [6,0,8,2,1,5]
//    Output: 4
//    Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.

//    Example 2:
//    Input: nums = [9,8,1,0,1,9,4,0,4,1]
//    Output: 7
//    Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.

    static class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    // TIME COMPLEXITY: O(N)    |    SPACE COMPLEXITY: O(N)
    private static int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Node> stack = new Stack<>();
        // 6 0 8 2 1 5
        // 0 1 2 3 4 5
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < stack.peek().val) stack.push(new Node(nums[i], i));
        }
        // Stack will store all possible starting points for finding maxWidth
        // stack = (6,0)  (0,1)
        int maxWidth = 0;
        int i = n - 1;
        while (!stack.isEmpty() && i >= 0) {
            if (nums[i] >= stack.peek().val) {
                maxWidth = Math.max(i - stack.peek().index, maxWidth);
                stack.pop();
            } else i--;
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {6, 0, 8, 2, 1, 5},
                {9, 8, 1, 0, 1, 9, 4, 0, 4, 1}
        };

        Arrays.stream(input)
                .peek(i -> System.out.println("INPUT: " + Arrays.toString(i)))
                .forEach(i -> System.out.println("OUTPUT: " + maxWidthRamp(i) + "\n"));
    }
}
