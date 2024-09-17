package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreater {

    //    TIME COMPLEXITY: O(N)   |   SPACE COMPLEXITY: O(N)
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

    //    TIME COMPLEXITY: O(N)   |   SPACE COMPLEXITY: O(N)
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

    private static void solve(int[] input){
        System.out.println("INPUT: " + Arrays.toString(input));
        System.out.println("Nearest greater to right: " + Arrays.toString(nearestGreaterToRight(input)));
        System.out.println("Nearest greater to left: " + Arrays.toString(nearestGreaterToLeft(input)) +"\n");
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 5, 1, 2, 3, 5};
        solve(input);
    }

}
