package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmaller {

    //    TIME COMPLEXITY: O(N)   |   SPACE COMPLEXITY: O(N)
    public static int[] nearestSmallerToRight(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] nsRight = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            //Find answer from dsa.stack
            if (s.isEmpty()) {
                nsRight[i] = -1;
            } else if (!s.isEmpty() && s.peek() < arr[i]) {
                nsRight[i] = s.peek();
            } else if (!s.isEmpty() && s.peek() >= arr[i]) {
                //Remove elements from dsa.stack until you find a smaller element than current element
                while (!s.isEmpty() && s.peek() >= arr[i]) {
                    s.pop();
                }
                //Get ans from dsa.stack
                if (s.isEmpty()) {
                    nsRight[i] = -1;
                } else {
                    nsRight[i] = s.peek();
                }
            }
            //At last push current element in dsa.stack
            s.push(arr[i]);
        }
        return nsRight;
    }

    //    TIME COMPLEXITY: O(N)   |   SPACE COMPLEXITY: O(N)
    public static int[] nearestSmallerToLeft(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] nsLeft = new int[n];

        for (int i = 0; i < n; i++) {
            //Find answer from dsa.stack
            if (s.isEmpty()) {
                nsLeft[i] = -1;
            } else if (!s.isEmpty() && s.peek() < arr[i]) {
                nsLeft[i] = s.peek();
            } else if (!s.isEmpty() && s.peek() >= arr[i]) {
                //Remove elements from dsa.stack until you find a smaller element than current element
                while (!s.isEmpty() && s.peek() >= arr[i]) {
                    s.pop();
                }
                //Get answer from dsa.stack
                if (s.isEmpty()) {
                    nsLeft[i] = -1;
                } else {
                    nsLeft[i] = s.peek();
                }
            }
            //At last push current element in dsa.stack
            s.push(arr[i]);
        }

        return nsLeft;
    }

    private static void solve(int[] input){
        System.out.println("INPUT: " + Arrays.toString(input));
        System.out.println("Nearest smaller to right: " + Arrays.toString(nearestSmallerToRight(input)));
        System.out.println("Nearest smaller to left: " + Arrays.toString(nearestSmallerToLeft(input)) +"\n");
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 5, 1, 5, 6};
        solve(input);
    }

}
