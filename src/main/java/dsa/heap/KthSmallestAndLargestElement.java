package dsa.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestAndLargestElement {
//    Geeks For Geeks -----------------------------
//    Given an array arr[] of size N and a number K,
//    where K is smaller than the size of the array.
//    Find the Kth smallest and largest element in the given array.
//    Given that all array elements are distinct.

//    Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 3
//    Output: 7

//    Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 4
//    Output: 10


    //    Time Complexity - N*log(K)
    public static int kthSmallest(int[] nums, int k) {
//        For kth smallest we need a maxHeap for removing elements greater than k
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        Arrays.stream(nums).forEach(el -> {
            maxHeap.add(el);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        });

        return maxHeap.peek();
    }

    //    Time Complexity - N*log(K)
    public static int kthLargest(int[] nums, int k) {
//        For kth largest we need a minHeap for removing elements smaller than k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Arrays.stream(nums).forEach(el -> {
            minHeap.add(el);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });

        return minHeap.peek();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{7, 10, 4, 3, 2, 5, 8, 20, 15};
        int[] kValues = new int[]{3, 4};
        System.out.println("Input: " + Arrays.toString(nums) + "\n");
        Arrays.stream(kValues)
                .forEach(k -> {
                    int kthSmallest = kthSmallest(nums, k);
                    int kthLargest = kthLargest(nums, k);
                    System.out.println(k + "th smallest element: " + kthSmallest + "\n" +
                            k + "th largest element: " + kthLargest + "\n");
                });
    }

}
