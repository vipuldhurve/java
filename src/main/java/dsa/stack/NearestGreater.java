package dsa.stack;

import java.util.Stack;

public class NearestGreater {

    public static int[] nearestGreaterToRight(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] ngRight = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            //Find answer from dsa.stack
            if (s.isEmpty()) {
                ngRight[i] = -1;
            } else if (!s.isEmpty() && s.peek() > arr[i]) {
                ngRight[i] = s.peek();
            } else if (!s.isEmpty() && s.peek() <= arr[i]) {
                //Remove elements from dsa.stack until you find a greater element than current element
                while (!s.isEmpty() && s.peek() <= arr[i]) {
                    s.pop();
                }
                //Get answer from dsa.stack
                if (s.isEmpty()) {
                    ngRight[i] = -1;
                } else {
                    ngRight[i] = s.peek();
                }
            }
            //At last push current element in dsa.stack
            s.push(arr[i]);
        }
        return ngRight;
    }

    public static int[] nearestGreaterToLeft(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] ngLeft = new int[n];

        for (int i = 0; i < n; i++) {
            //Find answer from dsa.stack
            if (s.isEmpty()) {
                ngLeft[i] = -1;
            } else if (!s.isEmpty() && s.peek() > arr[i]) {
                ngLeft[i] = s.peek();
            } else if (!s.isEmpty() && s.peek() <= arr[i]) {
                //Remove elements from dsa.stack until you find a greater element than current element
                while (!s.isEmpty() && s.peek() <= arr[i]) {
                    s.pop();
                }
                //Get answer from dsa.stack
                if (s.isEmpty()) {
                    ngLeft[i] = -1;
                } else {
                    ngLeft[i] = s.peek();
                }
            }
            //At last push current element in dsa.stack
            s.push(arr[i]);
        }

        return ngLeft;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 2, 3, 5};
        System.out.print("Input: ");
        printArray(arr);
        System.out.print("Nearest greater to right: ");
        printArray(nearestGreaterToRight(arr));
        System.out.print("Nearest greater to left: ");
        printArray(nearestGreaterToLeft(arr));
    }

    public static void printArray(int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

}
