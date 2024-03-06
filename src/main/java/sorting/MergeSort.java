package sorting;

public class MergeSort {

    public void merge(int[] A, int start, int mid, int end){

            int m = mid - start + 1;
            int n = end - mid;

        int[] a = new int[m];
        int[] b = new int[n];

        for(int i=start;i<=mid;i++){
            a[i-start] = A[i];
        }
        for(int i=mid+1;i<=end;i++){
            b[i-mid-1] = A[i];
        }

        int k=start, i=0, j=0;
        while(i<m && j<n){
            if(a[i] <= b[j]){
                A[k++] = a[i++];
            }else{
                A[k++] = b[j++];
            }
        }
        while(i<m){
            A[k++] = a[i++];
        }
        while(j<n){
            A[k++] = b[j++];
        }
    }

    public void sort(int[] a, int start, int end){
        int n = end-start+1;
        if(n==1) return;

        int mid = start + (end - start)/2;

        sort(a, start, mid);
        sort(a, mid+1, end);
        merge(a, start, mid, end);
    }


    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();

        int[] a = new int[]{1,3,5,7,9};
        int[] b = new int[]{2,4,6,8};

        int[] unsorted = new int[]{2,1,4,3,6,5,8,7};

        mergeSort.sort(unsorted, 0, unsorted.length-1);
        printArray(unsorted);
    }

    public static void printArray(int[] A){
        for(int a : A){
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }
}
