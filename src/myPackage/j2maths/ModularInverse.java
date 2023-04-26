package myPackage.j2maths;

import java.util.Scanner;

public class ModularInverse {

  private static boolean isPrime(int n) {
    if (n == 1)
      return false;
    if (n == 2 || n == 3)
      return true;
    if (n % 2 == 0 || n % 3 == 0)
      return false;
    for (int i = 5; i * i <= n; i++) {
      if (n % i == 0 || n % (i + 2) == 0)
        return false;
    }
    return true;
  }

  private static int modularInverseNP(int a, int b, int t1, int t2) {
    if (b == 0)
      return t1;
    return modularInverseNP(b, a % b, t2, t1 - t2 * (a / b));
  }

  public static int modularInverseP(int x, int n) {
    int result = 1;
    int num = n;
    n = n - 2;
    while (n > 0) {
      if ((n & 1) == 1) {
        result = (result * x) % num;
      }
      n = n >> 1;
      x = (x * x) % num;
    }
    return result;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int a = sc.nextInt();
      int m = sc.nextInt();
      int b = m;
      int inverse = 0;
      if (isPrime(m))
        inverse = modularInverseP(a, m); // Fermat's Little Theorem
      else {
        if (a > m)
          inverse = modularInverseNP(a, m, 0, 1); // Extended Euclidean Algorithm
        else
          inverse = modularInverseNP(m, a, 0, 1); // Extended Euclidean Algorithm
      }
      System.out.println(inverse < 0 ? b + inverse : inverse);
    }
  }
}