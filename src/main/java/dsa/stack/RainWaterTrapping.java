package dsa.stack;

import java.util.Arrays;

public class RainWaterTrapping {

//     Given n non-negative integers representing an elevation map
//     where the width of each bar is 1,
//     compute how much water it can trap after raining.

//    Example 1
//    Input: 0,1,0,2,1,0,1,3,2,1,2,1
//    Ouput: 6

//    Example 2
//    Input: 4,2,0,3,2,5
//    Output: 9

    //    TIME COMPLEXITY: O(N)   |   SPACE COMPLEXITY: O(N)
    public static int rainWaterTrapped(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // No matter what, we can't store water on edge buildings
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        //Calculate water stored at each index where arr[i] is height of building
        for (int i = 0; i < n; i++) {
            height[i] = Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        int water = Arrays.stream(height).sum();
        return water;
    }


    public static void main(String[] args) {
        int[][] input = new int[][]{
                {3, 0, 0, 2, 0, 4},
                {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
                {4, 2, 0, 3, 2, 5}
        };

        Arrays.stream(input)
                .peek(i -> System.out.println("INPUT: " + Arrays.toString(i)))
                .mapToInt(arr -> rainWaterTrapped(arr))
                .forEach(o -> System.out.println("RAIN WATER TRAPPED: " + o + "\n"));
    }

}
