package dsa.array;

import java.util.Arrays;

public class FindDuplicateInteger {
//    You are given an array of integers nums containing n + 1 integers.
//    Each integer in nums is in the range [1, n] inclusive.

//    Every integer appears exactly once,
//    except for one integer which appears two or more times.
//    Return the integer that appears more than once.

//    NOTE: Solve the problem without modifying the array nums
//    and using O(1) extra space

//    Input: nums = [1,2,3,2,2]
//    Output: 2

//    Input: nums = [1,2,3,4,4]
//    Output: 4

    //    TIME COMPLEXITY: O(N)   |   SPACE COMPLEXITY: O(1)
    private static int findDuplicate(int[] nums) {
        // We will ensure that
        // each number in array should be present in nums[number]
        while (true) {
            // Let the number at 0th index be temp
            int temp = nums[0];
            // So temp should be present at nums[temp]
            // If not swap it
            if (temp != nums[temp]) {
                nums[0] = nums[temp];
                nums[temp] = temp;
            }
            // If it is present already in numZero'th position
            // We have a duplicate of numZero
            else return temp;
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 3, 2, 2},
                {1, 2, 3, 4, 4}
        };

        Arrays.stream(input)
                .peek(i -> System.out.println("INPUT: " + Arrays.toString(i)))
                .map(FindDuplicateInteger::findDuplicate)
                .forEach(o -> System.out.println("OUTPUT: " + o + "\n"));
    }
}
