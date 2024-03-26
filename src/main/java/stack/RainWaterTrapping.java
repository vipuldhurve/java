package stack;

import java.util.Arrays;
import java.util.Stack;

public class RainWaterTrapping {

    // Given n non-negative integers representing an elevation map
    // where the width of each bar is 1,
    // compute how much water it can trap after raining.

    //Example 1
    //Input: 0,1,0,2,1,0,1,3,2,1,2,1
    //Ouput: 6

    //Example 2
    //Input: 4,2,0,3,2,5
    //Output: 9

    public static int rainWaterTrapping(int[] height) {
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

        int[] output = Arrays.stream(input)
                .mapToInt(arr -> rainWaterTrapping(arr))
                .toArray();

        for (int i = 0; i < input.length; i++) {
            System.out.print("Input: ");
            printArray(input[i]);
            System.out.println("Output: " + output[i]);
            System.out.println();
        }
    }

    public static void printArray(int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

}
