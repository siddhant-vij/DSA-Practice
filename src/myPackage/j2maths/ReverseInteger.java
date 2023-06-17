package myPackage.j2maths;

import java.util.Scanner;

public class ReverseInteger {
    public static int reverseInteger(int n){
        int m = n;
        int sum = 0;
        while (m > 0)
        {
            int dig = m % 10;
            sum = sum*10 + dig;
            m/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();

            int[] N = new int[T];
            for (int i = 0; i < T; i++) {
                N[i] = sc.nextInt();
            }

            for (int i = 0; i < T; i++) {
                System.out.println(reverseInteger(N[i]));
            }
        }
    }
}