package dsa.util;

public class Print {

    public static void print2DArray(int[][] arr){
        for(int[] x: arr){
            for(int y: x) System.out.print( y + "   ");
            System.out.println();
        }
    }
}
