package slidingWindow.fixed;

public class MaxSumInKSizeWindow {
    //All integers in array are positive

    public static int solve(int[] arr, int k){
        int left=0;
        int right=0;
        int maxSum=0;
        int sum=0;
        while(right<arr.length){
            sum = sum + arr[right];
            if(right - left + 1 < k){
                right++;
            } else if(right - left + 1 == k){
                maxSum = Math.max(sum, maxSum);
                sum = sum - arr[left];
                left++;
                right++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 8, 2, 9, 1};
        int k=3;
        System.out.println("Max sum in window size " + k + " is "+solve(arr,k));
    }

}
