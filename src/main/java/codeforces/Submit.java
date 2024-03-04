package codeforces;

import java.math.BigInteger;
import java.util.Scanner;

public class Submit {

    public static long mod = 1000000007;
    public static BigInteger bigMod = BigInteger.valueOf(mod);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            System.out.println((2022*func(n))%mod);
        }
    }

    public static long func(int n){
        if(n == 0) return 0;
        long ans = 0;
        for(int i=n; i>=1; i--){
            long x = i%mod;
            ans += (x*x)%mod;
            ans += (x*(x-1))%mod;
        }
        return ans%mod;
    }
}
