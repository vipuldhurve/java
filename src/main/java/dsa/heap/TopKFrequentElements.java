package dsa.heap;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
//    Leetcode 347 -------------------------------
//    Given an integer array nums and an integer k,
//    return the k most frequent elements.
//    You may return the answer in any order.

//    Example 1
//    Input: nums = [1,1,1,2,2,3], k = 2
//    Output: [1,2]

//    Example 2
//    Input: nums = [1], k = 1
//    Output: [1]

    static class Element {
        int freq;
        int val;

        Element(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }


    public static int[] kFrequent(int[] arr, int k) {
        //Creating a map of elements and there frequency
        Map<Integer, Integer> m = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toMap(
                        x -> x,
                        x -> 1,
                        Integer::sum
                ));

        //Comparator for comparing elements based on frequency
        Comparator<Element> elFrequencyComparator = Comparator.comparingInt(e -> e.freq);

        //To remove elements with frequency lower we need minHeap;
        PriorityQueue<Element> minHeap = new PriorityQueue<>(elFrequencyComparator);

        for (int x : m.keySet()) {
            minHeap.add(new Element(x, m.get(x)));
            if (minHeap.size() > k) minHeap.poll();
        }

        //Getting answer from minHeap
        int[] kFrequent = new int[minHeap.size()];
        int i = 0;
        while (minHeap.size() > 0) {
            kFrequent[i++] = minHeap.poll().val;
        }

        return kFrequent;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println("Input: " + Arrays.toString(arr) + "  k = " + k);
        System.out.println("Output: " + Arrays.toString(kFrequent(arr, k)));
        System.out.println();

        arr = new int[]{1};
        k = 1;
        System.out.println("Input: " + Arrays.toString(arr) + "  k = " + k);
        int[] a = kFrequent(arr, k);
        System.out.println("Output: " + Arrays.toString(kFrequent(arr, k)));
        System.out.println();
    }

    public static void printArray(int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }
}
