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


    //Time Complexity - nlog(k)
    public static int kthSmallest(int[] arr, int k) {
        //For kth smallest we need a maxHeap for removing elements greater than k
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        Arrays.stream(arr).forEach(el -> {
            maxHeap.add(el);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        });

        return maxHeap.peek();
    }

    //Time Complexity - nlog(k)
    public static int kthLargest(int[] arr, int k) {
        //For kth largest we need a minHeap for removing elements smaller than k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Arrays.stream(arr).forEach(el -> {
            minHeap.add(el);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });

        return minHeap.peek();
    }


    public static void main(String[] args) {
        int[] arr = new int[]{7, 10, 4, 3, 2, 5, 8, 20, 15};
        int[] kValues = new int[]{3, 4};

        Arrays.stream(kValues).forEach(k -> {
            int kthSmallest = kthSmallest(arr, k);
            int kthLargest = kthLargest(arr, k);
            System.out.println("The " + k + "th smallest element is: " + kthSmallest);
            System.out.println("The " + k + "th largest element is: " + kthLargest);
            System.out.println();
        });
    }

}
