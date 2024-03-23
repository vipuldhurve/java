package slidingWindow.variable;

public class LargestArrayOfSumK {

    //All integers in array are positive

    public static int[] solve(int[] arr, int sum){
        int left=0;
        int right=0;
        int currSum=0;
        int i=0;
        int j=0;
        while(right < arr.length){
            currSum += arr[right];

            if(currSum == sum){
                if(right - left > j - i){
                    i=left;
                    j=right;
                }
            } else {
                while(currSum > sum && left <= right){
                    currSum -= arr[left];
                    left++;
                }
                //Check possibility of answer if currSum equals sum
                if(currSum == sum && (right - left) > (j - i) ){
                    i=left;
                    j=right;
                }
            }
            //Otherwise increasing window size (also in case of currSum < sum)
            right++;
        }
        if(j==i) return new int[0];
        int[] ans = new int[j - i + 1];
        for(int x=i, y=0; x<=j; x++, y++) ans[y]=arr[x];
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 1, 1, 2, 3, 5};
        int sum=5;
        int[] ans = solve(arr, sum);
        System.out.println("Largest subarray with sum = " + sum + " is :");
        printArray(ans);
    }

    public static void printArray(int[] A){
        for(int a : A){
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

}
