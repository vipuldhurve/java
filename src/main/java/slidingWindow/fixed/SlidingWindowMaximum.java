package slidingWindow.fixed;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

//    You are given an array of integers nums,
//    there is a sliding window of size k
//    which is moving from the very left of the array to the very right.
//    You can only see the k numbers in the window.
//    Each time the sliding window moves right by one position.

//    Return the max sliding window.

//    Example 1:
//    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//    Output: [3,3,5,5,6,7]
//    Explanation:
//    Window position                Max
//---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7

    public static int[] solve(int[] arr, int k){
        // Total values in maxSubArray will be n-k+1
        int[] maxSubArrays = new int[arr.length-k+1];
        int i=0;
        int left=0;
        int right=0;

        Deque<Integer> dq = new ArrayDeque<>();

        while(right < arr.length){
            // Calculations - Remove all the smaller elements than current element from deque right i.e. last
            while(!dq.isEmpty() && arr[right]>dq.peekLast()) dq.pollLast();
            dq.offerLast(arr[right]);

            if(right - left + 1 < k){
                right++;
            } else if(right - left + 1 == k){
                //Add max value in ans maxArray - it will be present in left side i.e. first of deque
                maxSubArrays[i++] = dq.peekFirst();
                //remove calculations for left index;
                if(arr[left]==dq.peekFirst()) dq.pollFirst();
                //move window
                left++;
                right++;
            }
        }

        return maxSubArrays;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k=3;
        int maxSubArrays[] = solve(arr, k);
        printArray(maxSubArrays);
    }

    public static void printArray(int[] A){
        for(int a : A){
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

}
