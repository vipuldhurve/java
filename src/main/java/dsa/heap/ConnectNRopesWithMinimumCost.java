package dsa.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectNRopesWithMinimumCost {
//    Geeks For Geeks ------------------------
//    Given are N ropes of different lengths,
//    the task is to connect these ropes into one rope with minimum cost,
//    such that the cost to connect two ropes is equal to the sum of their lengths.

//    arr[] = {4,3,2,6} , N = 4
//    Output: 29

//    Input: arr[] = {1, 2, 3} , N = 3
//    Output: 9


    // Using MinHeap
    // Time Complexity - O(N*log(N))
    // Space: O(N)

    // Approach: If we observe the above problem closely,
    // we can notice that the lengths of the ropes which are picked first
    // are included more than once in the total cost.
    // Therefore, the idea is to connect the smallest two ropes first
    // and recur for the remaining ropes. This approach is similar to Huffman Coding.
    // We put the smallest ropes down the tree, so they can be repeated multiple times
    // rather than the longer ones.
    public static int connectRopes(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : arr) minHeap.add(x);

        while (minHeap.size() > 1) {
            int first = minHeap.poll(), second = minHeap.poll();
            minHeap.add(first + second);
        }
        return minHeap.peek();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }

        String t = sc.nextLine();
        System.out.println(t);

        printArray(a);

//        int[][] arr = new int[][]{
//                {4, 3, 2, 6},
//                {1, 2, 3}
//        };

//        int[] result = Arrays.stream(arr).mapToInt(el -> connectRopes(el)).toArray();
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print("Input: ");
//            printArray(arr[i]);
//            System.out.println("Minimum Cost for adding ropes: " + result[i]);
//            System.out.println();
//        }
    }

    public static void printArray(int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

}
