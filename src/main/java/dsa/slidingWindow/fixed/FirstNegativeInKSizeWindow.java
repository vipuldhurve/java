package dsa.slidingWindow.fixed;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInKSizeWindow {

    public static int[] solve(int[] arr, int k){
        // Total values in firstNegatives will be n-k+1
        int[] firstNegatives = new int[arr.length-k+1];
        int i=0;
        int left=0;
        int right=0;

        Queue<Integer> q = new LinkedList<>();

        while(right < arr.length){
            // if negative found added in q
            if(arr[right]<0) q.add(arr[right]);

            if(right - left + 1 < k){
                right++;
            } else if(right - left + 1 == k){
                if(q.isEmpty()){
                    firstNegatives[i++]=0;
                } else{
                    firstNegatives[i++]=q.peek();
                    if(arr[left] < 0) q.poll();
                }
                left++;
                right++;
            }
        }

        return firstNegatives;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k=3;
        int firstNegatives[] = solve(arr, k);
        printArray(firstNegatives);
    }

    public static void printArray(int[] A){
        for(int a : A){
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

}
