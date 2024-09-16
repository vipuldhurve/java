package dsa.sorting;

import java.util.Arrays;

public class MergeSort implements Sorting {

    public static void conquer(int[] arr, int start, int mid, int end) {
        int merged[] = new int[end - start + 1];
        int idx1 = start;
        int idx2 = mid + 1;
        int x = 0;
//        Copying elements in merged array and in a sorted manner
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] < arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else {
                merged[x++] = arr[idx2++];
            }
        }
//        Checking for remaining elements and copying them in merged array
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }
        while (idx2 <= end) {
            merged[x++] = arr[idx2++];
        }
//        Copying back sorted elements in original array
        for (int i = 0, j = start; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void divide(int[] arr, int start, int end) {
        if (start >= end) return;
//        divide
        int mid = start + (end - start) / 2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
//        conquer
        conquer(arr, start, mid, end);
    }

    @Override
    public void sort(int[] arr) {
        divide(arr, 0, arr.length - 1);
    }

    private static void solve(int[] input){
        System.out.println("Input: " + Arrays.toString(input));
        Sorting mergeSort = new MergeSort();
        mergeSort.sort(input);
        System.out.println("Ouput: " + Arrays.toString(input) + "\n");
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{2, 1, 4, 3, 6, 5, 8, 7, 9};
        solve(unsorted);

        unsorted = new int[]{5};
        solve(unsorted);

        unsorted = new int[]{};
        solve(unsorted);
    }

}
