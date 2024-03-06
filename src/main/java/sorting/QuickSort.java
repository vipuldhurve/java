package sorting;

public class QuickSort {
    public static int partition(int[] arr, int start, int end){
        int pivot=arr[end];
        int pi=start-1;
        for(int j=start; j<end; j++){
            if(arr[j]<pivot){
                pi++;
                //swap
                int temp = arr[pi];
                arr[pi]=arr[j];
                arr[j]=temp;
            }
        }
        //Putting pivot in correct position
        pi++;
        int temp=arr[pi];
        arr[pi]=pivot;
        arr[end]=temp;
        return pi;
    }

    public static void quickSort(int[] arr, int start, int end){
        if(start<end){
            int pivotIdx = partition(arr, start, end);
            //sorting rest of the parts after putting pivot in correct position
            quickSort(arr, start, pivotIdx-1);
            quickSort(arr, pivotIdx+1, end);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,7,9};
        int[] b = new int[]{2,4,6,8};
        int[] unsorted = new int[]{2,1,4,3,6,5,8,7,9};
        quickSort(unsorted, 0, unsorted.length-1);
        printArray(unsorted);
    }

    public static void printArray(int[] A){
        for(int a : A){
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }
}
