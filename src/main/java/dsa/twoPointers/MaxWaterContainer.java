package dsa.twoPointers;

import java.util.Arrays;

public class MaxWaterContainer {

//    You are given an integer array heights where heights[i]
//    represents the height of the (i)th bar.
//    You may choose any two bars to form a container.
//    Return the maximum amount of water a container can store.

//    Input: height = [1,7,2,5,4,7,3,6]
//    Output: 36

//    Input: height = [2,2,2]
//    Output: 4

    public static int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
//        Initialize ans with min possible water amount
        int ans = 0;

        while(left < right){
//            Amount of water between left and right as height will be of smaller pole
            int currAmount = Math.min(heights[left], heights[right]) * (right-left);
//            Taking max from current Amount and ans
            ans = Math.max(ans, currAmount);
//            We move towards the pole with greater height
//            Moving either pointer towards each other will reduce the width
//            as we have calculated the max possible amount with the current smaller pole.
//            For a greater possible answer with a smaller width we choose greater pole
//            and do smaller pole pointer ++;
            if(heights[right] > heights[left]) left++;
            else right--;
        }
        return ans;
    }

    public static void solve(int[] heights){
        System.out.println("Input: " + Arrays.toString(heights));
        System.out.println("Output: " + maxArea(heights));
        System.out.println();
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1,7,2,5,4,7,3,6};
        solve(heights);

        heights = new int[]{2,2,2};
        solve(heights);
    }
}
