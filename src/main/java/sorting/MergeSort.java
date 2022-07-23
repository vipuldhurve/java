package sorting;

public class MergeSort {

    public int[] merge(int[] a, int[] b){
        int m = a.length;
        int n = b.length;

        int[] merged = new int[m+n];

        int k=0, i=0, j=0;
        while(i<m && j<n){
            if(a[i] <= b[j]){
                merged[k++] = a[i++];
            }else{
                merged[k++] = b[j++];
            }
        }
        while(i<m){
            merged[k++] = a[i++];
        }

        while(j<m){
            merged[k++] = b[j++];
        }

        return merged;
    }


    public static void main(String[] args) {
        System.out.println("Hello World");



    }

    public void printArray(int[] A){
        for(int a : A){
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }
}
