package stack;

import java.util.Stack;

public class NearestSmaller {

    public static int[] nearestSmallerToRight(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] nsRight = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            //Find answer from stack
            if (s.isEmpty()) {
                nsRight[i] = -1;
            } else if (!s.isEmpty() && s.peek() < arr[i]) {
                nsRight[i] = s.peek();
            } else if (!s.isEmpty() && s.peek() >= arr[i]) {
                //Remove elements from stack until you find a smaller element than current element
                while (!s.isEmpty() && s.peek() >= arr[i]) {
                    s.pop();
                }
                //Get ans from stack
                if (s.isEmpty()) {
                    nsRight[i] = -1;
                } else {
                    nsRight[i] = s.peek();
                }
            }
            //At last push current element in stack
            s.push(arr[i]);
        }
        return nsRight;
    }

    public static int[] nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] nsLeft = new int[n];

        for (int i = 0; i < n; i++) {
            //Find answer from stack
            if (s.isEmpty()) {
                nsLeft[i] = -1;
            } else if (!s.isEmpty() && s.peek() < arr[i]) {
                nsLeft[i] = s.peek();
            } else if (!s.isEmpty() && s.peek() >= arr[i]) {
                //Remove elements from stack until you find a smaller element than current element
                while (!s.isEmpty() && s.peek() >= arr[i]) {
                    s.pop();
                }
                //Get answer from stack
                if (s.isEmpty()) {
                    nsLeft[i] = -1;
                } else {
                    nsLeft[i] = s.peek();
                }
            }
            //At last push current element in stack
            s.push(arr[i]);
        }

        return nsLeft;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 1, 5, 6};
        System.out.print("Input: ");
        printArray(arr);
        System.out.print("Nearest smaller to right: ");
        printArray(nearestSmallerToRight(arr));
        System.out.print("Nearest smaller to left: ");
        printArray(nearestSmallerToLeft(arr));
    }

    public static void printArray(int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

}
