package codeforces;

import java.util.Scanner;

public class Test {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] A = new int[n];
            for(int i=0; i<n; i++){
                A[i] = sc.nextInt();
            }
        }
    }

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = isBulky(length, width, height);
        boolean heavy = isHeavy(mass);

        if(bulky && heavy) return "Both";
        else if(bulky) return "Bulky";
        else if (heavy) return "Heavy";
        else return "Neither";
    }

    public boolean isBulky(int length, int width, int height){
        if(length>=10000 || width>=10000 || height>=10000) return true;
        return (long) length * width * height >= 1000000000L;
    }

    public boolean isHeavy(int mass){
        return mass >= 100;
    }
}
