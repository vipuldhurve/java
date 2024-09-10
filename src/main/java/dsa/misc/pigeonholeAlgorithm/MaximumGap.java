package dsa.misc.pigeonholeAlgorithm;

import java.util.Arrays;

public class MaximumGap {
//    Given an integer array nums,
//    return the maximum difference between two successive elements in its sorted form.
//    If the array contains less than two elements, return 0.

//    NOTE: You must write an algorithm that runs in linear time and uses linear extra space.
//    i.e. WITHOUT SORTING ARRAY

//    Example 1:
//    Input: nums = [3,6,9,1]
//    Output: 3

//    Example 2:
//    Input: nums = [10]
//    Output: 0

    //    PIGEON-HOLE PRINCIPLE
//    TIME COMPLEXITY: O(N)
//    SPACE COMPLEXITY: O(N)
    private static int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int max = nums[0], min = nums[0];
//        Find max and min in array
        for (int element : nums) {
            max = Math.max(max, element);
            min = Math.min(min, element);
        }

//        We create N-1 buckets for N-2(excluding max and min) elements in array
//        Range/size of each bucket will be ceil of -> range(max-min)/no of buckets
        int bucketSize = (int) Math.ceil((double) (max - min) / (n - 1));

        int[] maxOfBucket = new int[n - 1];
        int[] minOfBucket = new int[n - 1];
        Arrays.fill(maxOfBucket, Integer.MIN_VALUE);
        Arrays.fill(minOfBucket, Integer.MAX_VALUE);

//        We calculate max and min value for each bucket
//        Exclude max and min from calculation as we do not store them in any bucket
        for (int element : nums) {
//            Ignore max and min element
            if (element == max || element == min) continue;
//            Bucket index for element = (element - min)/bucketSize
            int bucketIndexOfCurrentElement = (element - min) / bucketSize;
//            Update max and min of bucket
            maxOfBucket[bucketIndexOfCurrentElement] =
                    Math.max(element, maxOfBucket[bucketIndexOfCurrentElement]);
            minOfBucket[bucketIndexOfCurrentElement] =
                    Math.min(element, minOfBucket[bucketIndexOfCurrentElement]);
        }

//        Max gap will be = MIN of current bucket -  MAX of previous bucket
        int maxGap = 0;
        int maxOfPreviousBucket = min;
        for (int i = 0; i < maxOfBucket.length; i++) {
//            If bucket is empty - ignore
            if (maxOfBucket[i] == Integer.MIN_VALUE) continue;
//            Find max gap
            maxGap = Math.max(maxGap, minOfBucket[i] - maxOfPreviousBucket);
//            Make current bucket max as min
            maxOfPreviousBucket = maxOfBucket[i];
        }

        maxGap = Math.max(maxGap, max - maxOfPreviousBucket);
        return maxGap;
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][]{
                {3, 6, 9, 1},
                {10}
        };

        Arrays.stream(inputs)
                .peek(i -> System.out.println("Input: " + Arrays.toString(i)))
                .map(MaximumGap::maximumGap)
                .forEach(o -> System.out.println("Output: " + o + "\n"));
    }
}
