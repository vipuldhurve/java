package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortKSortedArray {
//    Geeks For Geeks ------------
//    Given an array of N elements,
//    where each element is at most K away from its target position,
//    devise an algorithm that sorts in O(N log K) time.

//    Input: arr[] = {6, 5, 3, 2, 8, 10, 9}, K = 3
//    Output: arr[] = {2, 3, 5, 6, 8, 9, 10}

//    Input: arr[] = {10, 9, 8, 7, 4, 70, 60, 50}, k = 4
//    Output: arr[] = {4, 7, 8, 9, 10, 50, 60, 70}


    //Time Complexity - nlog(k)
    public static int[] sortKSorted(int[] arr, int k) {
        //For kth largest we need a minHeap for removing elements smaller than k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] sorted = new int[arr.length];
        int x=0;
        for (int i=0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k){
                sorted[x++] = minHeap.poll();
            }
        }

        while (minHeap.size()>0) {
            sorted[x] = minHeap.poll();
            x++;
        }
        return sorted;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {6, 5, 3, 2, 8, 10, 9},
                {10, 9, 8, 7, 4, 70, 60, 50}
        };
        int[] kValues = new int[]{3, 4};

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Input: " + Arrays.toString(arr[i]) +" and k = " +kValues[i]);
            System.out.println("Output: " + Arrays.toString(sortKSorted(arr[i], kValues[i])));
            System.out.println();
        }

    }

}
