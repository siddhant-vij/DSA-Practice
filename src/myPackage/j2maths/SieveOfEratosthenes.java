package myPackage.j2maths;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      boolean[] primes = new boolean[n + 1];
      Arrays.fill(primes, true);

      int count = 0;
      for (int i = 2; i <= n; i++) {
        if (primes[i]) {
          count++;
          for (int j = 2 * i; j <= n; j += i) {
            primes[j] = false;
          }
        }
      }
      System.out.println(count);
    }
  }
}