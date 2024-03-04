package codeforces;

import java.util.Scanner;

public class Helper {

    public void arrayInput() {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int[] A = new int[n];
            for(int i=0 ;i<n; i++ ){
                int num = sc.nextInt();
                A[i] = num;
            }
        }


    }

}
