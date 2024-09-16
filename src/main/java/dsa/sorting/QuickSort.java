package dsa.sorting;

import java.util.Arrays;

public class QuickSort implements Sorting {
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pi = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                pi++;
                //swap
                int temp = arr[pi];
                arr[pi] = arr[j];
                arr[j] = temp;
            }
        }
        //Putting pivot in correct position
        pi++;
        int temp = arr[pi];
        arr[pi] = pivot;
        arr[end] = temp;
        return pi;
    }

    public void helper(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIdx = partition(arr, start, end);
            //sorting rest of the parts after putting pivot in correct position
            helper(arr, start, pivotIdx - 1);
            helper(arr, pivotIdx + 1, end);
        }
    }

    @Override
    public void sort(int[] arr) {
        helper(arr, 0, arr.length - 1);
    }

    private static void solve(int[] input){
        System.out.println("Input: " + Arrays.toString(input));
        Sorting quickSort = new QuickSort();
        quickSort.sort(input);
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
