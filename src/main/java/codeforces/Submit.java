package codeforces;

import java.util.Scanner;

public class Submit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();

            char sign = '+';

            for(int i=1; i<n; i++){
                char c = s.charAt(i);
                if(c == '1'){
                    if(sign == '-'){
                        sign = '+';
                    } else {
                        sign = '-';
                    }
                }
                System.out.print(sign);
            }
            System.out.println("");
        }
    }
}
