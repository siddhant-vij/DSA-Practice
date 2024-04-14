package myPackage.j2Maths;

import java.util.Scanner;

public class PrintAllDivisors {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int i;
      for (i = 1; i*i < N ; i++) {
        if (N % i == 0)
          System.out.print(i + " " );
      }
      for ( ; i>= 1 ; i--) {
        if (N % i == 0)
          System.out.print(N/i + " " );
      }
    }
  }
}
