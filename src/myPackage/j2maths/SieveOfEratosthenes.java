package myPackage.j2maths;

import java.util.Scanner;

public class SieveOfEratosthenes {
  public static boolean isPrime(int n) {
    if (n == 1)
      return false;
    if (n != 2 && n % 2 == 0 || n != 3 && n % 3 == 0)
      return false;
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0)
        return false;
    }
    return true;
  }
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      /*boolean[] isPrime = new boolean[n+1];
      for (int i = 2; i <= n ; i++) {
        isPrime[i] = true;
      }*/
      for (int i = 2, j = i*i; i <= n || j <= n; i++, j+=i) {
        if (isPrime(i))
        {
          System.out.print(i + " ");
          /*for (int j = i*i; j <= n; j+=i); *//*{
            isPrime[j] = false;
          }*/
        }
      }
    }
  }
}