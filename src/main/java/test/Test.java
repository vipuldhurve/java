package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            long n = sc.nextLong();
            boolean flag = false;
            int count=0;
            while(n%2 == 0){
                n=n/2;
                count++;
            }
            if(count%2==1){
                count--;
                n*=2;
            }

            int a = (int)Math.sqrt(n/2);
            int last = (int)Math.sqrt(n);
            while(a <= last){
                if(isPerfectSquare((n - (long) a*a))){
                    int b = (int) Math.sqrt(n - (long) a *a);
                    System.out.println(a*(int)Math.pow(2,count/2) + " " + b*(int)Math.pow(2,count/2));
                    flag= true;
                    break;
                } else{
                    a++;
                }
            }
            if(!flag) System.out.println("-1");
        }
    }

    public static boolean isPerfectSquare(long n){
        int x = (int)Math.sqrt(n);
        return Math.pow(x, 2) == n;
    }

}


